package com.brevitz.navigationcomponenttest.core.data

data class DataResponse(
    val children: List<DataChildResponse>,
    val before: String?,
    val after: String?
)
