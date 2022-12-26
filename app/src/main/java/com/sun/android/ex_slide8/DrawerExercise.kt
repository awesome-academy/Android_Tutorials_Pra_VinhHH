package com.sun.android.ex_slide8

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Menu;
import android.view.MenuItem;
import androidx.appcompat.app.AppCompatDelegate
import com.sun.android.R
import com.sun.android.databinding.ActivityDrawerExerciseBinding



class DrawerExercise : AppCompatActivity() {
    private val binding by lazy {
        ActivityDrawerExerciseBinding.inflate(layoutInflater)
    }
    private var STATE_SCORE_1: String = "Team 1 Score"
    private var STATE_SCORE_2: String = "Team 2 Score"
    private var mScore1 = 0
    private var mScore2 = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
    fun decreaseScore(view: View) {
        when (view.id) {
            binding.decreaseTeam1.id -> {
                mScore1--
                binding.scoreTeam1.text = mScore1.toString()
            }
            binding.decreaseTeam2.id -> {
                mScore2--
                binding.scoreTeam2.text = mScore2.toString()
            }
        }
    }
    fun increaseScore(view: View){
        when (view.id) {
            binding.increaseTeam1.id -> {
                mScore1++
                binding.scoreTeam1.text = mScore1.toString()
            }
            binding.increaseTeam2.id -> {
                mScore2++
                binding.scoreTeam2.text = mScore2.toString()
            }
        }
    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        val nightMode: Int = AppCompatDelegate.getDefaultNightMode()
        if (nightMode == AppCompatDelegate.MODE_NIGHT_YES) {
            menu.findItem(R.id.night_mode).setTitle(R.string.day_mode)
        } else {
            menu.findItem(R.id.night_mode).setTitle(R.string.night_mode)
        }
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.night_mode) {
            val nightMode: Int = AppCompatDelegate.getDefaultNightMode()
            if (nightMode == AppCompatDelegate.MODE_NIGHT_YES) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            }
            recreate()
        }
        return true
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(STATE_SCORE_1, mScore1)
        outState.putInt(STATE_SCORE_2, mScore2)
    }

}
