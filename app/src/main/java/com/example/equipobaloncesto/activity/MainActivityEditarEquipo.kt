package com.example.equipobaloncesto.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.equipobaloncesto.R
import com.example.equipobaloncesto.database.MiAppDatabase
import com.example.equipobaloncesto.database.entities.Jugador
import com.example.equipobaloncesto.view.CustomerAdapterJugador
import kotlinx.coroutines.launch

class MainActivityEditarEquipo : AppCompatActivity(), CustomerAdapterJugador.OnClickListener {
    var nombreEquipo=""
    var listaJugador : List<Jugador>? = null
    lateinit var recyclerJugadores: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_editar_equipo)
        nombreEquipo = intent.getStringExtra("nombreEquipo").toString()
        var titulo = findViewById<TextView>(R.id.ElTitulo)
        titulo.text=nombreEquipo
        lifecycleScope.launch {
            databaseAccess()
        }
    }
    suspend fun databaseAccess() {
        val db = MiAppDatabase.getInstance(this)
        val jugadorDao = db.jugadorDao()
        try{
            listaJugador=jugadorDao.obtenerJugadoresPorEquipo(nombreEquipo)
            recyclerJugadores= findViewById(R.id.recyclerViewEditaJugadores)

            var jugadorAdapter = listaJugador?.let { CustomerAdapterJugador(it) }
            jugadorAdapter!!.setOnItemClickListener(this)
            recyclerJugadores.layoutManager = LinearLayoutManager(this)
            recyclerJugadores.adapter = jugadorAdapter

        }catch (e :Exception){
            Toast.makeText(this, "No se puede mostrar!", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onClick(jugador: Jugador) {
        Toast.makeText(this, "No se puede mostrar!", Toast.LENGTH_SHORT).show()
    }
    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.editar_menu, menu)
        if (menu != null) {

            menu.findItem(R.id.Insertar).setActionView(v)
            menu.findItem(R.id.Eliminar).setActionView(v)
            menu.findItem(R.id.Editar).setActionView(v)
        }

    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        val view = item.actionView as EditText
        return when (item.itemId) {
            R.id.Insertar -> {
        // copy(view)
                true
            }
            R.id.Eliminar -> {
        //paste(view)
                true
            }
            R.id.Editar -> {
        //paste(view)
                true
            }
            else -> super.onContextItemSelected(item)
        }
    }

}