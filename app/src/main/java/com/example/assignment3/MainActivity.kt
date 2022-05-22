package com.example.assignment3

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        createChannel()

        var x: String = "Congratulations"

        var spType: Spinner = findViewById(R.id.spType)
        var options = arrayOf("Congratulations","Happy Birthday","Get Well Soon")
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

            sendNotification(to.text.toString(),text.text.toString(), x)

            if(x == "Congratulations"){
                val intent = Intent(this@MainActivity,congrats::class.java)
                intent.putExtra("to",to.text.toString())
                intent.putExtra("txt",text.text.toString())
                startActivity(intent)
            }else if(x == "Happy Birthday"){
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
        }
    }

    private val CHANNEL_ID = "channel_id_ex_1"
    private val notificationId = 101

    private fun createChannel() {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = "title"
            val desc = "description"
            val imp = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel(CHANNEL_ID,name,imp).apply {
                description = desc
            }
            val notificationManager: NotificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }

    private fun sendNotification(to: String, text: String, option: String){
        val builder = NotificationCompat.Builder(this,CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setContentTitle("$option, $to")
            .setContentText(text)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
        with(NotificationManagerCompat.from(this)){
            notify(notificationId,builder.build())
        }
    }
}