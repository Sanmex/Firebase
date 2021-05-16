package com.example.firebase.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tabla_oferta")
data class Oferta(
    @ColumnInfo(name = "id")
    @PrimaryKey(autoGenerate = true)
    var id:Long,
    @ColumnInfo(name ="puesto")
    val puesto:String,
    @ColumnInfo(name = "salario")
    val salario:String,
    @ColumnInfo(name = "horario")
    val horario:String,
    @ColumnInfo(name = "contactoid")
    var contactoId:Long

)