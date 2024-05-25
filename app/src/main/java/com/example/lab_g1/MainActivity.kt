package com.example.lab_g1

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var inputEditText: EditText
    private lateinit var outputTextView: TextView
    private lateinit var checkResultButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        inputEditText = findViewById(R.id.inputEditText)
        outputTextView = findViewById(R.id.outputTextView)
        checkResultButton = findViewById(R.id.checkResultButton)

        checkResultButton.setOnClickListener {
            val inputText = inputEditText.text.toString()
            if (inputText.isNotEmpty()) {
                val character = inputText[0]
                val checkResult = checkCharacter(character)
                outputTextView.text = checkResult // Отображение результата
            }
        }
    }

    fun checkCharacter(character: Char): String { // Возвращает строку с результатом
        when (character) {
            in 'a'..'z' -> {
                if (character in "aeiouAEIOU") {
                    return "Это гласная буква"
                } else {
                    return "Возможно, это согласная буква"
                }
            }
            else -> {
                return "Введенный символ не является латинской строчной буквой"
            }
        }
    }
}