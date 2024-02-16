package com.example.equipobaloncesto.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.room.Room
import com.example.equipobaloncesto.R
import com.example.equipobaloncesto.database.MiAppDatabase
import com.example.equipobaloncesto.database.dao.ClasificacionDao
import com.example.equipobaloncesto.database.entities.Clasificacion
import com.example.equipobaloncesto.database.entities.Equipo

class MainActivityAltaEquipo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_alta_equipo)

        val nombre = findViewById<EditText>(R.id.tvNombre)
        val ciudad = findViewById<EditText>(R.id.tvCiudad)
        val nombrePabellon = findViewById<EditText>(R.id.tvNombrePabellon)
        val btEntrar = findViewById<TextView>(R.id.textViewAlta)

        btEntrar.setOnClickListener {

            suspend fun databaseAccess() {
                val db = Room.databaseBuilder(
                    applicationContext,
                    MiAppDatabase::class.java, "DDBB"
                ).build()
                val equipoDao = db.equipoDao()
                val clasificacionDao = db.ClasificacionDao()

                val equipoNombre = nombre.text.toString()
                val equipoCiudad = ciudad.text.toString()
                val pabellonNombre = nombrePabellon.text.toString()

                // Crear un nuevo equipo con los detalles introducidos por el usuario
                val nuevoEquipo = Equipo(null, equipoNombre, equipoCiudad, pabellonNombre)

                suspend fun databaseAccess() {
                    // ...
                    try {
                        if (nuevoEquipo != null) {
                            // Comprobar si el equipo ya existe

                            val equipoExistente =
                                equipoDao.insertEquipo(nuevoEquipo)
                            if (equipoExistente == null) {
                                // El equipo no existe, se puede crear
                                var clasificacion = Clasificacion(0, 0, nuevoEquipo!!.nombre_equipo)
                                nuevoEquipo?.let { equipoDao.insertEquipo(it) }
                                clasificacionDao.insertClasificacion(clasificacion)
                            } else {
                                // El equipo ya existe, mostrar un mensaje al usuario
                                Toast.makeText(this, "El equipo ya existe!", Toast.LENGTH_LONG)
                                    .show()
                            }
                        }
                    } catch (e: Exception) {
                        Toast.makeText(this, "No se puede crear el equipo!", Toast.LENGTH_LONG)
                            .show()
                    }

                }

            }

        }
    }
}