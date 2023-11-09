package com.example.pmdmp1_ydlcgb

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity() {
    var YDLCGB: Int = 0;
    var launcher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) {
        val intent = it.data
        var datos = it.data?.getIntegerArrayListExtra("primos")
        Log.d(
            "Devolucion resultado",
            it.data?.getIntArrayExtra("primos").toString()
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("ESTADOS", "Evento onCreate:" + YDLCGB)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.b_entrar).setOnClickListener() {
            val intent = Intent(this, YDLCGB_primosActivity::class.java)
            startActivityForResult(intent, 45)
        }

        findViewById<Button>(R.id.b_entrarx).setOnClickListener() {
            val intent = Intent(this, YDLCGB_primosXActivity::class.java).putExtra("numeros", 20)
            launcher.launch(intent)
        }

        findViewById<Button>(R.id.servicios).setOnClickListener(){
            val intent = Intent(this, servicios::class.java)
            startActivityForResult(intent, 50)
        }
    }

    override fun onStart() {
        super.onStart()
        YDLCGB++
        Log.i("ESTADOS", "Evento onStart:" + YDLCGB)
    }

    override fun onResume() {
        super.onResume()
        YDLCGB++
        Log.i("ESTADOS", "Evento onResume:" + YDLCGB)
    }

    override fun onStop() {
        super.onStop()
        YDLCGB++
        Log.i("ESTADOS", "Evento onStop:" + YDLCGB)
    }

    override fun onDestroy() {
        super.onDestroy()
        YDLCGB++
        Log.i("ESTADOS", "Evento onDestroy:" + YDLCGB)
    }

    /*override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
    }*/


}