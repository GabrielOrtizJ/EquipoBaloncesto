package com.example.equipobaloncesto.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import com.example.equipobaloncesto.R
import com.example.equipobaloncesto.database.MiAppDatabase
import com.example.equipobaloncesto.database.dao.ClasificacionDao
import com.example.equipobaloncesto.database.entities.Clasificacion
import com.example.equipobaloncesto.database.entities.Equipo
import kotlinx.coroutines.launch

class MainActivityAltaEquipo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_alta_equipo)

        val btEntrar = findViewById<TextView>(R.id.textViewAlta)


        btEntrar.setOnClickListener {

            val nombre = findViewById<EditText>(R.id.tvNombre)
            val ciudad = findViewById<EditText>(R.id.tvCiudad)
            val nombrePabellon = findViewById<EditText>(R.id.tvNombrePabellon)
           lifecycleScope.launch(){
               databaseAccess(nombre.text.toString(),ciudad.text.toString(),nombrePabellon.text.toString())

           }

        }

    }
    suspend fun databaseAccess(nombre:String,ciudad:String,nombrePabellon:String) {
        val db = Room.databaseBuilder(
            applicationContext,
            MiAppDatabase::class.java, "DDBB"
        ).build()
        val equipoDao = db.equipoDao()
        val clasificacionDao = db.ClasificacionDao()

        val equipoNombre = nombre
        val equipoCiudad = ciudad
        val pabellonNombre = nombrePabellon

        // Crear un nuevo equipo con los detalles introducidos por el usuario
        val nuevoEquipo = Equipo(null, equipoNombre, equipoCiudad, pabellonNombre)



            try {
                if (nuevoEquipo != null) {
                    // Comprobar si el equipo ya existe

                    val equipoExistente =
                        equipoDao.insertEquipo(nuevoEquipo)

                        // El equipo no existe, se puede crear
                        var clasificacion = Clasificacion(0, 0, nuevoEquipo!!.nombre_equipo)
                        nuevoEquipo?.let { equipoDao.insertEquipo(it) }
                        clasificacionDao.insertClasificacion(clasificacion)


                    }

            } catch (e: Exception) {
                Toast.makeText(this, "No se puede crear el equipo!", Toast.LENGTH_LONG)
                    .show()
            }



    }
}