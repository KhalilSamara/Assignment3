package com.example.assignment3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class Birthday : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_birthday)

        val tvDispTo: TextView = findViewById(R.id.tvToB)
        val tvDispText: TextView = findViewById(R.id.tvTextB)

        val bundle: Bundle? = intent.extras

        bundle?.let {
            val toDisp = bundle.getString("to")
            tvDispTo.text = toDisp

            val textDisp = bundle.getString("txt")
            tvDispText.text = textDisp
        }
    }
}