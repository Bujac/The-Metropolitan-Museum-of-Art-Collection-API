package com.example.myapplication.ui.element_detail


import kotlinx.serialization.Serializable
//clasa serializabila, adica care poate fi convertita intr-un tip de date care poate fi transmis
@Serializable
data class ElemDetailsRoute(
    val elementId : Int
)
