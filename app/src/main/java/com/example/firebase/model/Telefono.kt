package com.example.firebase.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tabla_telefonos")
data class Telefono(
    @ColumnInfo(name = "id")
    @PrimaryKey(autoGenerate = true)
    var id:Long,
    @ColumnInfo(name = "numero")
    val numero:String,
    @ColumnInfo(name = "contactoId")
    val contactoId:Long
)