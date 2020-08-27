package com.ampaschal.soilinfo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import com.google.firebase.database.FirebaseDatabase
import org.koin.androidx.viewmodel.ext.android.viewModel

const val VERSION = "version1"

class MainActivity : AppCompatActivity() {

    private val mainViewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        FirebaseDatabase.getInstance().setPersistenceEnabled(true)
        mainViewModel.loadBuildState(VERSION)
        mainViewModel.buildState.observe(this, Observer { state ->
            if (state != null && !state) {
                Toast.makeText(applicationContext, "This build has been disabled", Toast.LENGTH_SHORT).show()
                finishAffinity()
            }
        })

    }
}
