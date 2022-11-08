package com.example.appli_watch.utils

import android.hardware.Sensor
import android.hardware.SensorEvent
import com.example.appli_watch.state_algo.StateExercise
import kotlin.math.pow
import kotlin.math.sqrt

class RepetitionDetector(private val exercise: Exercise) {
    private var startTimeRepetition: Float = 0.0f
    private var endTimeRepetition: Float = 0.0f
    private var currentTimeRepetition: Float = 0.0f
    private var currentAccelerometer: FloatArray = FloatArray(3){0.0f}
    public var currentGravity: FloatArray = FloatArray(3){0.0f}
    public var state: StateExercise = StateExercise.INIT
    private var exercisesConstantsRepo: ExercisesConstantsRepo = ExercisesConstantsRepo(exercise)
    private var numberOfRepetitions: Int = 0
    public var maxAcc: Float = 0.0f
    public var minAcc: Float = 0.0f


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
        if(maxAcc < accVector){
            maxAcc = accVector
        }
        if(minAcc > accVector){
            minAcc = accVector
        }
        return accVector
    }

    private fun patternReco() {
        //FILO buffers
        var accelData = mutableListOf(0.0)
        var integralData = mutableListOf(0.0)
        //working variables
        var nbSquats = 0
        var waiting = false
        var waitCountdown = 0
        val index = 0
        //specific data to load
        val allConsts: MutableList<Any> = exercisesConstantsRepo.getConstantsExercise()
        val corrDataSample = allConsts[0]
        val inBetweenSquatsWaitTime = allConsts[1]
        val TRESHOLD_CORREl_SQUAT = allConsts[2]
        val PEAK_WIDTH = allConsts[3]
        val G_CONST = allConsts[4]

        accelData.add(computeCurrentAccelerationVector().toDouble()/G_CONST)

        //idea to improve a little: if detects an acceleration vector projected on (x,y) plane larger than a given treshold value, do not count the squat (would be a movement away from z axis != squat movement)


        if (accelData.size >= PEAK_WIDTH + 2) { //wait to be filled enough to make a correlation with the sample

            integralData.add(integrate_on_range(accelData,PEAK_WIDTH,index))

            if (integralData.size >= corrDataSample.size + 2) {
                if ((!waiting) && (xcorr(integralData,corrDataSample,index) > TRESHOLD_CORREl_SQUAT)) {
                    numberOfRepetitions += 1
                    waiting = true
                    waitCountdown = inBetweenSquatsWaitTime

                    //save1 = integrate_on_range(accelData,PEAK_WIDTH,index)
                    //save2 = xcorr(integralData,corrDataSample,index)
                }
                if (waiting) {
                    //square.text = "Squats :\n ${numberOfRepetitions}"//"Squats :\n ${nbSquats}, ${save1}, ${save2}"

                    waitCountdown -= 1
                    if (waitCountdown <= 0) waiting = false
                }
                integralData.removeAt(0)
            }
            accelData.removeAt(0) //remove oldest data element
        }
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