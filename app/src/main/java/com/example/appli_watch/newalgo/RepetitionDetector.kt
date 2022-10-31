package com.example.appli_watch.newalgo

import android.hardware.Sensor
import android.hardware.SensorEvent
import kotlin.math.pow
import kotlin.math.sqrt

class RepetitionDetector(private val exercise: Exercise) {
    private var startTimeRepetition: Float = 0.0f
    private var endTimeRepetition: Float = 0.0f
    private var currentTimeRepetition: Float = 0.0f
    private var currentAccelerometer: FloatArray = FloatArray(3){0.0f}
    private var currentGravity: FloatArray = FloatArray(3){0.0f}
    public var state: StateExercise = StateExercise.INIT
    private var exercisesConstantsRepo: ExercisesConstantsRepo = ExercisesConstantsRepo(exercise)
    private var numberOfRepetitions: Int = 0


    public fun update(event: SensorEvent?){
        if(event?.sensor?.type == Sensor.TYPE_LINEAR_ACCELERATION){
            updateAcceleration(event)
        }
        if(event?.sensor?.type == Sensor.TYPE_GRAVITY){
            updateGravity(event)
        }
        changeState()
    }

    public fun getNumberOfRepetitions(): Int{
        return numberOfRepetitions
    }

    private fun updateAcceleration(event: SensorEvent?){
        if (event != null) {
            currentTimeRepetition = event.timestamp.toFloat()
            currentAccelerometer[0] = event.values[0]
            currentAccelerometer[1] = event.values[1]
            currentAccelerometer[1] = event.values[2]
        }
    }
    private fun updateGravity(event: SensorEvent?){
        if (event != null) {
            currentGravity[0] = event.values[0]
            currentGravity[1] = event.values[1]
            currentGravity[1] = event.values[2]
        }
    }

    public fun computeCurrentAccelerationVector(): Float{
        val gravityModule = sqrt(currentGravity[0].pow(2)+currentGravity[1].pow(2)+currentGravity[2].pow(2))
        var accVector: Float = 0.0f
        for(i in 0..2){
            accVector += -(currentGravity[i] * currentAccelerometer[i]) / gravityModule
        }
        return accVector
    }

    private fun changeState() {
        when(state){
            StateExercise.INIT ->{
                if(computeCurrentAccelerationVector()< exercisesConstantsRepo.getConstantsExercise().first){
                    state = state.nextState()
                }
            }

            StateExercise.LOWPEAK->{
                if(computeCurrentAccelerationVector()> exercisesConstantsRepo.getConstantsExercise().first){
                    state = state.nextState()
                }
            }

            StateExercise.MID_START->{
                startTimeRepetition = currentTimeRepetition
                state = state.nextState()
            }

            StateExercise.MID_END->{
                endTimeRepetition = currentTimeRepetition
                if(computeCurrentAccelerationVector()> exercisesConstantsRepo.getConstantsExercise().second){
                    if((endTimeRepetition - startTimeRepetition) > exercisesConstantsRepo.getConstantsExercise().third){
                        state = state.nextState()
                    }
                    else{
                        state = StateExercise.INIT
                    }
                }
            }

            StateExercise.HIGHPEAK->{
                if(computeCurrentAccelerationVector()< exercisesConstantsRepo.getConstantsExercise().second){
                    state = state.nextState()
                    numberOfRepetitions +=1
                }
            }
        }
    }
}