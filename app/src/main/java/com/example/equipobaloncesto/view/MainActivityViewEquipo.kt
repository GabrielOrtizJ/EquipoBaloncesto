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
import com.example.equipobaloncesto.activity.MainActivityEditarEquipo
import com.example.equipobaloncesto.database.MiAppDatabase
import com.example.equipobaloncesto.database.entities.Equipo
import kotlinx.coroutines.launch

class MainActivityViewEquipo : AppCompatActivity(), CustomerAdapterEquipo.OnClickListener{
    lateinit var buscarEquipo: EditText
    lateinit var listaEquipos: RecyclerView
    private var equipos :List<Equipo>?=null
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_view_equipo)
        val buscar = findViewById<TextView>(R.id.textViewPaBuscar)
        buscarEquipo = findViewById(R.id.BuscarEquipo )
        listaEquipos = findViewById(R.id.reciclerViewEquipo)
        buscar.setOnClickListener {
            lifecycleScope.launch {
                databaseAccess(buscarEquipo.text.toString())
            }
        }
    }
    suspend fun databaseAccess(equipo:String) {
        val db = MiAppDatabase.getInstance(this)
        val equipoDao = db.equipoDao()

        try{
             equipos= equipoDao.getEquiposByNombre(equipo)
             var equipoAdapter = equipos?.let { CustomerAdapterEquipo(it) }
            equipoAdapter!!.setOnItemClickListener(this)
            listaEquipos.layoutManager = LinearLayoutManager(this) // aqui da error
             listaEquipos.adapter = equipoAdapter
        }catch (e :Exception){
            Toast.makeText(this, "No se a podido mostrar!", Toast.LENGTH_SHORT).show()
        }
    }
    override fun onClick(equipo: Equipo) {
        // Mostrar un Toast con el nombre del equipo
        Toast.makeText(this, "Equipo seleccionado: ${equipo.nombre_equipo}", Toast.LENGTH_SHORT).show()
        val intent = Intent(this, MainActivityEditarEquipo::class.java)
        intent.putExtra("nombreEquipo", equipo.nombre_equipo)
        startActivity(intent)
    }

}