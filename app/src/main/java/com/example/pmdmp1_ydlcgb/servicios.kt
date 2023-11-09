package com.example.pmdmp1_ydlcgb

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.Service
import android.content.Intent
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat
import java.util.Random

class servicios : AppCompatActivity() {
    private var enabled = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_servicios)
        findViewById<Button>(R.id.primoscalculo).setOnClickListener() {
            if (!enabled) {
                //es un intetn y se le pasa el mensaje cómo parámetro
                val serviceIntent = Intent(this, PrimerPlano::class.java)
                serviceIntent.putExtra(
                    "inputExtra",
                    "Se tiene que avisar de que está en primer plano"
                )
                ContextCompat.startForegroundService(this, serviceIntent)
                findViewById<Button>(R.id.primoscalculo).setText("Stop")
                enabled = true
            } else {
                enabled = false
                findViewById<Button>(R.id.primoscalculo).setText("Start")
                val serviceIntent = Intent(this, PrimerPlano::class.java)
                //se para
                stopService(serviceIntent)
            }
        }

        findViewById<Button>(R.id.segundoplano).setOnClickListener() {
            val intento: Intent = Intent(this, SegundoPlano::class.java)
            startService(intento)
        }

        findViewById<Button>(R.id.colores).setOnClickListener() {
            val rnd = Random()
            val color = Color.argb(
                255, rnd.nextInt(256), rnd.nextInt(256),
                rnd.nextInt(256)
            )
            it.setBackgroundColor(color)
        }

        findViewById<Button>(R.id.intentbutton).setOnClickListener() {
            val intent1: Intent = Intent(
                this,
                IntentService::class.java
            )
            startService(intent1)
        }
    }
}