package com.example.homework5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.homework5.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setTextView()
    }

    private fun setTextView() {
        binding.textView.setOnClickListener {
            Toast.makeText(this, "Toast on pressing text: " + binding.textView.text, Toast.LENGTH_SHORT).show()
        }

        binding.button.setOnClickListener {
            startActivity(Intent(this, FirstActivity::class.java))
        }

        binding.buttonSharedPrefs.setOnClickListener {
            startActivity(Intent(this, SharedPrefsActivity::class.java))
        }
    }
}