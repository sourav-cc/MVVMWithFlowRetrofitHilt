package com.example.setup1.data.model


import com.google.gson.annotations.SerializedName

data class SampleResponse(
    @SerializedName("description")
    val description: String,
    @SerializedName("tile")
    val tile: String
)