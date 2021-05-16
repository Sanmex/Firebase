package com.example.firebase.repo

import androidx.lifecycle.LiveData
import com.example.firebase.model.*

interface Repository {


     //Repositorio Contactos
    fun readAllData():LiveData<List<Contacto>>
    fun getContacTelr(contacto: Long):LiveData<ContactoWithTelefono>
    fun getContactAppointr(contacto: Long):LiveData<ContactoWithCita>
    suspend fun saveContactr(contacto: Contacto):Long
    suspend fun updateContactr(contacto: Contacto)
    suspend fun deleteContactr(contacto: Contacto)
    fun searchDatabase(name:String):LiveData<List<Contacto>>


    //Repositorio Citas
    suspend fun saveAppoint(cita: Cita):Long
    suspend fun updateAppoint(cita: Cita)
    suspend fun deleteAppoint(cita: Cita)
    fun listaAppoint():LiveData<List<Cita>>

    //Repositorio ofertas
    suspend fun saveOfer(oferta: Oferta)
    suspend fun updateOfer(oferta: Oferta)
    suspend fun deleteOfer(oferta: Oferta)

    //Repositorio telefonos
    suspend fun saveTel(telefonos: Telefono): Long
    suspend fun updateTel(telefonos: Telefono)
    suspend fun deleteTel(telefonos: Telefono)








}
