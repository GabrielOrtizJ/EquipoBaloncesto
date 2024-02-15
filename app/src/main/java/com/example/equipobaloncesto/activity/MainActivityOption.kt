package com.example.equipobaloncesto.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.equipobaloncesto.MainActivity2
import com.example.equipobaloncesto.R

class MainActivityOption : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_option)

        val altaEquipo = findViewById<TextView>(R.id.tvAltaEquipo)
        val addJugador = findViewById<TextView>(R.id.tvAñadirJ)
        val mostrarJugadores = findViewById<TextView>(R.id.tvMostrarJugadores)
        val volver = findViewById<TextView>(R.id.tvVolver)
        altaEquipo.setOnClickListener{
                val intent = Intent(this, MainActivityAltaEquipo::class.java)
                startActivity(intent)
     }
        addJugador.setOnClickListener{
            val intent = Intent(this, MainActivityJugador::class.java)
            startActivity(intent)
        }
        mostrarJugadores.setOnClickListener{
            val intent = Intent(this, MainActivityListaJugadores::class.java)
            startActivity(intent)
        }
        volver.setOnClickListener{
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }
}
}