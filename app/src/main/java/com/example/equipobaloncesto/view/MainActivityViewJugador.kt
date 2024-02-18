package com.example.equipobaloncesto.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.equipobaloncesto.R
import com.example.equipobaloncesto.activity.MainActivityOption
import com.example.equipobaloncesto.database.MiAppDatabase
import com.example.equipobaloncesto.database.entities.Clasificacion
import com.example.equipobaloncesto.database.entities.Jugador
import kotlinx.coroutines.launch

class MainActivityViewJugador : AppCompatActivity() {

    lateinit var recyclerViewJugador: RecyclerView
    private var listaJugador: List<Jugador>? =null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_view_jugador)
        val Enombre = findViewById<EditText>(R.id.editTextBuscarEquipo)
        val buscar = findViewById<TextView>(R.id.textViewBuscar)
        buscar.setOnClickListener {
            lifecycleScope.launch(){
                databaseAccess(Enombre.text.toString())

            }
        }


    }
    suspend fun databaseAccess(nombre:String) {
        val db = MiAppDatabase.getInstance(this)

        val jugadorDao = db.jugadorDao()

        try{
                listaJugador=jugadorDao.obtenerJugadoresPorEquipo(nombre)
                recyclerViewJugador= findViewById(R.id.recyclerViewJugadores)
                var jugadorAdapter = listaJugador?.let { CustomerAdapterJugador(it) }
                recyclerViewJugador.layoutManager = LinearLayoutManager(this)
                recyclerViewJugador.adapter = jugadorAdapter

            }catch (e :Exception){
                Toast.makeText(this, "No se puede mostrar!", Toast.LENGTH_SHORT).show()
            }


    }

}