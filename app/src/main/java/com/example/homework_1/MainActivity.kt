package com.example.homework_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.IntegerRes
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        firstNum.requestFocus()

        calcButton.setOnClickListener {
            val numberFirst = firstNum.text.toString().toIntOrNull()
            val numberSecond = secondNum.text.toString().toIntOrNull()
            if (numberFirst != null && numberSecond != null && arifmetical != null) {
                val result =
                    when (arifmetical.text.toString()) {
                        "+" -> numberFirst + numberSecond
                        "-" -> numberFirst - numberSecond
                        "*" -> numberFirst * numberSecond
                        "/" -> numberFirst / numberSecond
                        else -> numberFirst
                    }

                startActivity(
                    Intent(this, SecondActivity::class.java).also {
                        it.putExtra("result", result)
                    }
                )
            }
        }

        clearButton.setOnClickListener {
            firstNum.text.clear()
            secondNum.text.clear()
            arifmetical.text.clear()
        }
    }
}