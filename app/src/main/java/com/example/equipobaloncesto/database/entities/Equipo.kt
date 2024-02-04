package com.example.equipobaloncesto.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "equipos")
data class Equipo(
    @PrimaryKey val id: Int,
    val nombre_equipo: String,
    val ciudad: String,
    val nombre_pabellón: String
)