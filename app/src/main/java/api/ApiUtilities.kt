package com.deepak.jokeapp.api


import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// Utility object to set up Retrofit and provide the JokeApiService
object ApiUtilities {

    // Define the base URL for the joke API
    //private const val BASE_URL = "https://official-joke-api.appspot.com/"
    const val BASE_URL =  "https://official-joke-api.appspot.com/"



    // Create Retrofit builder
    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL) // Set the base URL for the API
            .addConverterFactory(GsonConverterFactory.create()) // Use Gson to convert JSON to Kotlin objects
            .build()
    }

    // Create a function to provide the JokeApiService instance
    val apiService: JokeApiService by lazy {
        retrofit.create(JokeApiService::class.java)
    }
}