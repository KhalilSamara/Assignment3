package com.example.assignment3

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class congrats : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_congrats)

        val tvDispTo: TextView = findViewById(R.id.tvTo)
        val tvDispText: TextView = findViewById(R.id.tvText)

        val bundle: Bundle? = intent.extras

        bundle?.let {
            val toDisp = bundle.getString("to")
            tvDispTo.text = toDisp

            val textDisp = bundle.getString("txt")
            tvDispText.text = textDisp
        }
    }
}