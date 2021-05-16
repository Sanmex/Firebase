package com.example.firebase.domain

import androidx.lifecycle.LiveData
import androidx.room.*
import androidx.room.OnConflictStrategy.REPLACE
import com.example.firebase.model.Contacto
import com.example.firebase.model.ContactoWithCita
import com.example.firebase.model.ContactoWithTelefono
@Dao
interface ContactoDao {
    //Guardar contactos
    @Insert(onConflict = REPLACE)
    suspend fun saveContact(contacto: Contacto):Long
    //Editar
    @Update
    suspend fun updateContact(contacto: Contacto)
    //Borrar
    @Delete
    suspend fun deleteContact(contacto: Contacto)

    //listado de contactos
    @Query("select * from tabla_contacto")
    fun listContact(): LiveData<List<Contacto>>

    //empresa y citas ,query por id
    @Transaction
    @Query("Select * from tabla_contacto where id=:contactoid")
    fun listaContactAppoint(contactoid: Long): LiveData<ContactoWithCita>
    //empresa y telefonos

    @Transaction
    @Query("Select * from tabla_contacto where id=:contactoid")
    fun listContactTels(contactoid: Long): LiveData<ContactoWithTelefono>

    @Query("SELECT * FROM tabla_contacto WHERE nombre LIKE :nombre")
    fun searchDatabase(nombre: String): LiveData<List<Contacto>>

}