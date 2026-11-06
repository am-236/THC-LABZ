package com.example.thclabz.ui.main

import android.content.Intent
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import android.net.NetworkRequest
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.thclabz.R
import com.example.thclabz.data.Strain
import com.example.thclabz.databinding.ActivityMainBinding
import com.example.thclabz.ui.auth.AuthActivity
import com.example.thclabz.ui.settings.SettingsActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ListenerRegistration

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var db: FirebaseFirestore
    private lateinit var strainAdapter: StrainAdapter
    private var snapshotListener: ListenerRegistration? = null
    private lateinit var connectivityManager: ConnectivityManager
    private lateinit var networkCallback: ConnectivityManager.NetworkCallback

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (FirebaseAuth.getInstance().currentUser == null) {
            startActivity(Intent(this, AuthActivity::class.java))
            finish()
            return
        }

        db = FirebaseFirestore.getInstance()
        setupRecyclerView()
        setupNetworkMonitoring()
        setupRealtimeFirestoreListener()

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

    // Real-Time Notification & Data Sync via Firestore SnapshotListener
    private fun setupRealtimeFirestoreListener() {
        snapshotListener = db.collection("strains")
            .addSnapshotListener { snapshot, error ->
                if (error != null) {
                    Log.w("API", "Error listening for strain changes.", error)
                    Toast.makeText(this, getString(R.string.msg_loading_failed), Toast.LENGTH_SHORT).show()
                    return@addSnapshotListener
                }

                if (snapshot != null) {
                    val strainList = snapshot.documents.mapNotNull { it.toObject(Strain::class.java) }
                    strainAdapter.submitList(strainList)
                    Log.d("API", "Real-time sync: updated ${strainList.size} strains.")
                }
            }
    }

    // Offline Mode Connectivity Monitoring
    private fun setupNetworkMonitoring() {
        connectivityManager = getSystemService(CONNECTIVITY_SERVICE) as ConnectivityManager
        
        networkCallback = object : ConnectivityManager.NetworkCallback() {
            override fun onAvailable(network: Network) {
                runOnUiThread {
                    binding.tvOfflineStatus.visibility = View.GONE
                }
            }

            override fun onLost(network: Network) {
                runOnUiThread {
                    binding.tvOfflineStatus.visibility = View.VISIBLE
                }
            }
        }

        val networkRequest = NetworkRequest.Builder()
            .addCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
            .build()
        connectivityManager.registerNetworkCallback(networkRequest, networkCallback)

        // Initial check
        val activeNetwork = connectivityManager.activeNetwork
        val capabilities = connectivityManager.getNetworkCapabilities(activeNetwork)
        val isConnected = (capabilities != null) && capabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
        binding.tvOfflineStatus.visibility = if (isConnected) View.GONE else View.VISIBLE
    }

    override fun onDestroy() {
        super.onDestroy()
        snapshotListener?.remove()
        try {
            connectivityManager.unregisterNetworkCallback(networkCallback)
        } catch (e: Exception) {
            Log.w("Network", "Error unregistering network callback", e)
        }
    }
}
