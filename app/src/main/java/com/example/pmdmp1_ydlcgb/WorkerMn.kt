package com.example.pmdmp1_ydlcgb

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters
import androidx.work.workDataOf

class WorkerMn  (context: Context, workerParams: WorkerParameters) :
    Worker(context, workerParams){
    override fun doWork(): Result {
        calcularPrimos(Int.MAX_VALUE / 400000)
        val vuelta= workDataOf(Pair("vuelta","otroobjecto"))
        return Result.success(vuelta)
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