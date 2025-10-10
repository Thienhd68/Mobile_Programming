package com.example.thuchanh01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
class MainActivity : AppCompatActivity() {

    private lateinit var etName: EditText
    private lateinit var etAge: EditText
    private lateinit var btnCheck: Button
    private lateinit var tvResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etName = findViewById(R.id.etName)
        etAge = findViewById(R.id.etAge)
        btnCheck = findViewById(R.id.btnCheck)
        tvResult = findViewById(R.id.tvResult)

        btnCheck.setOnClickListener {
            val name = etName.text.toString().trim()
            val ageText = etAge.text.toString().trim()

            if (name.isEmpty() || ageText.isEmpty()) {
                tvResult.text = "Vui lòng nhập đầy đủ thông tin!"
                return@setOnClickListener
            }

            val age = ageText.toIntOrNull()
            if (age == null) {
                tvResult.text = "Tuổi phải là số hợp lệ!"
                return@setOnClickListener
            }

            val category = when {
                age < 2 -> "Em bé"
                age in 2..6 -> "Trẻ em"
                age in 7..65 -> "Người lớn"
                else -> "Người già"
            }

            tvResult.text = "$name là $category"
        }
    }
}
