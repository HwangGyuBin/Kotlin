package org.techtown.bmi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlin.math.pow

class Result : AppCompatActivity() {
    val resultText by lazy {
        findViewById<TextView>(R.id.resultText)
    }

    val bmiResultText by lazy {
        findViewById<TextView>(R.id.bmiResultText)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val height= intent.getIntExtra("height",0)
        val weight = intent.getIntExtra("weight",0)

        val bmi =weight/(height/100.0).pow(2.0)

        val result = when {
            bmi >= 35.0 -> "고도 비만"
            bmi >= 30.0 -> "중정도 비만"
            bmi >= 25.0 -> "경도 비만"
            bmi >= 23.0 -> "과체중"
            bmi >= 18.5 -> "정상체중"
            else -> "저체중"
        }

        bmiResultText.text = bmi.toString()
        resultText.text=result

    }
}