package com.example.firebase.model

import androidx.room.Embedded
import androidx.room.Relation

data class ContactoWithCita(
    @Embedded val contacto: Contacto,
    @Relation(
        parentColumn="id",
        entityColumn="contactoId"
    )
    val citas:List<Cita>
)