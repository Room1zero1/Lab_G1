package com.example.lab_g1

import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var inputEditText: EditText
    private lateinit var outputTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        inputEditText = findViewById(R.id.inputEditText)
        outputTextView = findViewById(R.id.outputTextView)
    }

    fun checkCharacter(character: Char) {
        when (character) {
            in 'a'..'z' -> {
                if (character in "aeiouAEIOU") {
                    outputTextView.text = "Это гласная буква"
                } else {
                    outputTextView.text = "Возможно, это согласная буква"
                }
            }
            else -> {
                outputTextView.text = "Введенный символ не является латинской строчной буквой"
            }
        }
    }

    fun onClickCheckButton(view: android.view.View) {
        val inputText = inputEditText.text.toString()
        if (inputText.isNotEmpty()) {
            val character = inputText[0]
            val checkResult = checkCharacter(character) // Храним результат проверки
            outputTextView.text = checkResult.toString() // Отображаем результат
        }
    }

}