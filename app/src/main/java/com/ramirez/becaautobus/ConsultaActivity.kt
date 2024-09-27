package com.ramirez.becaautobus

import android.content.Context
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ConsultaActivity : AppCompatActivity() {

    // Instancias
    private lateinit var info: TextView
    private var beca: Beca = Beca()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_consulta)

        // Asociar con el componente TextView
        info = findViewById(R.id.txtInfo)


        // Recibir el objeto Disfraz desde PedidoActivity
        val beca = intent.getSerializableExtra("beca") as? Beca

        // Si el disfraz no es nulo, mostrar la información del Intent
        beca?.let {
            info.text = "Información registrada:\n" +
                    "Folio: ${beca.folio}\n" +
                    "Institución: ${beca.institucion}\n" +
                    "Nombre: ${beca.nombre}\n" +
                    "Apellidos: ${beca.apellido}\n" +
                    "Nivel: ${beca.nivel}"
        }

        // Si no se recibe el objeto Disfraz, intenta obtener los datos de SharedPreferences
        if (beca == null) {
            val sharedPreferences = getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE)
            val folio = sharedPreferences.getString("folio", "No disponible")
            val institucion = sharedPreferences.getString("institucion", "No disponible")
            val nombre = sharedPreferences.getString("nombre", "No disponible")
            val apellido = sharedPreferences.getString("apellido", "No disponible")
            val nivel = sharedPreferences.getString("nivel", "No disponible")

            info.text = "Información registrada:\n" +
                    "Folio: ${folio}\n" +
                    "Institución: ${institucion}\n" +
                    "Nombre: ${nombre}\n" +
                    "Apellidos: ${apellido}\n" +
                    "Nivel: ${nivel}"
        }
    }
}

