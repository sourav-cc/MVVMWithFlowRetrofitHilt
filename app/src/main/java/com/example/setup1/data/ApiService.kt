package com.example.setup1.data

import com.example.setup1.data.model.SampleResponse
import retrofit2.http.GET

interface ApiService {

    @GET("e42331cd-ead0-4da4-bf86-0420e7bce5f5")
    suspend fun getSampleData() : SampleResponse
//    https://run.mocky.io/v3/8993f634-0355-4f3c-976f-e2e561519bd4
}