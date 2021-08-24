package com.example.getstarted

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

/** always use [AppCompatActivity] to get app available among the old versions */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /**
         * the class [R] is generated when app builds
         * the [R] class includes all the assets, contents of [res] directory
         * */
        setContentView(R.layout.activity_main)
        /** get the [Button] component from activity_main.xml */
        val rollButton: Button = findViewById(R.id.roll_button)
        /** set button click listener to [rollButton] */
        rollButton.setOnClickListener { rollDice() }
        /** get [TextView] component from xml*/
        val resultText: TextView = findViewById(R.id.result_text)
        resultText.text = 1.toString()
        /** CODE CHALLENGE: add Count up [Button] */
        val countUpButton: Button = findViewById(R.id.count_up_button)
        countUpButton.text = getString(R.string.count_up_label)
        countUpButton.setOnClickListener { resultText.text = countUp(Integer.parseInt(resultText.text as String)).toString() }
        /** HOMEWORK : add Reset [Button]*/
        val resetButton: Button = findViewById(R.id.reset_button)
        resetButton.text = getString(R.string.reset_label)
        resetButton.setOnClickListener { resultText.text = 0.toString() }
    }


    /** function to handle [rollButton] with [setOnClickListener] */
    private fun rollDice() {
        /** notice that [AppCompatActivity] is a subclass of [context] */
        Toast.makeText(this, "button clicked", Toast.LENGTH_SHORT).show()
    }

    /** function to handle counting up the [resultText] */
    private fun countUp(value: Int): Int = if (value < 6) value + 1 else value
}
