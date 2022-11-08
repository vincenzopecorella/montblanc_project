package com.example.appli_watch.utils

class ExercisesConstantsRepo(private val exercise: Exercise) {
    // Put here all the constants for peak tracking of different exercises
    private val squatMidMin: Float = -1.0f
    private val squatMin: Float = -5.0f
    private val squatMidMax: Float = 1.0f
    private val squatMax: Float = 4.0f
    private val squatRepetitionTime: Float = 30000000.0f

    public fun getConstantsExercise(): FloatArray {
        if(exercise == Exercise.SQUAT){
            return floatArrayOf(squatMidMin, squatMin, squatMidMax, squatMax, squatRepetitionTime)
        }
        return floatArrayOf(0f, 0f, 0f, 0f, 0f)
    }
}