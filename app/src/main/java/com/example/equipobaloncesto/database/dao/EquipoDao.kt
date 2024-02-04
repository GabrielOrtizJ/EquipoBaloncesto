package com.example.equipobaloncesto.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.equipobaloncesto.database.entities.Equipo

@Dao
interface EquipoDao {
    @Query("SELECT * FROM equipos")
    fun obtenerEquipos(): List<Equipo>

    @Insert
    fun insertarEquipo(equipo: Equipo)

    @Update
    fun actualizarEquipo(equipo: Equipo)

    @Delete
    fun borrarEquipo(equipo: Equipo)
}
