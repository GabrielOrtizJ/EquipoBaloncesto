package com.example.equipobaloncesto.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.equipobaloncesto.database.entities.Jugador


@Dao
interface JugadorDao {
    @Query("SELECT * FROM jugador WHERE nombre_equipoF  = :nombre_equipo")
    fun obtenerJugadoresPorEquipo(nombre_equipo : String): List<Jugador>

    @Insert
    fun insertarJugador(jugador: Jugador)

    @Update
    fun actualizarJugador(jugador: Jugador)

    @Delete
    fun borrarJugador(jugador: Jugador)
}

