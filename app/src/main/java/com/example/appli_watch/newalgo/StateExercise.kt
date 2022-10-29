package com.example.appli_watch.newalgo

enum class StateExercise {
    INIT {
        override fun nextState() = LOWPEAK
    },
    LOWPEAK {
        override fun nextState() = HIGHPEAK
    },
    HIGHPEAK {
        override fun nextState() = INIT
    };
    abstract fun nextState(): StateExercise
}