package com.deepak.jokeapp.api


// Data class to map the JSON response from the API
data class JokeResponse(
    val id: Int,          // The ID of the joke
    val type: String,     // The type of the joke (e.g., general, programming)
    val setup: String,    // The setup part of the joke
    val punchline: String // The punchline of the joke
)
