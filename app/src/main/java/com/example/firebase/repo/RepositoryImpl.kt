package com.example.firebase.repo

import android.app.Application
import androidx.lifecycle.LiveData
import com.example.firebase.AppDatabase
import com.example.firebase.domain.CitaDao
import com.example.firebase.domain.ContactoDao
import com.example.firebase.domain.OfertaDao
import com.example.firebase.domain.TelefonoDao
import com.example.firebase.model.*



class RepositoryImpl(application: Application):Repository {

    private val citaDao: CitaDao by lazy{
        AppDatabase.getDatabase(application).citaDao()
    }
    private val contactoDao:ContactoDao by lazy{
        AppDatabase.getDatabase(application).contactoDao()
    }
    private val telefonoDao: TelefonoDao by lazy{
        AppDatabase.getDatabase(application).telefonoDao()
    }
    private val ofertaDao:OfertaDao by lazy{
        AppDatabase.getDatabase(application).ofertaDao()
    }


   //implementacion contacto

    override  fun readAllData(): LiveData<List<Contacto>> =contactoDao.listContact()

    override fun getContacTelr(cid: Long): LiveData<ContactoWithTelefono> =contactoDao.listContactTels(cid)

    override fun getContactAppointr(cid: Long): LiveData<ContactoWithCita> =contactoDao.listaContactAppoint(cid)

    override suspend fun saveContactr(contacto: Contacto):Long =contactoDao.saveContact(contacto)

    override suspend fun updateContactr(contacto: Contacto) =contactoDao.updateContact(contacto)

    override suspend fun deleteContactr(contacto: Contacto) =contactoDao.deleteContact(contacto)

    // implementacion citas
    override suspend fun saveAppoint(cita: Cita)=citaDao.saveAppoint(cita)

    override suspend fun updateAppoint(cita: Cita)=citaDao.updateAppoint(cita)

    override suspend fun deleteAppoint(cita: Cita)= citaDao.deleteAppoint(cita)

    override fun listaAppoint(): LiveData<List<Cita>> =citaDao.listAppoint()

    //implementacion ofertas
    override suspend fun saveOfer(oferta: Oferta) =ofertaDao.saveOfer(oferta)

    override suspend fun updateOfer(oferta: Oferta) =ofertaDao.updateOfer(oferta)

    override suspend fun deleteOfer(oferta:Oferta)=ofertaDao.deleteOfer(oferta)

    //implementacion telefonos

    override suspend fun saveTel(telefonos: Telefono): Long = telefonoDao.saveTel(telefonos)

    override suspend fun updateTel(telefonos: Telefono) = telefonoDao.updateTel(telefonos)

    override suspend fun deleteTel(telefonos: Telefono) = telefonoDao.deleteTel(telefonos)


    override fun searchDatabase(name: String): LiveData<List<Contacto>> = contactoDao.searchDatabase(name)











}
