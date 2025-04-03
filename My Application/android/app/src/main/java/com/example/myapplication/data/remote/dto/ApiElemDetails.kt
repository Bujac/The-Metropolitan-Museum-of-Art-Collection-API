package com.example.myapplication.data.remote.dto

import com.example.myapplication.domain.model.ElemDetails
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ApiElemDetails(
    @Json(name = "objectID") val objectID: Int,
    @Json(name = "isHighlight") val isHighlight: Boolean,
    @Json(name = "accessionNumber") val accessionNumber: String,
    @Json(name = "isPublicDomain") val isPublicDomain: Boolean,
    @Json(name = "accessionYear") val accessionYear: String,
    @Json(name = "primaryImage") val primaryImage: String,
    @Json(name = "department") val department: String,
    @Json(name = "objectName") val objectName: String,
    @Json(name = "title") val title: String,
    @Json(name = "culture") val culture: String,
    @Json(name = "period") val period: String,
)

fun ApiElemDetails.toElemDetails() : ElemDetails{
    return ElemDetails(
        objectID = objectID,
        isHighlight = isHighlight,
        accessionNumber = accessionNumber,
        isPublicDomain = isPublicDomain,
        accessionYear = accessionYear,
        primaryImage = primaryImage,
        department = department,
        objectName = objectName,
        title = title,
        culture = culture,
        period = period,
    )
}