package com.example.equipobaloncesto.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "clasificacion")
data class Clasificacion(
    @PrimaryKey val id: Int,
    val equipo: String,
    val puntos: Int
)
