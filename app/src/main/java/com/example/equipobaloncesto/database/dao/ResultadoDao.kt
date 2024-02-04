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
    fun obtenerResultados(): List<Resultado>

    @Insert
    fun insertarResultado(resultado: Resultado)

    @Update
    fun actualizarResultado(resultado: Resultado)

    @Delete
    fun borrarResultado(resultado: Resultado)
}
