package com.example.homework5

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.homework5.databinding.ActivityFirstBinding

class FirstActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityFirstBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_first)
        Log.d(LIFECYCLE, "$CLASS_NAME onCreate()")

        binding.button.setOnClickListener {
            when {
                binding.rastring.isChecked -> startPentaActivityWithString(binding.edittext.text.toString())
                binding.raboolean.isChecked -> startPentaActivityWithBoolean(true)
                binding.raarrayobj.isChecked -> startPentaActivityWithArrObj()
                else -> Log.d("Unknown command", "$CLASS_NAME other button checked")
            }
        }
    }

    private fun startPentaActivityWithString(text: String) {
        startActivity(PentaActivity.newInstance(this, text))
    }

    private fun startPentaActivityWithBoolean(boolean: Boolean) {
        startActivity(PentaActivity.newInstance(this, boolean))
    }

    private fun startPentaActivityWithArrObj() {
        val list = mutableListOf<MyData>()

        for (i in 0..4) {
            list.add(MyData("data $i", "$i".toInt()))
        }

        startActivity(PentaActivity.newInstance(this, list.toTypedArray()))
    }

    override fun onStart() {
        super.onStart()
        Log.d(LIFECYCLE, "$CLASS_NAME onStart()")
    }

    override fun onResume() {
        super.onResume()
        Log.d(LIFECYCLE, "$CLASS_NAME onResume()")
    }

    override fun onPause() {
        super.onPause()
        Log.d(LIFECYCLE, "$CLASS_NAME onPause()")
    }

    override fun onStop() {
        super.onStop()
        Log.d(LIFECYCLE, "$CLASS_NAME onStop()")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(LIFECYCLE, "$CLASS_NAME onDestroy()")
    }

    companion object {
        const val LIFECYCLE = "Lifecycle_"
        const val CLASS_NAME = "_FirstActivity"
    }
}