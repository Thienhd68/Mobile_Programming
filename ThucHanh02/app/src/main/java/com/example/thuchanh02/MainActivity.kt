package com.example.thuchanh02

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val edtNumber = findViewById<EditText>(R.id.edtNumber)
        val btnGenerate = findViewById<Button>(R.id.btnGenerate)
        val layoutList = findViewById<LinearLayout>(R.id.layoutList)
        val tvError = findViewById<TextView>(R.id.tvError)

        tvError.visibility = View.GONE

        btnGenerate.setOnClickListener {
            val input = edtNumber.text.toString().trim()
            layoutList.removeAllViews()
            tvError.visibility = View.GONE
            tvError.text = ""

            if (input.isEmpty()) {
                tvError.text = "Vui lòng nhập số"
                tvError.visibility = View.VISIBLE
                return@setOnClickListener
            }

            // Nếu không parse được sang Int -> báo lỗi
            val number = input.toIntOrNull()
            if (number == null) {
                tvError.text = "Dữ liệu bạn nhập không hợp lệ"
                tvError.visibility = View.VISIBLE
                return@setOnClickListener
            }

            if (number <= 0) {
                tvError.text = "Vui lòng nhập số dương"
                tvError.visibility = View.VISIBLE
                return@setOnClickListener
            }

            // Tạo danh sách các nút (1..number)
            for (i in 1..number) {
                val btn = Button(this)
                btn.text = i.toString()
                val params = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                params.setMargins(0, 16, 0, 0)
                btn.layoutParams = params
                btn.setBackgroundColor(getColor(android.R.color.holo_red_light))
                btn.setTextColor(getColor(android.R.color.white))
                layoutList.addView(btn)
            }
        }
    }
}
