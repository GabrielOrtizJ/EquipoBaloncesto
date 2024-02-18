package com.example.equipobaloncesto.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.equipobaloncesto.database.entities.Clasificacion

@Dao
interface ClasificacionDao {

    @Insert
    suspend fun insertClasificacion(clasificacion: Clasificacion)
    @Query("SELECT * FROM clasificacion WHERE nombre_equipoF = :nombre_equipo")
    suspend fun getClasificacionByEquipo(nombre_equipo: String): Clasificacion
    @Query("SELECT * FROM clasificacion ORDER BY puntos DESC")
    suspend fun getAllOrderedByPuntosDesc(): List<Clasificacion>
    @Query("Update clasificacion set puntos= :puntos where id = :id ")
    suspend fun updateClasamentoById(id:Int,puntos:Int):Int
    @Delete
    suspend fun deleteClasificacion(clasificacion: Clasificacion)
}