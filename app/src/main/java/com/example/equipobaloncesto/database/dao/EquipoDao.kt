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
    suspend fun obtenerEquipos(): List<Equipo>
    @Insert
    suspend fun insertEquipo(equipo: Equipo)

 @Update
 suspend fun actualizarEquipo(equipo: Equipo)

    @Delete
    suspend fun borrarEquipo(equipo: Equipo)
}
