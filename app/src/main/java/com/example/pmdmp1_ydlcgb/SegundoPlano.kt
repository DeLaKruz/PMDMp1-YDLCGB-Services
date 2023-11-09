package com.example.pmdmp1_ydlcgb

import android.app.Service
import android.content.Intent
import android.os.IBinder

class SegundoPlano : Service() {

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        this.run()
        return START_NOT_STICKY
    }

    private fun run() {
        Thread {
            calcularPrimos(Int.MAX_VALUE / 400000)
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

    override fun onBind(intent: Intent): IBinder? {
        return null
    }
}