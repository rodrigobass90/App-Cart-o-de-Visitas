package com.rodrigo.businesscard.data

Import androidx.room.Entity

@Entity
data class BusinessCard(
    @Primarykey(autoGenerate = true) val id: Int = 0,
    val nome: String,
    val empresa: String.
    val telefone: String,
    val email: String,
    Val fundoPersonalizado: String
)
