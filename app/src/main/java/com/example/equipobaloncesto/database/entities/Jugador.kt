package com.example.equipobaloncesto.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.Companion.CASCADE
import androidx.room.PrimaryKey

@Entity(tableName = "jugadores", foreignKeys = [ForeignKey(entity = Equipo::class, parentColumns = ["id"]
    , childColumns = ["id_equipo"], onDelete = CASCADE)])
data class Jugador(
    @PrimaryKey val id: Int,
    val nombre: String,
    val dorsal: Int,
    val posición: String,
    @ColumnInfo(name = "id_equipo") val idEquipo: Int
)
