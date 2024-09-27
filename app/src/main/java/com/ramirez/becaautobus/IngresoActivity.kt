package com.ramirez.becaautobus

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Switch
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class IngresoActivity : AppCompatActivity() {

    private lateinit var correo: EditText
    private lateinit var contrasena: EditText
    private lateinit var guardar: Switch

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ingreso)

        correo = findViewById(R.id.edtCorreo)
        contrasena = findViewById(R.id.edtContrasena)
        guardar = findViewById(R.id.swtGuardar)
    }

    fun onClick(view: View?) {
        when (view?.id) {
            R.id.btnIngresar -> ingresar()
            R.id.btnBorrar -> limpiar()
        }
    }

    private fun ingresar() {
        if (correo.text.isNotBlank() && contrasena.text.isNotBlank()) {
            val usuario = Usuario(correo.text.toString(), contrasena.text.toString(), guardar.isChecked)
            if (guardar.isChecked) {
                guardarPreferencias(usuario)
            }
            val intent = Intent(this, MenuActivity::class.java)
            startActivity(intent)
        } else {
            Toast.makeText(this, "Capturar información", Toast.LENGTH_LONG).show()
        }
    }

    private fun limpiar() {
        correo.text = null
        contrasena.text = null
        correo.requestFocus()
    }

    private fun guardarPreferencias(usuario: Usuario) {
        val preferences: SharedPreferences = getSharedPreferences("prefenciasUsuario", MODE_PRIVATE)
        val editor: SharedPreferences.Editor = preferences.edit()
        editor.putString("email", usuario.correo)
        editor.putString("password", usuario.contrasena)
        editor.putBoolean("guardado", usuario.guardado)
        editor.apply()
    }
}

