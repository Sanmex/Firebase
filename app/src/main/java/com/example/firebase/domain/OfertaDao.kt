package com.example.firebase.domain

import androidx.room.*
import com.example.firebase.model.Oferta

@Dao
interface OfertaDao  {

        //registro oferta
        @Insert(onConflict = OnConflictStrategy.REPLACE)
        suspend fun saveOfer(oferta: Oferta)
        // editar oferta
        @Update
        suspend fun updateOfer(oferta: Oferta)
        //borrar oferta
        @Delete
        suspend fun deleteOfer(oferta: Oferta)
        //tiene que regresar la empresa con la oferta por nombre


    }
