package com.example.thclabz.ui.main

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.thclabz.data.Strain
import com.example.thclabz.databinding.ActivityMainBinding
import com.example.thclabz.ui.settings.SettingsActivity
import com.google.firebase.firestore.FirebaseFirestore

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var db: FirebaseFirestore
    private lateinit var strainAdapter: StrainAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = FirebaseFirestore.getInstance()
        setupRecyclerView()
        fetchStrainsFromAPI()

        // Settings Navigation
        binding.btnSettings.setOnClickListener {
            startActivity(Intent(this, SettingsActivity::class.java))
        }
    }

    private fun setupRecyclerView() {
        strainAdapter = StrainAdapter()
        binding.rvStrains.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = strainAdapter
        }
    }

    // Simulating REST API fetch from Firestore
    private fun fetchStrainsFromAPI() {
        db.collection("strains")
            .get()
            .addOnSuccessListener { result ->
                val strainList = mutableListOf<Strain>()
                for (document in result) {
                    val strain = document.toObject(Strain::class.java)
                    strainList.add(strain)
                }
                strainAdapter.submitList(strainList)
                Log.d("API", "Successfully fetched ${strainList.size} strains.")
            }
            .addOnFailureListener { exception ->
                Log.w("API", "Error getting documents.", exception)
                Toast.makeText(this, "Failed to load data.", Toast.LENGTH_SHORT).show()
            }
    }
}