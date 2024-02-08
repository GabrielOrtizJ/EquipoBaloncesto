package com.example.equipobaloncesto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import com.example.equipobaloncesto.database.MiAppDatabase
import com.example.equipobaloncesto.database.entities.Usuario
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


val entrar = findViewById<TextView>(R.id.textViewEntrar)
entrar.setOnClickListener{
    val intent = Intent(this,MainActivity2::class.java)
    startActivity(intent)
}

        lifecycleScope.launch {
            databaseAccess()
        }
    }

    suspend fun databaseAccess(){
        val db = Room.databaseBuilder(
            applicationContext,
            MiAppDatabase::class.java, "DDBB"
        ).build()

//
//        val usuarioDao = db.usuarioDao()
//
//        var usuario = Usuario(5, "Antonio", "Antonio1")
//         usuarioDao.insertarUsuario(usuario)
//        val usuarios: List<Usuario> = usuarioDao.obtenerTodos()
//
//        val i = 0
    }
}