package com.example.myapplication.data.repository

import com.example.myapplication.data.remote.dto.toElemDetails
import com.example.myapplication.data.remote.dto.toElement
import com.example.myapplication.domain.model.Element
import com.example.myapplication.domain.model.ElemDetails
import com.example.myapplication.domain.repository.ElementsRepository
import com.example.myapplication.domain.repository.RemoteElemDataSource

class ElementsRepositoryImpl(private val remoteElemDataSource: RemoteElemDataSource):
    ElementsRepository {
    override suspend fun getElements(query: String): Element {
        return remoteElemDataSource.getElements(query = query).toElement()
    }

    override suspend fun getElemDetails(objectId: Int): ElemDetails {
        return remoteElemDataSource.getElemDetails(objectId = objectId).toElemDetails()
    }
}