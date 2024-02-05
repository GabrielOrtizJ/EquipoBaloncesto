package com.example.equipobaloncesto

import android.content.Intent
import android.graphics.drawable.AnimatedImageDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.ImageView
import com.example.equipobaloncesto.activity.MainActivityAltaEquipo
import com.example.equipobaloncesto.activity.MainActivityAltaResultado
import com.example.equipobaloncesto.activity.MainActivityClasificacion
import com.example.equipobaloncesto.activity.MainActivityListadoEquipo

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.option_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.salir) {
            finish();
            return true
        } else if (item.itemId == R.id.Clasificación) {
            val intent = Intent(this,MainActivityClasificacion::class.java)
            startActivity(intent)
            return true
        } else if (item.itemId == R.id.alta_resultados) {
            val intent = Intent(this,MainActivityAltaResultado::class.java)
            startActivity(intent)
            return true
        } else if (item.itemId == R.id.listado_equipos) {
            val intent = Intent(this,MainActivityListadoEquipo::class.java)
            startActivity(intent)
            return true
        } else if (item.itemId == R.id.alta_equipo) {
            val intent = Intent(this,MainActivityAltaEquipo::class.java)
            startActivity(intent)
            return true
        } else {
            return super.onOptionsItemSelected(item)
        }
    }
}