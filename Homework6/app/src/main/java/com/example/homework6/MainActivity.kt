package com.example.homework6

import android.app.DatePickerDialog
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.example.homework6.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    companion object {

        const val DEBUG = "Debug_"

        const val CLASS_NAME = "MainActivity"

        const val STRING_FORMAT_DM: String = "%02d"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.btnChangeTheme.setOnClickListener {
            if(AppCompatDelegate.getDefaultNightMode().toString() == "2") {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }
            else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            }
            //Log.d(DEBUG, "$CLASS_NAME " + AppCompatDelegate.getDefaultNightMode().toString())
        }

        binding.btnOpenDialog.setOnClickListener {
            val myDateListener = DatePickerDialog.OnDateSetListener { _, year, month, day ->
                val date = getString(
                    R.string.dateFormat,
                    String.format(Locale.ENGLISH, STRING_FORMAT_DM, day),
                    String.format(Locale.ENGLISH, STRING_FORMAT_DM, month + 1),
                    year.toString()
                )
                binding.dateText.text = date
            }
            val datePickerDialog = DatePickerDialog(this, myDateListener, 1990, 0, 1)
            datePickerDialog.setCanceledOnTouchOutside(false);
            datePickerDialog.show()
        }
    }
}