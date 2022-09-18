package com.mdd.thealphabetbook

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlin.properties.Delegates

class AlphabetViewActivity : AppCompatActivity() {
    private var arrPictures = arrayOf<Int>()
    private lateinit var sharedP : SharedPreferences
    private lateinit var sharedEdt : SharedPreferences.Editor
    private lateinit var helpClickListener : AlphabetHelpClickListener
    private var value =0
    private var flag by Delegates.notNull<Boolean>()

    /** Overrides the onCreate() method to instantiate objects of buttons, the imageView and the inner class
     * It stores the pictures to be displayed by the imageView in an array and calls the changeImage() method to display a different image
     * @see changeImage
     * @see AlphabetHelpClickListener*/
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alphabet_view)
        val intent = intent
        value = intent.getIntExtra("intName", 0)

        flag = intent.getBooleanExtra("main", true)

        sharedP = getSharedPreferences("data", Context.MODE_PRIVATE)
        sharedEdt = sharedP.edit()

        val overviewBtn = findViewById<Button>(R.id.button_overview)
        val firstBtn = findViewById<Button>(R.id.button_first)
        val lastBtn = findViewById<Button>(R.id.button_last)
        val previousBtn = findViewById<Button>(R.id.imageButton_previous)
        val nextBtn = findViewById<Button>(R.id.imageButton_next)
        val imgView = findViewById<ImageView>(R.id.imageView)

        helpClickListener = AlphabetHelpClickListener(imgView, value)

        overviewBtn.setOnClickListener(helpClickListener)
        firstBtn.setOnClickListener(helpClickListener)
        lastBtn.setOnClickListener(helpClickListener)
        previousBtn.setOnClickListener(helpClickListener)
        nextBtn.setOnClickListener(helpClickListener)

        arrPictures = arrayOf(R.drawable.slide01, R.drawable.slide02, R.drawable.slide03, R.drawable.slide04, R.drawable.slide05, R.drawable.slide06, R.drawable.slide07, R.drawable.slide08, R.drawable.slide09,
            R.drawable.slide10, R.drawable.slide11, R.drawable.slide12, R.drawable.slide13, R.drawable.slide14, R.drawable.slide15, R.drawable.slide16, R.drawable.slide17,
            R.drawable.slide18, R.drawable.slide19, R.drawable.slide20, R.drawable.slide21, R.drawable.slide22, R.drawable.slide23, R.drawable.slide24, R.drawable.slide25, R.drawable.slide26)

        changeImage(imgView, value)

    }

    /** Changes the image displayed in the view into a different image, depending on the button clicked
     * @param view is the imageView object that the picture will be viewed on
     * @param num is the array index of the picture to be displayed on the imageView given*/
    fun changeImage(view: ImageView, num: Int){
        view.setImageResource(arrPictures[num])
    }

    /** Uses an intent to move from this activity to MainActivity */
    fun nextActivity(){
        val intentAlphabet = Intent(this, MainActivity::class.java)
        startActivity(intentAlphabet)
    }

    /** Overrides the OnPause() method to save the current image that the imageView is displaying when the app is paused
     * @see sharedEdt*/
    override fun onPause() {
        super.onPause()
        val currentCounter = helpClickListener.counter
        sharedEdt.putInt("the_view", currentCounter)
        sharedEdt.commit()
    }

    /** Overrides the onStop() method to save the current image that the imageView is displaying when the app is stopped
     * @see sharedEdt*/
    override fun onStop() {
        super.onStop()
        val currentCounter = helpClickListener.counter
        sharedEdt.putInt("the_view", currentCounter)
        sharedEdt.commit()
    }

    /** Overrides the onDestroy() method to save the current image that the imageView is displaying when the app is destroyed
     * @see sharedEdt*/
    override fun onDestroy() {
        super.onDestroy()
        val currentCounter = helpClickListener.counter
        sharedEdt.putInt("the_view", currentCounter)
        sharedEdt.commit()
    }

    /** Overrides the onStart() method to obtain and start app on the last image or activity it was on when the app was paused, stopped, or destroyed
     * @see changeImage
     * @see sharedP
     * @see sharedEdt*/
    override fun onStart() {
        super.onStart()
        val imgView = findViewById<ImageView>(R.id.imageView)

        val count = if (flag){
            value
        } else {
            helpClickListener.counter
        }
        changeImage(imgView, count)//sharedP.getInt("the_view", count))
        sharedEdt.clear()
        sharedEdt.commit()
    }

    inner class AlphabetHelpClickListener (val imageView: ImageView, var counter: Int): View.OnClickListener{

        /** Overrides the OnClick() method by calling the appropriate method of the super class, depending on the button clicked.
         * Also changes the counter to correspond to the array index of the image displayed
         * @see nextActivity
         * @see changeImage*/
        override fun onClick(p0: View?) {

            when (p0?.id) {

                R.id.button_overview -> {
                    nextActivity()
                }
                R.id.button_first -> {
                    counter = 0
                    changeImage(imageView, counter)
                }
                R.id.button_last -> {
                    counter = 25
                    changeImage(imageView, counter)
                }
                R.id.imageButton_previous -> {
                    if (counter == 0){ //Let the user know they are on the first letter
                        Toast.makeText(this@AlphabetViewActivity, "A is the first letter", Toast.LENGTH_LONG).show()
                    }
                    counter--
                    changeImage(imageView, counter)

                }
                R.id.imageButton_next -> {
                    if (counter < 25) {
                        counter++
                        changeImage(imageView, counter)
                    }
                    else { //Let the user know they are on the last letter
                        Toast.makeText(this@AlphabetViewActivity, "Z is the last letter", Toast.LENGTH_LONG).show()
                    }
                }

            }
        }
    }
}