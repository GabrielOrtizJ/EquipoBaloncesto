package com.example.equipobaloncesto.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.equipobaloncesto.database.entities.Resultado

@Dao
interface ResultadoDao {
    @Query("SELECT * FROM resultados")
    suspend fun obtenerResultados(): List<Resultado>

    @Insert
    suspend fun insertarResultado(resultado: Resultado)

    @Update
    suspend fun actualizarResultado(resultado: Resultado)

    @Delete
    suspend fun borrarResultado(resultado: Resultado)
}
