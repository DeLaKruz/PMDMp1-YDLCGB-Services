package com.example.pmdmp1_ydlcgb

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.Service
import android.content.Intent
import android.os.Build
import android.os.IBinder
import android.util.Log
import androidx.core.app.NotificationCompat

class PrimerPlano : Service() {

    private val CHANNEL_ID = "ForegroundServiceChannel"
    private lateinit var manager: NotificationManager

    //para controlar el hilo
    private var enable: Boolean = false;
    override fun onCreate() {
        super.onCreate()
    }

    //notificacion que aparece en la parte superior
    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val serviceChannel = NotificationChannel(
                CHANNEL_ID,
                "Foreground Service Channel",
                NotificationManager.IMPORTANCE_DEFAULT
            )
            manager = getSystemService(
                NotificationManager::class.java
            )
            manager.createNotificationChannel(serviceChannel)
        }
    }

    override fun onStartCommand(
        intent: Intent, flags: Int, startId:
        Int
    ): Int {
        val input = intent.getStringExtra("inputExtra")
        createNotificationChannel()
        val notificationIntent = Intent(
            this,
            MainActivity::class.java
        )
        //informar al sistema de que se tiene una actividad trabajando
        val pendingIntent = PendingIntent.getActivity(
            this,
            0, notificationIntent, PendingIntent.FLAG_MUTABLE or
                    PendingIntent.FLAG_UPDATE_CURRENT
        )
        val notification: Notification =
            NotificationCompat.Builder(this, CHANNEL_ID)
                .setContentTitle("Ejemplo Servicio primer plano")
                .setContentText(input)
                .setSmallIcon(R.drawable.alert_dark_frame)
                .setContentIntent(pendingIntent)
                .build()
        //se inicia en segundo plano y se pasa la notificación
        startForeground(102, notification)
        //se inicia le hilo
        this.run()
        return START_NOT_STICKY
    }

    //hilo que escribe en el log
    private fun run() {
        Thread {
            val numerosprimos = calcularPrimos(numeromax = Int.MAX_VALUE / 400000)
            Log.e("Serviciosdemiprimo", "Service is running...")
        }.start()
    }

    var numerosprimos = ArrayList<Int>()
    private fun calcularPrimos(numeromax: Int): List<Int> {
        for (i in 2..numeromax) {
            if (esPrimo(i)) {
                numerosprimos.add(i)
                println(i)
            }
        }
        return numerosprimos
    }

    private fun esPrimo(numeromax: Int): Boolean {
        if (numeromax <= 1) {
            return false
        }
        for (i in 2..numeromax - 1) {
            if (numeromax % i == 0) {
                return false
            }
        }
        return true
    }

    override fun onDestroy() {
        //parar el hilo
        enable = false
        super.onDestroy()
    }

    override fun onBind(intent: Intent): IBinder? {
        return null
    }
}