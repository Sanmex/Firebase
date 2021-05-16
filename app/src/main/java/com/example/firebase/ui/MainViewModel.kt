package com.example.firebase.ui


import android.app.Application
import androidx.lifecycle.*
import com.example.firebase.model.*
import com.example.firebase.repo.Repository
import com.example.firebase.repo.RepositoryImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class MainViewModel(application: Application) : AndroidViewModel(application){

        private val repositorio:Repository=RepositoryImpl(application)

        private var contId:Long=0L
        //contacto
        private val contactoRepo=RepositoryImpl(application)//para iniciar lista
        //listacitas
        //val citalistas=repoCita.listaCitas()
        //revisar si necesario iniciar aqui lista de contactos
        val contactos=contactoRepo.readAllData()
        //las listas con id
        private val citasId= MutableLiveData<Long>()
        var parametroBusqueda=MutableLiveData<String>()
        var contaList=MutableLiveData<List<Contacto>>()




        suspend fun saveContact(contacto: Contacto)= withContext(Dispatchers.IO) {
            repositorio.saveContactr(contacto)
        }

        fun updateContact(contacto: Contacto){
            viewModelScope.launch (Dispatchers.IO){
                repositorio.updateContactr(contacto)
            }
        }
        fun borrarContacto(contacto: Contacto){
            viewModelScope.launch (Dispatchers.IO){
                repositorio.deleteContactr(contacto)
            }
        }

        fun saveTelList(telefonos: Telefono) {
            viewModelScope.launch {
                repositorio.saveTel(telefonos)
            }

        }

        fun editarTel(telefonos: Telefono) {
            viewModelScope.launch(Dispatchers.IO) {
                repositorio.updateTel(telefonos)
            }

        }

        fun saveOfer(oferta: Oferta){
            viewModelScope.launch (Dispatchers.IO){
                repositorio.saveOfer(oferta)
            }
        }
        fun updateOfer(oferta: Oferta){
            viewModelScope.launch(Dispatchers.IO) {
                repositorio.updateOfer(oferta)
            }
        }

        //borrar oferta en cascada con contacto.

        //obtener contacto

        fun searchDatabase(searchQuery:String): LiveData<List<Contacto>> = repositorio.searchDatabase(searchQuery)
        //listasrelacionales

        // fun getContaCita(cid:Long):LiveData<List<ContactoAndCita>> = repositorio.getContCitas(cid)


        fun getContacList():LiveData<List<Contacto>> = repositorio.readAllData()

        fun getContactCita(cid:Long):LiveData<ContactoWithCita> = repositorio.getContactAppointr(cid)

        fun getContTel(cid: Long):LiveData<ContactoWithTelefono> = repositorio.getContacTelr(cid)


        //long guarda los id
        fun saveCitaList(cita: Cita) {
            viewModelScope.launch(Dispatchers.IO) {
                repositorio.saveAppoint(cita)
            }

        }

        fun updateAppoint(cita: Cita){
            viewModelScope.launch(Dispatchers.IO ) {
                repositorio.updateAppoint(cita)
            }
        }
        fun deleteAppoint(cita: Cita){
            viewModelScope.launch (Dispatchers.IO){
                repositorio.deleteAppoint(cita)
            }
        }
        fun listAppoint():LiveData<List<Cita>> = repositorio.listaAppoint()


       // fun search(query:String) :LiveData<List<Contacto>> = repositorio.searchDatabase()


    }

