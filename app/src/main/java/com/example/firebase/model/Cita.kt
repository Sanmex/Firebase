package com.example.firebase.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import java.util.*

@Entity(tableName = "tabla_citas")
data class Cita(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id:Long,
    @TypeConverters(Converters::class)
    @ColumnInfo(name = "fecha")
    var fechahora: Date,
    @ColumnInfo(name = "estrado")
    val estado:String,
    @ColumnInfo(name = "contactoId")
    val contactoId:Long
)