package com.example.pmdmp1_ydlcgb

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class YDLCGB_primosXActivity : AppCompatActivity() {
    var numerosprimos = ArrayList<Int>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ydlcgb_primos_xactivity)
        findViewById<EditText>(R.id.numerin).setText("0")


        findViewById<Button>(R.id.calcularboton).setOnClickListener() {
            var n: Int = findViewById<EditText>(R.id.numerin).text.toString().toInt()
            numerosprimos.removeAll { true }
            calcularPrimos(n)
        }
        findViewById<Button>(R.id.volverboton).setOnClickListener() {
            val returnIntent = Intent()
            var numero=findViewById<EditText>(R.id.numerin).text.toString().toInt()
            //var numero = intent.getIntExtra("numero", -1)

             calcularPrimos(numero)
           var n=numerosprimos
            //numerosprimos = calcularPrimos(numero)
            returnIntent.putIntegerArrayListExtra("primos", numerosprimos )
            //se devuelve
            setResult(RESULT_OK, returnIntent)
            finish()
        }
    }


    private fun calcularPrimos(numeromax: Int) {
        //lateinit var numeros: ArrayList<Int>
        for (i in 2..numeromax) {
            if (esPrimo(i)) {
                numerosprimos .add(i)
                println(i)
            }
        }
        //return numeros
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