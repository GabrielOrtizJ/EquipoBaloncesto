package com.example.equipobaloncesto.database.entities

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(tableName = "equipos", indices = [Index(value = ["nombre_equipo"], unique = true)])
data class Equipo(
    @PrimaryKey (autoGenerate = true) val id: Int?,
    val nombre_equipo: String,
    val ciudad: String,
    val nombre_pabellón: String
)