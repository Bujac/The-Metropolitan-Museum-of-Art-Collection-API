package com.example.myapplication.data.repository

import com.example.myapplication.data.remote.METApi
import com.example.myapplication.data.remote.dto.ApiElement
import com.example.myapplication.data.remote.dto.ApiElemDetails
import com.example.myapplication.data.remote.metApi
import com.example.myapplication.domain.repository.RemoteElemDataSource

class RemoteElemDataSourceImpl : RemoteElemDataSource {

    private val api: METApi = metApi

    override suspend fun getElements(query: String): ApiElement {
        if (query.isBlank()){
            return ApiElement(0, emptyArray())
        }
        val response = api.getElements(query)

        if(response.isSuccessful){
            val responseBody = response.body()
            if (responseBody != null)
            {
                return responseBody
            }
        }
        return ApiElement(0, emptyArray())
    }

    override suspend fun getElemDetails(objectId: Int): ApiElemDetails
    {
        val response = api.getElemDetails(objectId = objectId)
        val responseBody = response.body()

        if (responseBody != null) {
            return responseBody
        } else {
            throw Exception("Response body is null")
        }
    }
}