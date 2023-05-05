package com.example.psychai

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.psychai.databinding.ActivityHomeBinding
import com.google.firebase.auth.FirebaseAuth

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()

        binding.btnLogout.setOnClickListener {
            firebaseAuth.signOut()
            Toast.makeText(this,
                "Logging out",
                Toast.LENGTH_SHORT
            ).show()
            startActivity(Intent(this@HomeActivity, MainActivity::class.java))
        }

        binding.btnMood.setOnClickListener {
            startActivity(Intent(this@HomeActivity,MoodSelection::class.java))
        }
    }
}