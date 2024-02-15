package com.example.equipobaloncesto.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey

import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(tableName = "jugador",
    foreignKeys = [ForeignKey(
        entity = Equipo::class,
        parentColumns = ["nombre_equipo"],
        childColumns = ["nombre_equipoF"],
        onDelete = ForeignKey.CASCADE
    )],
    indices = [Index("nombre_equipoF")])
data class Jugador(
    @PrimaryKey
    val nombre: String,
    val dorsal: Int,
    val posición: String,
    val nombre_equipoF: String
)