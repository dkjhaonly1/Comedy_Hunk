package com.deepak.jokeapp.api


import retrofit2.Call
import retrofit2.http.GET

interface JokeApiService {
    // Use the @GET annotation to specify the endpoint of the API
    // This will fetch a random joke
    @GET("random_joke")
    fun getRandomJoke(): Call<JokeResponse>
}




// Define the API interface

