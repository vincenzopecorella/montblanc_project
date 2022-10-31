package com.example.appli_watch.newalgo

enum class StateExercise {
    INIT {
        override fun nextState() = PRE_LOW
    },
    PRE_LOW {
        override fun nextState() = LOW
    },
    LOW {
        override fun nextState() = POST_LOW
    },
    POST_LOW {
        override fun nextState() = HALF_EXE
    },
    HALF_EXE {
        override fun nextState() = PRE_HIGH
    },
    PRE_HIGH {
        override fun nextState() = HIGH
    },
    HIGH {
        override fun nextState() = POST_HIGH
    },
    POST_HIGH {
        override fun nextState() = INIT
    };
    abstract fun nextState(): StateExercise
}