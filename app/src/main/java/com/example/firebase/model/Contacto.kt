package com.example.firebase.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize


@Parcelize
@Entity(tableName = "tabla_contacto")
data class Contacto(
    @PrimaryKey(autoGenerate = true)
    // @ColumnInfo(name = "id")
    var id:Long=0L,
    @ColumnInfo(name = "nombre")
    var nombre:String,
    //@ColumnInfo(name = "direccion")
    var direccion:String,
    // @ColumnInfo(name = "mail")
    var mail:String
): Parcelable