package com.example.firebase.domain

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.firebase.model.Cita
@Dao
interface CitaDao {

        //Guardar citas
        @Insert(onConflict = OnConflictStrategy.REPLACE)
        suspend fun saveAppoint(cita: Cita):Long
        //actualizar citas
        @Update
        suspend fun updateAppoint(cita: Cita)
        //borrar
        @Delete
        suspend fun deleteAppoint(cita: Cita)

        //listado de contactos
        @Query("select * from tabla_citas")
        fun listAppoint(): LiveData<List<Cita>>




}