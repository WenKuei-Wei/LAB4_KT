package com.example.lab4_kt

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var btn: Button
    private lateinit var tv_meal: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //連結點餐資訊、按鈕
        tv_meal = findViewById(R.id.textView3)
        btn = findViewById(R.id.btn_choice)
        //點擊按鈕
        btn.setOnClickListener(View.OnClickListener {
            startActivityForResult(
                Intent(
                    this@MainActivity,
                    MainActivity2::class.java
                ), 1
            )
        })
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (data == null) return
        if (requestCode == 1 && resultCode == 101) {
            data.extras?.let { a->
                val str1 = a.getString("drink")
                val str2 = a.getString("sugar")
                val str3 = a.getString("ice")
                tv_meal.text = String.format("飲料: %s\n\n甜度: %s\n\n冰塊: %s\n\n", str1, str2, str3)
            }
        }
    }
}