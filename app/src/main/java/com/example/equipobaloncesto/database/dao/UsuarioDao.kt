package com.example.equipobaloncesto.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.equipobaloncesto.database.entities.Usuario

@Dao
interface UsuarioDao {
    @Insert
    suspend fun insertarUsuario(vararg usuario: Usuario)

    @Update
    suspend fun actualizarUsuario(usuario: Usuario)

    @Delete
    suspend fun eliminarUsuario(usuario: Usuario)

    @Query("SELECT * FROM usuario WHERE nombre_usuario = :nombreUsuario")
    suspend fun obtenerUsuarioPorNombre(nombreUsuario: String): Usuario?

    @Query("SELECT * FROM usuario WHERE id_usuario = :idUsuario")
    suspend fun obtenerUsuarioPorId(idUsuario: Int): Usuario?

    @Query("SELECT * FROM usuario")
    suspend fun obtenerTodos(): List<Usuario>
}