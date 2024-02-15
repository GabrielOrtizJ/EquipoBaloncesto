package com.example.equipobaloncesto.database.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(tableName = "resultados",
    foreignKeys = [ForeignKey(
        entity = Equipo::class,
        parentColumns = ["nombre_equipo"],
        childColumns = ["equipo_localF"],
        onDelete = ForeignKey.CASCADE
    ), ForeignKey(
        entity = Equipo::class,
        parentColumns = ["nombre_equipo"],
        childColumns = ["equipo_visitanteF"],
        onDelete = ForeignKey.CASCADE
    )],indices = [Index("puntosLocal"), Index("puntosVisitantes")])
data class Resultado(
    @PrimaryKey (autoGenerate = true) val id: Int,
    val equipo_localF: String,
    val equipo_visitanteF: String,
    val fecha: String,
    val puntosLocal: String,
    val puntosVisitantes: String
)