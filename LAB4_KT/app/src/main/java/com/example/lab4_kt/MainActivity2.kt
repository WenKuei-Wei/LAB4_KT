package com.example.lab4_kt

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity

class MainActivity2 : AppCompatActivity() {
    private var send_btn: Button? = null
    private var set_drink: EditText? = null
    private var rg1: RadioGroup? = null
    private var rg2: RadioGroup? = null
    private var sugar = "無糖"
    private var ice_opt = "去冰"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        var rg1 = findViewById<RadioGroup>(R.id.radioGroup)
        rg1.setOnCheckedChangeListener(RadioGroup.OnCheckedChangeListener { radioGroup, i ->
            when (i) {
                R.id.radioButton -> sugar = "無糖"
                R.id.radioButton2 -> sugar = "微糖"
                R.id.radioButton3 -> sugar = "半糖"
                R.id.radioButton4 -> sugar = "全糖"
            }
        })
        var rg2 = findViewById<RadioGroup>(R.id.radioGroup2)
        rg2.setOnCheckedChangeListener(RadioGroup.OnCheckedChangeListener { radioGroup, i ->
            when (i) {
                R.id.radioButton5 -> ice_opt = "去冰"
                R.id.radioButton6 -> ice_opt = "微冰"
                R.id.radioButton7 -> ice_opt = "少冰"
                R.id.radioButton8 -> ice_opt = "正常冰"
            }
        })
        var send_btn = findViewById<Button>(R.id.btn_send)
        send_btn.setOnClickListener(View.OnClickListener {
            val set_drink = findViewById<EditText>(R.id.ed_drink)
            val drink = set_drink.text.toString()
            val i = Intent()
            val b = Bundle()
            b.putString("sugar", sugar.toString())
            b.putString("drink", drink.toString())
            b.putString("ice", ice_opt.toString())
            i.putExtras(b)
            setResult(101, Intent().putExtras(b))
            finish()
        })
    }
}