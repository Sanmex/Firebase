package com.example.firebase.model

import androidx.room.Embedded
import androidx.room.Relation

data class ContactoWithTelefono(
    @Embedded val contacto: Contacto,
    @Relation(
        parentColumn = "id",
        entityColumn = "contactoId"
    )
    val tels:List<Telefono>
)