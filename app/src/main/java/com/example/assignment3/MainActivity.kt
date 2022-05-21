package com.example.assignment3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var x: String = "Congratulations"

        var spType: Spinner = findViewById(R.id.spType)
        var options = arrayOf("Birthday","Congratulations","Get Well Soon","Good Morning")
        spType.adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,options)

        spType.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                x = options.get(p2) //p2 is the index of selected item
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

        val to: EditText = findViewById(R.id.edTo)
        val text: EditText = findViewById(R.id.edText)

        var btnGo: Button = findViewById(R.id.btnGo)

        btnGo.setOnClickListener{

            //val toStr: String = to.text.toString()
            //val textStr: String = text.text.toString()

            /*val intent = Intent(this, congrats::class.java)
            intent.putExtra("to",to.text.toString())
            intent.putExtra("txt",text.text.toString())
            startActivity(intent)*/


            if(x == "Congratulations"){
                val intent = Intent(this@MainActivity,congrats::class.java)
                intent.putExtra("to",to.text.toString())
                intent.putExtra("txt",text.text.toString())
                startActivity(intent)
            }else if(x == "Birthday"){
                val intent = Intent(this@MainActivity,Birthday::class.java)
                intent.putExtra("to",to.text.toString())
                intent.putExtra("txt",text.text.toString())
                startActivity(intent)
            }else{
                val intent = Intent(this@MainActivity,GetWell::class.java)
                intent.putExtra("to",to.text.toString())
                intent.putExtra("txt",text.text.toString())
                startActivity(intent)
            }

            Toast.makeText(this, to.text.toString(), Toast.LENGTH_SHORT).show()
            Toast.makeText(this, text.text.toString(), Toast.LENGTH_SHORT).show()

        }

    }
}