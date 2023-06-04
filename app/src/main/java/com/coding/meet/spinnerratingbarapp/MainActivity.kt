package com.coding.meet.spinnerratingbarapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.RatingBar
import android.widget.Spinner
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private val languageList = arrayListOf(
        "English",
        "Hindi (हिंदी)",
        "Japanese (日本)",
        "Chinese (中国人)",
        "Spanish (Española)",
        "German (Deutsch)",
        "French (Français)",
        "Portuguese (Português)",
        "Italian (Italiana)",
        "Arabic (عربي)",
        "Russian (Русский)",
        "Korean (한국인)",
        "Indonesian (bahasa Indonesia)",
        "Catalan (català)"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // simple spinner dropdown item
        val simpleLangSpinner = findViewById<Spinner>(R.id.simpleLangSpinner)
        simpleLangSpinner.adapter =
            ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, languageList)

        simpleLangSpinner.onItemSelectedListener = object : OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, view: View?, position: Int, p3: Long) {
                Toast.makeText(
                    this@MainActivity,
                    languageList[position],
                    Toast.LENGTH_LONG
                ).show()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }

        }

        val simpleLangBtn = findViewById<Button>(R.id.simplelangBtn)
        simpleLangBtn.setOnClickListener {
            Toast.makeText(
                this@MainActivity,
                languageList[simpleLangSpinner.selectedItemPosition],
                Toast.LENGTH_LONG
            ).show()
        }


        // custom Spinner View
        val customViewLanSpinner = findViewById<Spinner>(R.id.customViewLanSpinner)
        customViewLanSpinner.adapter =
            ArrayAdapter(this, R.layout.language_layout, R.id.languageTxt, languageList)

        customViewLanSpinner.onItemSelectedListener = object : OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, view: View?, position: Int, p3: Long) {
                Toast.makeText(
                    this@MainActivity,
                    languageList[position],
                    Toast.LENGTH_LONG
                ).show()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {}
        }

        val customShowBtn = findViewById<Button>(R.id.customlangBtn)
        customShowBtn.setOnClickListener {
            Toast.makeText(
                this@MainActivity,
                languageList[customViewLanSpinner.selectedItemPosition],
                Toast.LENGTH_LONG
            ).show()
        }


        // rating bar
        val ratingbar = findViewById<RatingBar>(R.id.ratingBar)
        val showRatingBtn = findViewById<Button>(R.id.showRatingBtn)
        showRatingBtn.setOnClickListener {
            val noOfStar = ratingbar.numStars
            val getRating = ratingbar.rating

            Toast.makeText(this, "Rating: $getRating/$noOfStar", Toast.LENGTH_LONG).show()
        }
    }
}