package com.ramirez.becaautobus

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class MenuActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_overflow, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val intent: Intent
        when (item.itemId) {
            R.id.itmFormulario -> {
                intent = Intent(this, RegistroActivity::class.java)
                startActivity(intent)
            }
            R.id.itmConsultar -> {
                intent = Intent(this, ConsultaActivity::class.java)
                startActivity(intent)
            }
            R.id.itmCerrar -> cerrarSesion()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun cerrarSesion() {
        val preferences: SharedPreferences = getSharedPreferences("prefenciasUsuario", MODE_PRIVATE)
        val editor: SharedPreferences.Editor = preferences.edit()
        editor.clear()
        editor.apply()
        val intent = Intent(this, IngresoActivity::class.java)
        startActivity(intent)
    }
}
