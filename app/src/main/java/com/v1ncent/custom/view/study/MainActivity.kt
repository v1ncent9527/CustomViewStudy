package com.v1ncent.custom.view.study

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.v1ncent.custom.view.study.practice1.Practice1Activity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun practice1(view: View) {
        startActivity(Intent(this, Practice1Activity::class.java))
    }
}