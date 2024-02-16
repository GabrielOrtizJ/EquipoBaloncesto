package com.example.equipobaloncesto

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import com.example.equipobaloncesto.database.MiAppDatabase
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val Usuario = findViewById<EditText>(R.id.editTextUser)
        val pwd = findViewById<EditText>(R.id.editTextPassword)
        val check = findViewById<CheckBox>(R.id.checkBoxRecordar)

        val sharedPreferences = getSharedPreferences("MyApp", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()

        // Cargar datos guardados
        Usuario.setText(sharedPreferences.getString("Username", ""))
        pwd.setText(sharedPreferences.getString("Password", ""))
        check.isChecked = sharedPreferences.getBoolean("RememberMe", false)

        val entrar = findViewById<TextView>(R.id.textViewEntrar)
        entrar.setOnClickListener{
            if (check.isChecked) {
                // Guardar datos del usuario
                editor.putString("Username", Usuario.text.toString())
                editor.putString("Password", pwd.text.toString())
                editor.putBoolean("RememberMe", true)
                editor.putLong("LoginTime", System.currentTimeMillis())
                editor.apply()
            }
            val intent = Intent(this,MainActivity2::class.java)
            startActivity(intent)
        }

        val rememberMe = sharedPreferences.getBoolean("RememberMe", false)
        val loginTime = sharedPreferences.getLong("LoginTime", 0)
        val twoDaysMillis: Long = 2 * 24 * 60 * 60 * 1000

        if (rememberMe && System.currentTimeMillis() - loginTime < twoDaysMillis) {
            val intent = Intent(this,MainActivity2::class.java)
            startActivity(intent)
            finish()
        }



    }


}