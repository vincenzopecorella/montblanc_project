package com.example.appli_watch.newalgo

enum class StateExercise {
    INIT {
        override fun nextState() = LOWPEAK
    },
    LOWPEAK {
        override fun nextState() = MID_START
    },
    MID_START {
        override fun nextState() = MID_END
    },
    MID_END {
        override fun nextState() = HIGHPEAK
    },
    HIGHPEAK {
        override fun nextState() = INIT
    };
    abstract fun nextState(): StateExercise
}