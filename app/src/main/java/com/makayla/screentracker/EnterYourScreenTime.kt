package com.makayla.screentracker

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class EnterYourScreenTime : AppCompatActivity() {

    // array to collect data for Morning screentime
    val morningScreenTime = arrayOf(0, 0, 0, 0, 0, 0, 0)

    // array to collect data for afternoon screentime
    val afternoonScreenTime = arrayOf(0, 0, 0, 0, 0, 0, 0)

    // array to collect data regarding the note
    val noteScreenTime = arrayOf("", "", "", "", "", "", "")

    val dateRecorded = arrayOf("", "", "", "", "", "", "")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_enter_your_screen_time)

        val dayCounter = findViewById<TextView>(R.id. txtDayCounter)
        val dateEntered = findViewById<EditText>(R.id.edtDate)
        val morningScreentime = findViewById<EditText>(R.id.edtMorningScreentime)
        val afternoonScreentime = findViewById<EditText>(R.id.edtAfternoonScreentime)
        val noteScreentime = findViewById<EditText>(R.id.edtAddNote)
        val btnNewInfo = findViewById<Button>(R.id.btnReEnter)
        val btnNextScreen = findViewById<Button>(R.id.btnNextScreen)

        btnNextScreen.setOnClickListener {

            // save what was typed into an Array
            dateRecorded[0] = dateEntered.text.toString()
            morningScreenTime[0] = morningScreentime.text.toString().toInt()
            afternoonScreenTime[0] = afternoonScreentime.text.toString().toInt()
            noteScreenTime[0] = noteScreentime.text.toString()

            // navigate to the next screen
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun calculateTotal(morning: IntArray, afternoon: IntArray): Int{

        var total = 0
        var counter = 0
       while (counter < morning.count()) {
           total += morning[counter] + afternoon[counter]
           counter++
       }
        return total
    }
}