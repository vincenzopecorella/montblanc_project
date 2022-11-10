package com.example.appli_watch.utils

import android.hardware.Sensor
import android.hardware.SensorEvent
import kotlin.math.pow
import kotlin.math.sqrt

class RepetitionDetector(private val exercise: Exercise) {
    //FILO buffers
    //to be changed later on
    var dataAccAll = Array(6) { mutableListOf(0.0) }
    var integralDataAll = Array(6) { mutableListOf(0.0) }

    //end of to be changed later on

    var accelData = mutableListOf(0.0)
    var integralData = mutableListOf(0.0)
    var corr: Double = 0.0

    //working variables
    var nbSquats = 0
    var waiting = false
    var waitCountdown = 0
    val index = 0
    val G_CONST = 9.81

    private var currentTimeRepetition: Float = 0.0f
    private var currentAccelerometer: FloatArray = FloatArray(3){0.0f}
    public var currentGravity: FloatArray = FloatArray(3){0.0f}
    private var exercisesConstantsRepo: ExercisesConstantsRepo = ExercisesConstantsRepo(exercise)
    private var numberOfRepetitions: Int = 0
    public var maxAcc: Float = 0.0f
    public var minAcc: Float = 0.0f

    //debug vars = can be removed at the end
    var dataAccumulator = mutableListOf(0.0)
    //end of debug vars


    public fun update(event: SensorEvent?){
        if(event?.sensor?.type == Sensor.TYPE_LINEAR_ACCELERATION){
            updateAcceleration(event)
        }
        if(event?.sensor?.type == Sensor.TYPE_GRAVITY){
            updateGravity(event)
        }
        patternReco()
    }

    public fun getNumberOfRepetitions(): Int{
        return numberOfRepetitions
    }

    private fun updateAcceleration(event: SensorEvent?){
        if (event != null) {
            currentTimeRepetition = event.timestamp.toFloat()
            currentAccelerometer[0] = event.values[0]
            currentAccelerometer[1] = event.values[1]
            currentAccelerometer[2] = event.values[2]
        }
    }
    private fun updateGravity(event: SensorEvent?){
        if (event != null) {
            currentGravity[0] = event.values[0]
            currentGravity[1] = event.values[1]
            currentGravity[2] = event.values[2]
        }
    }

    public fun computeCurrentAccelerationVector(): Float{
        val gravityModule = sqrt(currentGravity[0].pow(2)+currentGravity[1].pow(2)+currentGravity[2].pow(2))
        var accVector: Float = 0.0f
        for(i in 0..2){
            accVector += -(currentGravity[i] * currentAccelerometer[i]) / gravityModule
        }
        /*
        if(maxAcc < accVector){
            maxAcc = accVector
        }
        if(minAcc > accVector){
            minAcc = accVector
        }
         */
        return accVector
    }

