package com.example.firebase.domain

import androidx.room.*
import com.example.firebase.model.Telefono

@Dao
interface TelefonoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveTel(telefonos: Telefono):Long
    //actualizar telefonos
    @Update
    suspend fun updateTel(telefonos: Telefono)
    //borrar
    @Delete
    suspend fun deleteTel(telefonos: Telefono)
}