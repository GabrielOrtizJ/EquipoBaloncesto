package com.example.equipobaloncesto.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import com.example.equipobaloncesto.R
import com.example.equipobaloncesto.database.MiAppDatabase
import com.example.equipobaloncesto.database.entities.Clasificacion
import com.example.equipobaloncesto.database.entities.Equipo
import com.example.equipobaloncesto.database.entities.Jugador
import kotlinx.coroutines.launch

class MainActivityJugador : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
     super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_jugador)
        val Enombre = findViewById<EditText>(R.id.editTextNombre)
        val Edorsal = findViewById<EditText>(R.id.editTextDorsal)
        val Eposicion = findViewById<EditText>(R.id.editTextPosicion)
        val EnombreEquipo = findViewById<EditText>(R.id.editTextNombreEquipo)
        val  volver = findViewById<TextView>(R.id.textViewVolver)
        val btCrear = findViewById<TextView>(R.id.textViewCrearJugador)
        btCrear.setOnClickListener {
            lifecycleScope.launch(){
                databaseAccess(Enombre.text.toString(),Integer.parseInt(Edorsal.text.toString()) ,Eposicion.text.toString(),EnombreEquipo.text.toString())
            }

        }
        volver.setOnClickListener{
            val intent = Intent(this, MainActivityOption::class.java)
            startActivity(intent)
        }
    }

    suspend fun databaseAccess(nombre:String,dorsal:Int,posicion:String,nombreEquipo:String) {
        val db = MiAppDatabase.getInstance(this)
        val equipoDao = db.equipoDao()
        val jugadorDao = db.jugadorDao()

        // Comprobar si el equipo ya existe
        val equipoExistente = equipoDao.obtenerEquipos().find { it.nombre_equipo == nombreEquipo }

        if (equipoExistente != null) {
            // El equipo existe, se puede crear el jugador
            val nuevoJugador = Jugador(nombre, dorsal, posicion, nombreEquipo)
            try {
                jugadorDao.insertarJugador(nuevoJugador)
                val intent = Intent(this, MainActivityOption::class.java)
                startActivity(intent)
                Toast.makeText(this, "Jugador creado con éxito!", Toast.LENGTH_LONG).show()
          } catch (e: Exception) {
                Toast.makeText(this, "No se puede crear el jugador!", Toast.LENGTH_LONG).show()
            }
        } else {
            // El equipo no existe, mostrar un mensaje al usuario
            Toast.makeText(this, "El equipo no existe en la base de datos!", Toast.LENGTH_LONG).show()
        }
    }
}
