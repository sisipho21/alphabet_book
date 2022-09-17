package com.mdd.thealphabetbook

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

open class MainActivity : AppCompatActivity(){

    val helperListener = MainHelpClickListener()
    var arrBtn = arrayOf<Button>()
    var btnValue = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val buttonA = findViewById<Button>(R.id.btn_a)
        val buttonB = findViewById<Button>(R.id.btn_b)
        val buttonC = findViewById<Button>(R.id.btn_c)
        val buttonD = findViewById<Button>(R.id.btn_d)
        val buttonE = findViewById<Button>(R.id.btn_e)
        val buttonF = findViewById<Button>(R.id.btn_f)
        val buttonG = findViewById<Button>(R.id.btn_g)
        val buttonH = findViewById<Button>(R.id.btn_h)
        val buttonI = findViewById<Button>(R.id.btn_i)
        val buttonJ = findViewById<Button>(R.id.btn_j)
        val buttonK = findViewById<Button>(R.id.btn_k)
        val buttonL = findViewById<Button>(R.id.btn_l)
        val buttonM = findViewById<Button>(R.id.btn_m)
        val buttonN = findViewById<Button>(R.id.btn_n)
        val buttonO = findViewById<Button>(R.id.btn_o)
        val buttonP = findViewById<Button>(R.id.btn_p)
        val buttonQ = findViewById<Button>(R.id.btn_q)
        val buttonR = findViewById<Button>(R.id.btn_r)
        val buttonS = findViewById<Button>(R.id.btn_s)
        val buttonT = findViewById<Button>(R.id.btn_t)
        val buttonU = findViewById<Button>(R.id.btn_u)
        val buttonV = findViewById<Button>(R.id.btn_v)
        val buttonW = findViewById<Button>(R.id.btn_w)
        val buttonX = findViewById<Button>(R.id.btn_x)
        val buttonY = findViewById<Button>(R.id.btn_y)
        val buttonZ = findViewById<Button>(R.id.btn_z)

        arrayOf<Button>(buttonA, buttonB, buttonC, buttonD, buttonE, buttonF, buttonG, buttonH, buttonI, buttonJ, buttonK, buttonL,
            buttonM, buttonN, buttonO, buttonP, buttonQ, buttonR, buttonS, buttonT, buttonU, buttonV, buttonW, buttonX, buttonY, buttonZ).also { arrBtn = it }

        activateListener(arrBtn)
    }

    fun activateListener(array: Array<Button>){
        for (x in array){
            x.setOnClickListener(helperListener)
        }
    }

    fun nextActivity(){
        val intentAlphabet = Intent( this, AlphabetViewActivity::class.java)
        intentAlphabet.putExtra("intName",btnValue)
        startActivity(intentAlphabet)
    }



    inner class MainHelpClickListener : View.OnClickListener, AppCompatActivity(){
        /** This inner class works as a controller between the view(Main Activity) and the model (AlphabetView Activity)*/

        override fun onClick(p0: View?) {

            when (p0?.id) {

                R.id.btn_a ->{
                    btnValue = 0
                }
                R.id.btn_b ->{
                    btnValue = 1
                }
                R.id.btn_c ->{
                    btnValue = 2
                }
                R.id.btn_d ->{
                    btnValue = 3
                }
                R.id.btn_e -> {
                    btnValue = 4
                }
                R.id.btn_f ->{
                    btnValue = 5
                }
                R.id.btn_g ->{
                    btnValue = 6
                }
                R.id.btn_h ->{
                    btnValue = 7
                }
                R.id.btn_i ->{
                    btnValue = 8
                }
                R.id.btn_j -> {
                    btnValue = 9
                }
                R.id.btn_k ->{
                    btnValue = 10
                }
                R.id.btn_l ->{
                    btnValue = 11
                }
                R.id.btn_m ->{
                    btnValue = 12
                }
                R.id.btn_n ->{
                    btnValue = 13
                }
                 R.id.btn_o -> {
                    btnValue = 14
                }
                R.id.btn_p ->{
                    btnValue = 15
                }
                R.id.btn_q ->{
                    btnValue = 16
                }
                R.id.btn_r ->{
                    btnValue = 17
                }
                R.id.btn_s ->{
                    btnValue = 18
                }
                R.id.btn_t -> {
                    btnValue = 19
                }
                R.id.btn_u ->{
                    btnValue = 20
                }
                R.id.btn_v ->{
                    btnValue = 21
                }
                R.id.btn_w ->{
                    btnValue = 22
                }
                R.id.btn_x ->{
                    btnValue = 23
                }
                R.id.btn_y ->{
                    btnValue = 24
                }
                R.id.btn_z -> {
                    btnValue = 25

                }
            }
            nextActivity()
        }
    }


}