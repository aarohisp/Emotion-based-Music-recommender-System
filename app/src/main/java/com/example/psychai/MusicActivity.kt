package com.example.psychai

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.POST

class MusicActivity : AppCompatActivity() {

    val tags = MoodSelection.tag

    // Create a Retrofit instance
    val retrofit = Retrofit.Builder()
        .baseUrl("http://10.0.2.2:5000/") // Use the IP address of your local machine
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    // Create an instance of the API service
    val apiService = retrofit.create(ApiService::class.java)

    // Create the request body
    val requestBody = mapOf("tags" to "$tags")

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: MusicAdapter

    private lateinit var btnBack: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_music)

        btnBack = findViewById<Button>(R.id.btnBackToMood)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        adapter = MusicAdapter()
        recyclerView.adapter = adapter

        apiService.getRecommendations(requestBody).enqueue(object : Callback<List<Map<String, String>>> {
            override fun onResponse(
                call: Call<List<Map<String, String>>>,
                response: Response<List<Map<String, String>>>
            ) {
                if (response.isSuccessful) {
                    val results = response.body()
                    if (results != null) {
                        val recommendations = mutableListOf<MusicRecommendation>()
                        for (result in results) {
                            val recommendation = MusicRecommendation(
                                result["Artist"].toString(),
                                result["Song"].toString(),
                            )
                            recommendations.add(recommendation)
                        }
                        adapter.updateData(recommendations)
                        recyclerView.visibility = View.VISIBLE
                        // Log.d("TAG", "List size: ${recommendations.size}")
                    }
                } else {
                    Log.d("API_RESPONSE", "API call failed with code ${response.code()}")
                }
            }

            override fun onFailure(call: Call<List<Map<String, String>>>, t: Throwable) {
                Log.e("API_CALL", "Error occurred: ${t.message}")
                Toast.makeText(applicationContext, "Error occurred: ${t.message}", Toast.LENGTH_SHORT).show()
            }
        })

        btnBack.setOnClickListener {
            startActivity(Intent(this@MusicActivity,MoodSelection::class.java))
        }
    }
}
