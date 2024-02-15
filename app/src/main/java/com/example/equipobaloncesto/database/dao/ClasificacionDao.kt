package com.example.equipobaloncesto.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.equipobaloncesto.database.entities.Clasificacion

@Dao
interface ClasificacionDao {

    // Inserta una clasificación en la base de datos
    @Insert
    suspend fun insertClasificacion(clasificacion: Clasificacion)

    // Obtiene la clasificación de un equipo por su nombre
    @Query("SELECT * FROM clasificacion WHERE nombre_equipoF = :nombreEquipo")
    suspend fun getClasificacionByEquipo(nombreEquipo: String): Clasificacion

    //Obtiene una lista con los equipos ordenados en funcion de los puntos
    @Query("SELECT * FROM clasificacion ORDER BY puntos DESC")
    suspend fun getAllOrderedByPuntosDesc(): List<Clasificacion>

    @Query("Update clasificacion set puntos= :puntos where id = :id ")
    suspend fun updateClasamentoById(id:Int,puntos:Int):Int

    // Elimina una clasificación de la base de datos
    @Delete
    suspend fun deleteClasificacion(clasificacion: Clasificacion)
}