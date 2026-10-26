package com.example.intentapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_TEXT = "extra_text"
        const val EXTRA_TYPE = "extra_type"

        const val ACTION_SHOW_TEXT = "com.example.intentapp.ACTION_SHOW_TEXT"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etText = findViewById<EditText>(R.id.etText)
        val btnExplicit = findViewById<Button>(R.id.btnExplicit)
        val btnImplicit = findViewById<Button>(R.id.btnImplicit)

        btnExplicit.setOnClickListener {
            val text = etText.text.toString()
            if (text.isEmpty()) {
                Toast.makeText(this, "Введите текст", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra(EXTRA_TEXT, text)
            intent.putExtra(EXTRA_TYPE, "Явный Intent")
            startActivity(intent)
        }

        btnImplicit.setOnClickListener {
            val text = etText.text.toString()
            if (text.isEmpty()) {
                Toast.makeText(this, "Введите текст", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val intent = Intent(ACTION_SHOW_TEXT)
            intent.putExtra(EXTRA_TEXT, text)
            intent.putExtra(EXTRA_TYPE, "Неявный Intent")

            try {
                startActivity(intent)
            } catch (e: Exception) {
                Toast.makeText(this, "Нет подходящей активити", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
