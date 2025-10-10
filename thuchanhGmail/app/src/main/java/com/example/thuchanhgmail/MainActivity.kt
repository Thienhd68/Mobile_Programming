package com.example.thuchanhgmail

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etEmail = findViewById<EditText>(R.id.etEmail)
        val tvError = findViewById<TextView>(R.id.tvError)
        val btnCheck = findViewById<Button>(R.id.btnCheck)

        btnCheck.setOnClickListener {
            val email = etEmail.text.toString().trim()

            when {
                email.isEmpty() -> {
                    tvError.text = "Email không hợp lệ"
                    tvError.visibility = TextView.VISIBLE
                }
                !email.contains("@") -> {
                    tvError.text = "Email không đúng định dạng"
                    tvError.visibility = TextView.VISIBLE
                }
                else -> {
                    tvError.text = "Bạn đã nhập email hợp lệ"
                    tvError.setTextColor(getColor(android.R.color.holo_green_dark))
                    tvError.visibility = TextView.VISIBLE
                }
            }
        }
    }
}
