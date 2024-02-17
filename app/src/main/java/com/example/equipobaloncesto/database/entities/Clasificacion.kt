package com.example.equipobaloncesto.database.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(tableName = "clasificacion",
    foreignKeys = [ForeignKey(
        entity = Equipo::class,
        parentColumns = ["nombre_equipo"],
        childColumns = ["nombre_equipoF"],
        onDelete = ForeignKey.CASCADE
    )],
    indices = [Index("nombre_equipoF")])
data class Clasificacion(
    @PrimaryKey(autoGenerate = true) val id: Int?,
    val puntos: Int,
    val nombre_equipoF: String
)
