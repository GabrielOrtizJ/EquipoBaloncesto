package com.example.equipobaloncesto.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.example.equipobaloncesto.R
import com.example.equipobaloncesto.database.MiAppDatabase
import com.example.equipobaloncesto.database.entities.Clasificacion
import kotlinx.coroutines.launch

class MainActivityViewClasificacion : AppCompatActivity() {
    lateinit var recyclerClasamento : RecyclerView
    var listaEquipoClasamento : List<Clasificacion>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_view_clasificacion)
        lifecycleScope.launch {
            databaseAccess()
        }
    }

    suspend fun databaseAccess() {
        val db = MiAppDatabase.getInstance(this)

        val clasificacionDao = db.clasificacionDao()

        try{
            listaEquipoClasamento=clasificacionDao.getAllOrderedByPuntosDesc()

            recyclerClasamento= findViewById(R.id.reciclerViewClasificacion)

            var clasificacionAdapter = listaEquipoClasamento?.let { CustomerAdapterClasificacion(it) }

            recyclerClasamento.layoutManager = LinearLayoutManager(this)

            recyclerClasamento.adapter = clasificacionAdapter

        }catch (e :Exception){
            Toast.makeText(this, "Error al mostrar!", Toast.LENGTH_SHORT).show()
        }
    }
}