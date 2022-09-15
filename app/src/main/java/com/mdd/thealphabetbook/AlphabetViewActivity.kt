package com.mdd.thealphabetbook

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.mdd.thealphabetbook.MainActivity.HelpClickListener

class AlphabetViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alphabet_view)

        val overviewBtn = findViewById<Button>(R.id.button_overview)
        val firstBtn = findViewById<Button>(R.id.button_first)
        val lastBtn = findViewById<Button>(R.id.button_last)

        val helpClickListener = HelpClickListener()

        overviewBtn.setOnClickListener(helpClickListener)
        firstBtn.setOnClickListener(helpClickListener)
        lastBtn.setOnClickListener(helpClickListener)


    }

    fun nextActivity(){
        val intentAlphabet = Intent(this, MainActivity::class.java)
        startActivity(intentAlphabet)

    }

    inner class HelpClickListener : View.OnClickListener{
        override fun onClick(p0: View?) {

            val view = p0?.rootView
            when (p0?.id) {

                R.id.button_overview -> {

                    nextActivity()
                }
                R.id.button_first -> {
                    nextActivity()
                }
                R.id.button_last -> {
                    nextActivity()
                }

            }
        }
    }
}