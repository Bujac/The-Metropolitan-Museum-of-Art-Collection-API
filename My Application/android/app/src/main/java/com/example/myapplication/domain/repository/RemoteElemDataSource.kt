package com.example.myapplication.domain.repository

import com.example.myapplication.data.remote.dto.ApiElemDetails
import com.example.myapplication.data.remote.dto.ApiElement

interface RemoteElemDataSource {
    suspend fun getElements(query: String): ApiElement
    suspend fun getElemDetails(objectId: Int): ApiElemDetails
}