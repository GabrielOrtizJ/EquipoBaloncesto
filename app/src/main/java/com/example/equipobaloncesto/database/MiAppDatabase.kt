package com.example.equipobaloncesto.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.equipobaloncesto.database.dao.ClasificacionDao
import com.example.equipobaloncesto.database.dao.EquipoDao
import com.example.equipobaloncesto.database.dao.JugadorDao
import com.example.equipobaloncesto.database.dao.ResultadoDao
import com.example.equipobaloncesto.database.entities.Clasificacion
import com.example.equipobaloncesto.database.entities.Equipo
import com.example.equipobaloncesto.database.entities.Jugador
import com.example.equipobaloncesto.database.entities.Resultado

@Database(entities = [ Equipo::class, Jugador::class,
    Resultado::class, Clasificacion::class ], version = 1)
abstract class MiAppDatabase : RoomDatabase() {

    abstract fun equipoDao(): EquipoDao
    abstract fun jugadorDao(): JugadorDao
    abstract fun resultadoDao(): ResultadoDao
    abstract fun clasificacionDao(): ClasificacionDao

    companion object {
        @Volatile
        private var INSTANCE: MiAppDatabase? = null

        fun getInstance(context: Context): MiAppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    MiAppDatabase::class.java,
                    "DDBB"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}