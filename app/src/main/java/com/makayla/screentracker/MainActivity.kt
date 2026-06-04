// Makayla Walkerley
// ST1056306
package com.makayla.screentracker

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Declare the two buttons we are going to use

        val btnMainScreen = findViewById<Button>(R.id.btnGoMainScreen)
        val btnExitApp = findViewById<Button>(R.id.btnExitApp)

        // use setOnClickListner to move to next screen using intent
        btnMainScreen.setOnClickListener {
            val intent = Intent(this, EnterYourScreenTime::class.java)
            startActivity(intent)
        }

        // close the app
        btnExitApp.setOnClickListener {
            finishAffinity()
        }
    }
}