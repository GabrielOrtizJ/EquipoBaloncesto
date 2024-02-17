package com.example.equipobaloncesto.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import com.example.equipobaloncesto.MainActivity2
import com.example.equipobaloncesto.R
import com.example.equipobaloncesto.database.MiAppDatabase
import com.example.equipobaloncesto.database.entities.Jugador
import com.example.equipobaloncesto.database.entities.Resultado
import kotlinx.coroutines.launch

class MainActivityAltaResultado : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_alta_resultado)
        val equipoL = findViewById<EditText>(R.id.editTextTextEquipoLocal)
        val equipoV = findViewById<EditText>(R.id.editTextTextEquipoVisitante)
        val puntosEL =findViewById<EditText>(R.id.editTextTextPELocal)
        val puntosVe = findViewById<EditText>(R.id.editTextTextEquipoVisitante)
        val fecha = findViewById<EditText>(R.id.editTextTextFecha)
        val volver = findViewById<TextView>(R.id.btVolver)
        val crear = findViewById<TextView>(R.id.textViewCrearResultado)


        volver.setOnClickListener{
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }
        crear.setOnClickListener {
            lifecycleScope.launch(){
                databaseAccess(equipoL.text.toString(),equipoV.text.toString(),Integer.parseInt(puntosEL.text.toString()),Integer.parseInt(puntosVe.text.toString()),fecha.text.toString())
            }
        }
    }
    suspend fun databaseAccess(equipoL:String,equipoV:String,puntosEL:Int,puntosVe:Int,fecha:String) {
        val db = MiAppDatabase.getInstance(this)
        val equipoDao = db.equipoDao()

        val resultadoDao = db.resultadoDao()

        // Comprobar si el equipo ya existe
        val equipoExistenteLocal = equipoDao.obtenerEquipos().find { it.nombre_equipo == equipoL }
        val equipoExistenteVisitante = equipoDao.obtenerEquipos().find { it.nombre_equipo == equipoV }
        if (equipoExistenteLocal != null && equipoExistenteVisitante != null) {
            // El equipo existe, se puede crear el jugador
            val resultado = Resultado(null,equipoL ,equipoV, puntosEL, puntosVe,fecha)
            try {
                resultadoDao.insertarResultado(resultado)

                val intent = Intent(this, MainActivityOption::class.java)
                startActivity(intent)
                Toast.makeText(this, "Resultado creado con éxito!", Toast.LENGTH_LONG).show()
            } catch (e: Exception) {
                Toast.makeText(this, "No se puede crear el resultado!", Toast.LENGTH_LONG).show()
            }
        } else {
            // El equipo no existe, mostrar un mensaje al usuario
            Toast.makeText(this, "El resultado no existe en la base de datos!", Toast.LENGTH_LONG).show()
        }
    }
}