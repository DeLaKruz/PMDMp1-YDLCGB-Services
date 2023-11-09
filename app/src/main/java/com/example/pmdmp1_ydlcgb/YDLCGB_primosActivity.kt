package com.example.pmdmp1_ydlcgb

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.activity.result.contract.ActivityResultContracts

class YDLCGB_primosActivity : AppCompatActivity() {
    var numerosprimos = mutableListOf<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ydlcgb_primos)
        findViewById<EditText>(R.id.numfield).setText("0")


        findViewById<Button>(R.id.calcular).setOnClickListener() {
            var n: Int = findViewById<EditText>(R.id.numfield).text.toString().toInt()
            numerosprimos.removeAll { true }
            calcularPrimos(n)
        }
        findViewById<Button>(R.id.b_volver).setOnClickListener() {
            val returnIntent = Intent()
            returnIntent.putExtra("valor devuelto", numerosprimos.stream().toArray())
            //se devuelve
            setResult(RESULT_OK, returnIntent)
            finish()
        }
    }


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
        for (i in 2..numeromax-1) {
            if (numeromax % i == 0) {
                return false
            }
        }
        return true
    }
}