    private fun patternReco() {
        //specific data to load
        val allConsts: MutableList<Any> = exercisesConstantsRepo.getConstantsExercise()

        val sampleIntegAll = allConsts[0] as Array<Array<Double>>//add new field to import in allConsts
        val COUNTDOWN: Int = allConsts[1] as Int
        val TRESHOLD_CORREl: Double = allConsts[2] as Double
        val rangeDim: Array<Int> = allConsts[3] as Array<Int>
        val dimension: Int = allConsts[4] as Int
        val IntegIndexDim: Array<Int> = allConsts[5] as Array<Int>
        val indexCorrAll: Array<Int> = allConsts[6] as Array<Int>//add new field to import in allConsts
        val GREATEST_PEAK_WIDTH = allConsts[7] as Int
        val GREATEST_SAMPLE_SIZE = allConsts[8] as Int

        //fill dataAccAll, check function def for extra info
        addData(dataAccAll, computeCurrentAccelerationVector().toDouble()/G_CONST, computeCurrentAccelerationVector().toDouble()/G_CONST)

        if (dataAccAll[0].size >= GREATEST_PEAK_WIDTH + 2) { //wait for all dimensions of dataAccAll to have sufficient amount of points to start integration
            //start dimension-respective integration to reduce noise in signal
            for(i in 0 until dimension) {
                integralDataAll[i].add(integrate_on_range(dataAccAll[i],rangeDim[i],IntegIndexDim[i]))
            }

            if (integralDataAll[0].size >= GREATEST_SAMPLE_SIZE + 2) { //size condition to proceed to correlation

                //dataAll: Array<MutableList<Double>>, sample: Array<Array<Double>>, indexList: Array<Int>, dimension: Int
                corr = corr_mix(integralDataAll,sampleIntegAll, indexCorrAll,dimension)

                if ((!waiting) && (corr_mix(integralDataAll,sampleIntegAll, indexCorrAll,dimension) > TRESHOLD_CORREl)) { //correlation performed + result compared to treshold value
                    //if threshold is exceeded, squat number is incremented and detection is deactivated for inBetweenSquatsWaitTime
                    numberOfRepetitions += 1
                    waiting = true
                    waitCountdown = COUNTDOWN
                }
                if (waiting) {
                    waitCountdown -= 1
                    if (waitCountdown <= 0) waiting = false
                }
                removeData(integralDataAll,dimension) //remove oldest data from integralAllData
            }
            removeData(dataAccAll,dimension)//remove oldest data from dataAccAll
        }

        /*
        //specific data to load
        val allConsts: MutableList<Any> = exercisesConstantsRepo.getConstantsExercise()
        val corrDataSample: Array<Double> = allConsts[0] as Array<Double>
        val inBetweenSquatsWaitTime: Int = allConsts[1] as Int
        val TRESHOLD_CORREl_SQUAT: Double = allConsts[2] as Double
        val PEAK_WIDTH: Int = allConsts[3] as Int
        val G_CONST: Double = allConsts[4] as Double


        accelData.add(computeCurrentAccelerationVector().toDouble()/G_CONST) //loading accel data

        //dataAccumulator.add(accelData.last()) //debug line(to delete later)

        //idea to improve a little: if detects an acceleration vector projected on (x,y) plane larger than a given treshold value, do not count the squat (would be a movement away from z axis != squat movement)


        if (accelData.size >= PEAK_WIDTH + 2) { //wait accelData to be filled enough to integrate on specified peak width window

            integralData.add(integrate_on_range(accelData,PEAK_WIDTH,index))

            if (integralData.size >= corrDataSample.size + 2) { //size condition to proceed to correlation

                corr = xcorr(integralData,corrDataSample,index)
                if ((!waiting) && (xcorr(integralData,corrDataSample,index) > TRESHOLD_CORREl_SQUAT)) { //correlation performed + result compared to treshold value
                    //if threshold is exceeded, squat number is incremented and detection is deactivated for inBetweenSquatsWaitTime
                    numberOfRepetitions += 1
                    waiting = true
                    waitCountdown = inBetweenSquatsWaitTime

                    //save1 = integrate_on_range(accelData,PEAK_WIDTH,index)
                    //save2 = xcorr(integralData,corrDataSample,index)
                }
                if (waiting) {
                    //square.text = "Squats :\n ${numberOfRepetitions}"

                    waitCountdown -= 1
                    if (waitCountdown <= 0) waiting = false
                }
                integralData.removeAt(0)
            }
            accelData.removeAt(0) //remove oldest data element
        }
        */
    }
}

fun corr_mix(dataAll: Array<MutableList<Double>>, sample: Array<Array<Double>>, indexList: Array<Int>, dimension: Int): Double {    //returns the product of the values of correlations performed in different dimensions of dataAll with their respective samples in sample
    var mult_corr = 1.0
    for (i in 0 until dimension) {
        mult_corr *= xcorr(dataAll[i],sample[i],indexList[i])
    }
    return mult_corr
}

fun removeData(data: Array<MutableList<Double>>,last_dim_to_remove: Int): Unit { //removes the first data point of each of the mutableLists of data
    for (i in 0 until last_dim_to_remove) {
        data[i].removeAt(0)
    }
}

fun addData(data: Array<MutableList<Double>>, vararg input: Double): Unit { //input: put all data to be filled in their respective dimension in order, ex dataAccAll[0] = X, dataAccAll[1] = Y, then call initData(dataAccAll, X_value, Y_value)
    var i = 0
    for (item in input) {
        data[i].add(item)
        i += 1
    }
}

fun integrate_on_range(data: MutableList<Double>, range: Int, index: Int): Double { //integrates data from index to index + range
    var integral_sum = 0.0
    for (i in index until range + index - 1) {
        integral_sum += data[i]
    }
    return integral_sum
}

fun xcorr(base: MutableList<Double>, sample: Array<Double>, index: Int): Double {   //applies correlation analysis on base with sample starting at base[index]
    var correlSum = 0.0
    for (i in sample.indices) {
        correlSum += sample[i] * base[i+index]
    }
    return correlSum
}
