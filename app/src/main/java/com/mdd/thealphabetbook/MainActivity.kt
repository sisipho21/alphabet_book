package com.mdd.thealphabetbook

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity(){

//val arrBtns = arrayOf<Button>(findViewById<Button>(R.id.button4), findViewById<Button>(R.id.button5), findViewById<Button>(R.id.button6))
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val buttonA = findViewById<Button>(R.id.button4)
        val buttonB = findViewById<Button>(R.id.button5)
        val buttonC = findViewById<Button>(R.id.button6)
        val buttonD = findViewById<Button>(R.id.button7)
        val buttonE = findViewById<Button>(R.id.button8)

        val helpClickListener = HelpClickListener()


        buttonA.setOnClickListener(helpClickListener)
        buttonB.setOnClickListener(helpClickListener)
        buttonC.setOnClickListener(helpClickListener)
        buttonD.setOnClickListener(helpClickListener)
        buttonE.setOnClickListener(helpClickListener)

    }

    fun nextActivity(){
        val intentAlphabet = Intent(this, AlphabetViewActivity::class.java)
        startActivity(intentAlphabet)

    }

    inner class HelpClickListener : View.OnClickListener{
        override fun onClick(p0: View?) {

            val view = p0?.rootView
            when (p0?.id) {

                R.id.button4, R.id.button5, R.id.button6, R.id.button7 -> {

                    nextActivity()
                }
                R.id.button8 -> {
                    nextActivity()
                }
            }
        }
    }


}