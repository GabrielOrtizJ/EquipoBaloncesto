package com.example.equipobaloncesto.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.equipobaloncesto.database.entities.Clasificacion


@Dao
interface ClasificacionDao {
    @Query("SELECT * FROM clasificacion ORDER BY puntos DESC")
    fun obtenerClasificacion(): List<Clasificacion>

    @Insert
    fun insertarClasificacion(clasificacion: Clasificacion)

    @Update
    fun actualizarClasificacion(clasificacion: Clasificacion)

    @Delete
    fun borrarClasificacion(clasificacion: Clasificacion)
}

