package com.example.firebase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.firebase.domain.CitaDao
import com.example.firebase.domain.ContactoDao
import com.example.firebase.domain.OfertaDao
import com.example.firebase.domain.TelefonoDao
import com.example.firebase.model.Cita
import com.example.firebase.model.Telefono
import com.example.firebase.model.Contacto
import com.example.firebase.model.Converters
import com.example.firebase.model.Oferta

//underline conection of the data
@Database(entities =[Contacto::class,
    Oferta::class, Cita::class, Telefono::class],
    version = 1,exportSchema = false)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun contactoDao(): ContactoDao
    abstract fun ofertaDao(): OfertaDao
    abstract fun citaDao(): CitaDao
    abstract fun telefonoDao(): TelefonoDao

    //solo una instancia
    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            val tempInstance = INSTANCE

            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "contactoDB"
                ).build()
                INSTANCE= instance
                return instance
            }

        }
    }
}