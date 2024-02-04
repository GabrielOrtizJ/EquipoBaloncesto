package com.example.equipobaloncesto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem

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
            return true
        } else if (item.itemId == R.id.alta_resultados) {
            return true
        } else if (item.itemId == R.id.listado_equipos) {
            return true
        } else if (item.itemId == R.id.alta_equipo) {
            return true
        } else {
            return super.onOptionsItemSelected(item)
        }
    }
}