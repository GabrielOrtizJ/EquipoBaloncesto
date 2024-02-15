package com.example.equipobaloncesto.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import com.example.equipobaloncesto.R
class MainActivityAltaEquipo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_alta_equipo)

        val nombre = findViewById<EditText>(R.id.tvNombre)
        val ciudad = findViewById<EditText>(R.id.tvCiudad)
        val NombrePabellon = findViewById<EditText>(R.id.tvNombrePabellon)


    }
}