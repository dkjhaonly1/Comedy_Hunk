package com.deepak.jokeapp


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.deepak.jokeapp.api.ApiUtilities
import com.deepak.jokeapp.api.JokeResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var jokeTextView: TextView
    private lateinit var jokeButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) // Ensure your layout file name is correct

        // Initialize views
        jokeTextView = findViewById(R.id.jokeTextView)
        jokeButton = findViewById(R.id.jokeButton)

        // Set click listener for the button
        jokeButton.setOnClickListener {
            fetchJoke()
        }
    }

    // Function to fetch a joke from the API
    private fun fetchJoke() {
        ApiUtilities.apiService.getRandomJoke().enqueue(object : Callback<JokeResponse> {
            override fun onResponse(call: Call<JokeResponse>, response: Response<JokeResponse>) {
                if (response.isSuccessful) {
                    // Get the joke from the response
                    val joke = response.body()
                    jokeTextView.text = "${joke?.setup}\n\n${joke?.punchline}"
                } else {
                    // Show an error message if the response is not successful
                    Toast.makeText(this@MainActivity, "Failed to get joke!", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<JokeResponse>, t: Throwable) {
                // Show an error message if the request fails
                Toast.makeText(this@MainActivity, "Error: ${t.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }
}

