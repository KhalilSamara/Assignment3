package com.example.assignment3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

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

        /*val sentTo = intent.getStringExtra("to")
        val sentTxt = intent.getStringExtra("txt")

        tvDispTo.text = sentTo
        tvDispText.text = sentTxt */
    }
}