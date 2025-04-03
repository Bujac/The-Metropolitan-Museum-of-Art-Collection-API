package com.example.myapplication.data.remote.dto

import com.example.myapplication.domain.model.Element
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ApiElement(
    @Json(name = "total") val total : Int,
    @Json(name = "objectIDs") val objectIDs : Array<Int>
)

fun ApiElement.toElement() : Element{
    return Element(
        objectIDs = objectIDs
    )
}