package com.example.myapplication.domain.model

data class ElemDetails(
    val objectID: Int = 0,
    val isHighlight: Boolean = false,
    val accessionNumber: String = "",
    val isPublicDomain: Boolean = false,
    val accessionYear: String = "",
    val primaryImage: String = "",
    val primaryImageSmall: String = "",
    val additionalImages: List<String> = emptyList(),
    val department: String = "",
    val objectName: String = "",
    val title: String = "",
    val culture: String = "",
    val period: String = "",
)
