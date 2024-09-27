package com.ramirez.becaautobus

import android.content.Intent
import android.content.SharedPreferences

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import java.util.Timer
import java.util.TimerTask


class MainActivity : AppCompatActivity() {

    private lateinit var intent: Intent
    private lateinit var beca: Beca

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        beca = Beca()

        Timer().schedule(object : TimerTask() {
            override fun run() {
                intent = if (nuevoUsuario()) {
                    Intent(applicationContext, MenuActivity::class.java)
                } else {
                    Intent(applicationContext, IngresoActivity::class.java)
                }
                startActivity(intent)
            }
        }, 2000)
    }

    fun nuevoUsuario(): Boolean {
        val preferences: SharedPreferences = getSharedPreferences("prefenciasUsuario", MODE_PRIVATE)
        return preferences.getBoolean("guardado", false)
    }
}
