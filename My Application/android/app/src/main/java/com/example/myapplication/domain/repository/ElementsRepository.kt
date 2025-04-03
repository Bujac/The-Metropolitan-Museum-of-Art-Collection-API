package com.example.myapplication.domain.repository

import com.example.myapplication.domain.model.Element
import com.example.myapplication.domain.model.ElemDetails

interface ElementsRepository{
    suspend fun getElements(query: String): Element
    suspend fun getElemDetails(objectId: Int): ElemDetails
}
