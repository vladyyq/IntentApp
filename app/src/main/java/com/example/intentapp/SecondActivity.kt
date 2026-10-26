package com.example.intentapp

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val tvType = findViewById<TextView>(R.id.tvType)
        val tvText = findViewById<TextView>(R.id.tvText)
        val tvAction = findViewById<TextView>(R.id.tvAction)
        val btnBack = findViewById<Button>(R.id.btnBack)

        val text = intent.getStringExtra(MainActivity.EXTRA_TEXT) ?: ""
        val type = intent.getStringExtra(MainActivity.EXTRA_TYPE) ?: "Intent"

        tvType.text = type
        tvText.text = "$text ($type)"

        if (intent.action != null) {
            tvAction.text = "action: " + intent.action
        } else {
            tvAction.text = "component: " + SecondActivity::class.java.simpleName
        }

        btnBack.setOnClickListener {
            finish()
        }
    }
}
