package com.example.appli_watch.newalgo

class ExercisesConstantsRepo(private val exercise: Exercise) {
    // Put here all the constants for peak tracking of different exercises
    private val squatMin: Float = -2.0f
    private val squatMax: Float = 2.0f
    private val squatRepetitionTime: Float = 1000000000.0f

    public fun getConstantsExercise(): Triple<Float, Float, Float> {
        if(exercise == Exercise.SQUAT){
            return Triple(squatMin, squatMax, squatRepetitionTime)
        }
        return Triple(0.0f, 0.0f, 0.0f)
    }
}