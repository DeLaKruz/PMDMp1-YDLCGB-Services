package com.example.pmdmp1_ydlcgb

import android.app.IntentService
import android.content.Intent
import android.content.Context
import androidx.media3.common.util.Log

class IntentService : IntentService("IntentService") {

    override fun onHandleIntent(intent: Intent?) {
        calcularPrimos(Int.MAX_VALUE / 400000)

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
}