package com.mdd.thealphabetbook

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class AlphabetViewActivity : AppCompatActivity() {
    var arrPictures = arrayOf<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alphabet_view)
        val intent = intent
        val value = intent.getIntExtra("intName", 0)

        val overviewBtn = findViewById<Button>(R.id.button_overview)
        val firstBtn = findViewById<Button>(R.id.button_first)
        val lastBtn = findViewById<Button>(R.id.button_last)
        val imgView = findViewById<ImageView>(R.id.imageView)

        val helpClickListener = AlphabetHelpClickListener(imgView)

        overviewBtn.setOnClickListener(helpClickListener)
        firstBtn.setOnClickListener(helpClickListener)
        lastBtn.setOnClickListener(helpClickListener)

        arrPictures = arrayOf<Int>(R.drawable.slide01, R.drawable.slide02, R.drawable.slide03, R.drawable.slide04, R.drawable.slide05, R.drawable.slide06, R.drawable.slide07, R.drawable.slide08, R.drawable.slide09,
            R.drawable.slide10, R.drawable.slide11, R.drawable.slide12, R.drawable.slide13, R.drawable.slide14, R.drawable.slide15, R.drawable.slide16, R.drawable.slide17,
            R.drawable.slide18, R.drawable.slide19, R.drawable.slide20, R.drawable.slide21, R.drawable.slide22, R.drawable.slide23, R.drawable.slide24, R.drawable.slide25, R.drawable.slide26)

        changeImage(imgView, value)

    }

    fun changeImage(view: ImageView, num: Int){
        view.setImageResource(arrPictures[num])
    }

    fun nextActivity(){
        val intentAlphabet = Intent(this, MainActivity::class.java)
        startActivity(intentAlphabet)
    }

    inner class AlphabetHelpClickListener (val imageView: ImageView): View.OnClickListener{
        override fun onClick(p0: View?) {

            val view = p0?.rootView
            when (p0?.id) {

                R.id.button_overview -> {
                    nextActivity()
                }
                R.id.button_first -> {
                    changeImage(imageView, 0)
                }
                R.id.button_last -> {
                    changeImage(imageView, 25)
                }

            }
        }
    }
}