package com.example.lab1_sakun_nikita

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnEnter = findViewById<Button>(R.id.btnEnter)
        val btnClear = findViewById<Button>(R.id.btnClear)

        val rgCompany = findViewById<RadioGroup>(R.id.rgCompany)
        val rgType = findViewById<RadioGroup>(R.id.rgType)
        val textRes = findViewById<TextView>(R.id.textView3)
        textRes.text = " "

        btnEnter.setOnClickListener {

            var rb_company_id = rgCompany.checkedRadioButtonId
            var rb_type_id = rgType.checkedRadioButtonId


            if (rb_company_id == -1 || rb_type_id == -1) {
                Toast.makeText(this, "Please choose a company and type", Toast.LENGTH_LONG).show()
            } else {
                // get the actual radio buttons
                val rb_company = findViewById<RadioButton>(rb_company_id)
                val rb_type = findViewById<RadioButton>(rb_type_id)
                textRes.text = rb_company.text.toString()+ " " + rb_type.text.toString()
            }
        }

        btnClear.setOnClickListener {
            rgCompany.clearCheck()
            rgType.clearCheck()
            textRes.text = " "
        }


        val pre_checked_company = rgCompany.getChildAt(1) as RadioButton

        pre_checked_company.setChecked(true)

        val pre_checked_type = rgType.getChildAt(1) as RadioButton
        pre_checked_type.setChecked(true)
    }
}
