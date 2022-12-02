package com.example.appli_watch.utils

import android.content.Context
import android.content.Intent
import com.example.appli_watch.MainActivity
import com.example.appli_watch.Menu.End
import com.example.appli_watch.exercises.*

class Next() {

    public fun getNextExercise(context: Context, Nextexercise: String, NextRep: Int, time_ini: Int): Intent {
        var intent_next = Intent()
        if(Nextexercise=="End"){
            intent_next = Intent(context, End::class.java)
            intent_next.putExtra("Time_ini", time_ini)
        }
        else if(Nextexercise=="Rest") {
            intent_next = Intent(context, BreakActivity::class.java)
            intent_next.putExtra("Timeselection", NextRep)
            intent_next.putExtra("ExercisesName", Nextexercise)
            intent_next.putExtra("Time_ini", time_ini)
        }
        else if(Nextexercise=="Squats"){
            intent_next = Intent(context, Squats::class.java)
            intent_next.putExtra("maxRepetitions", NextRep)
            intent_next.putExtra("ExercisesName", Nextexercise)
            intent_next.putExtra("Time_ini", time_ini)
        }
        else if(Nextexercise=="Jumping Jacks"){
            intent_next = Intent(context, JumpingJacks::class.java)
            intent_next.putExtra("maxRepetitions", NextRep)
            intent_next.putExtra("ExercisesName", Nextexercise)
            intent_next.putExtra("Time_ini", time_ini)
        }
        else if(Nextexercise=="Dead Bugs"){
            intent_next = Intent(context, DeadBug::class.java)
            intent_next.putExtra("maxRepetitions", NextRep)
            intent_next.putExtra("ExercisesName", Nextexercise)
            intent_next.putExtra("Time_ini", time_ini)
        }
        else if(Nextexercise=="Lunges"){
            intent_next = Intent(context, Lunges::class.java)
            intent_next.putExtra("maxRepetitions", NextRep)
            intent_next.putExtra("ExercisesName", Nextexercise)
            intent_next.putExtra("Time_ini", time_ini)
        }
        else if(Nextexercise=="Bird Dogs"){
            intent_next = Intent(context, BirdDogs::class.java)
            intent_next.putExtra("maxRepetitions", NextRep)
            intent_next.putExtra("ExercisesName", Nextexercise)
            intent_next.putExtra("Time_ini", time_ini)
        }
        else if(Nextexercise=="Sit Ups"){
            intent_next = Intent(context, Situps::class.java)
            intent_next.putExtra("maxRepetitions", NextRep)
            intent_next.putExtra("ExercisesName", Nextexercise)
            intent_next.putExtra("Time_ini", time_ini)
        }
        else if(Nextexercise=="Push Ups"){
            intent_next = Intent(context, TimeTrackedActivity::class.java)
            intent_next.putExtra("Timeselection", NextRep)
            intent_next.putExtra("ExercisesName", Nextexercise)
            intent_next.putExtra("Time_ini", time_ini)
        }
        else if(Nextexercise=="Board"){
            intent_next = Intent(context, TimeTrackedActivity::class.java)
            intent_next.putExtra("Timeselection", NextRep)
            intent_next.putExtra("ExercisesName", Nextexercise)
            intent_next.putExtra("Time_ini", time_ini)
        }
        else if(Nextexercise=="High Knees"){
            intent_next = Intent(context, TimeTrackedActivity::class.java)
            intent_next.putExtra("Timeselection", NextRep)
            intent_next.putExtra("ExercisesName", Nextexercise)
            intent_next.putExtra("Time_ini", time_ini)
        }
        else if(Nextexercise=="Butt Kicks"){
            intent_next = Intent(context, TimeTrackedActivity::class.java)
            intent_next.putExtra("Timeselection", NextRep)
            intent_next.putExtra("ExercisesName", Nextexercise)
            intent_next.putExtra("Time_ini", time_ini)
        }
        else if(Nextexercise=="Dips"){
            intent_next = Intent(context, TimeTrackedActivity::class.java)
            intent_next.putExtra("Timeselection", NextRep)
            intent_next.putExtra("ExercisesName", Nextexercise)
            intent_next.putExtra("Time_ini", time_ini)
        }
        else if(Nextexercise=="Climbers"){
            intent_next = Intent(context, TimeTrackedActivity::class.java)
            intent_next.putExtra("Timeselection", NextRep)
            intent_next.putExtra("ExercisesName", Nextexercise)
            intent_next.putExtra("Time_ini", time_ini)
        }
        else if(Nextexercise=="Arm Circles"){
            intent_next = Intent(context, TimeTrackedActivity::class.java)
            intent_next.putExtra("Timeselection", NextRep)
            intent_next.putExtra("ExercisesName", Nextexercise)
            intent_next.putExtra("Time_ini", time_ini)
        }
        else{
            intent_next = Intent(context, MainActivity::class.java)
        }

        return intent_next


    }

}