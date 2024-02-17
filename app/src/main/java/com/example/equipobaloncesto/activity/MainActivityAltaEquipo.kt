package com.example.equipobaloncesto.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import com.example.equipobaloncesto.MainActivity2
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
        val volver = findViewById<TextView>(R.id.textViewVolver2)
        val Enombre = findViewById<EditText>(R.id.tvNombre)
        val Eciudad = findViewById<EditText>(R.id.tvCiudad)
        val EnombrePabellon = findViewById<EditText>(R.id.tvNombrePabellon)
        volver.setOnClickListener{
            val intent = Intent(this, MainActivityOption::class.java)
            startActivity(intent)
        }
        btEntrar.setOnClickListener {


           lifecycleScope.launch(){
               databaseAccess(Enombre.text.toString(),Eciudad.text.toString(),EnombrePabellon.text.toString())

           }

        }

    }
    suspend fun databaseAccess(nombre:String,ciudad:String,nombrePabellon:String) {
        val db = MiAppDatabase.getInstance(this)
        val equipoDao = db.equipoDao()
        val clasificacionDao = db.ClasificacionDao()

        // Crear un nuevo equipo con los detalles introducidos por el usuario
        val nuevoEquipo = Equipo(null, nombre, ciudad, nombrePabellon)
   try {
                if (nuevoEquipo != null) {
                    // Comprobar si el equipo ya existe
                    equipoDao.insertEquipo(nuevoEquipo)
                    // Crear una nueva clasificación para el equipo
                    var clasificacion = Clasificacion(null, 0, nuevoEquipo.nombre_equipo)
                    // Insertar la nueva clasificación en la base de datos
                    clasificacionDao.insertClasificacion(clasificacion)
                   val intent = Intent(this, MainActivityOption::class.java)
                   startActivity(intent)
                    Toast.makeText(this, "Equipo creado con exito!", Toast.LENGTH_LONG)
                        .show()
                    }else{
                    println("equipo existente no se ha podido crear")
                }

            } catch (e: Exception) {
                Toast.makeText(this, "No se puede crear el equipo!", Toast.LENGTH_LONG)
                    .show()
            }



    }
}