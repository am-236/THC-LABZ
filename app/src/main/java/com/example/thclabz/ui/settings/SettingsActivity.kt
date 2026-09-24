package com.example.thclabz.ui.settings

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.thclabz.databinding.ActivitySettingsBinding
import com.google.firebase.auth.FirebaseAuth

class SettingsActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySettingsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySettingsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSaveSettings.setOnClickListener {
            val pref = binding.etPreferences.text.toString()
            // Save to local SharedPreferences or update user profile in DB
            Toast.makeText(this, "Settings Saved: $pref", Toast.LENGTH_SHORT).show()
        }

        binding.btnLogout.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            finish() // Return to AuthActivity
        }
    }
}