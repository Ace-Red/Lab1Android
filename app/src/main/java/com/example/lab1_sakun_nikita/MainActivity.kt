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
    }
    fun clearRgMain(){
        val fragmentManager = supportFragmentManager
        val fragmentN1 = fragmentManager.findFragmentById(R.id.FragmentN1) as FragmentN1
        fragmentN1.clearRg()
    }
    fun transportTextResFromF2(textRes: String){
        val fragmentManager = supportFragmentManager
        val fragmentN2 = fragmentManager.findFragmentById(R.id.FragmentN2) as FragmentN2
        fragmentN2.writeResToTextView(textRes)
    }

}
