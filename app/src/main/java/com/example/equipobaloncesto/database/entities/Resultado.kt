package com.example.equipobaloncesto.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "resultados")
data class Resultado(
    @PrimaryKey val id: Int,
    val equipo_local: String,
    val equipo_visitante: String,
    val fecha: String,
    val resultado: String
)