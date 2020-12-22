package com.divya.assignment3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import java.util.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var btnNumber1: Button
    private lateinit var btnNumber2: Button
    private lateinit var btnRestart: Button
    private lateinit var btnExit: Button
    private lateinit var tvCorrect: TextView
    private lateinit var tvIncorrect: TextView
    private lateinit var tvResult: TextView
    var a = 0
    var b = 0
    var randomValues = 0
    var nextValues = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        generate()
        operation()
    }


    fun generate() {
        val rand = Random
        randomValues = rand.nextInt(0, 100)
        nextValues = rand.nextInt(0, 100)

    }

    fun operation() {
        btnNumber1 = findViewById(R.id.btnNumber1)
        btnNumber1.setText(randomValues.toString())
        btnNumber2 = findViewById(R.id.btnNumber2)
        btnNumber2.setText(nextValues.toString())
        btnRestart = findViewById(R.id.btnRestart)
        btnExit = findViewById(R.id.btnExit)
        tvResult = findViewById(R.id.tvResult)




        btnNumber1.setOnClickListener {

            if (randomValues > nextValues) {

                a++
                tvCorrect = findViewById(R.id.tvCorrect)
                tvCorrect.setText("Correct :" + a)

            } else {
                b++
                tvIncorrect = findViewById(R.id.tvIncorrect)
                tvIncorrect.setText("Incorrect:" + b)

            }
            check()

        }

        btnNumber2.setOnClickListener {

            if (randomValues < nextValues) {

                a++
                tvCorrect = findViewById(R.id.tvCorrect)
                tvCorrect.setText("Correct :" + a)

            } else {
                b++
                tvIncorrect = findViewById(R.id.tvIncorrect)
                tvIncorrect.setText("Incorrect :" + b)

            }
            check()

        }


    }

    fun check() {
        if (a == 5) {
            tvResult.visibility = View.VISIBLE
            tvResult.setText("You've won")
            btnRestart.visibility = View.VISIBLE

        } else if (b == 5) {
            tvResult.setText("You've lost")
            tvResult.visibility = View.VISIBLE
            btnRestart.visibility = View.VISIBLE

        } else {
            generate()
            operation()
        }
        btnRestart.setOnClickListener {
            val intent = intent
            finish()
            startActivity(intent)

        }
        btnExit.setOnClickListener {
            finish()
        }

    }
}



