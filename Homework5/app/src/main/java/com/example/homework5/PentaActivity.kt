package com.example.homework5

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button

class PentaActivity : AppCompatActivity() {

    private lateinit var buttonbundle: Button

    companion object {
        const val LIFECYCLE = "Lifecycle_"
        const val CLASS_NAME = "PentaActivity"

        private const val EXTRA_MESSAGE_KEY = "message_key"
        const val EXTRA_MESSAGE_DATA_CLASS_KEY = "extra_message_data_class_key"

        fun newInstance(context: Context) = Intent(context, PentaActivity::class.java)
        fun newInstance(context: Context, message: String? = null) = Intent(context, PentaActivity::class.java).apply {
            putExtra(EXTRA_MESSAGE_KEY + "_string", message)
        }

        fun newInstance(context: Context, boolean: Boolean? = null) = Intent(context, PentaActivity::class.java).apply {
            putExtra(EXTRA_MESSAGE_KEY + "_boolean", boolean)
        }

        fun newInstance(context: Context, arrobj: Array<MyData>? = null) = Intent(context, PentaActivity::class.java).apply {
            val bundle = Bundle()
            bundle.putParcelableArray(EXTRA_MESSAGE_DATA_CLASS_KEY, arrobj)
            putExtras(bundle)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_penta)
        Log.d(LIFECYCLE, "$CLASS_NAME onCreate()")

        buttonbundle = findViewById(R.id.buttonbundle)

        buttonbundle.setOnClickListener {
            getBundleInformation()
        }
    }

    private fun getBundleInformation() {
        val bundle = intent.extras
        when {
            bundle?.getString(EXTRA_MESSAGE_KEY + "_string", "none") != "none" -> {
                val extraMessage = bundle?.getString(EXTRA_MESSAGE_KEY + "_string", "Default value")
                Log.d(CLASS_NAME, "String=$extraMessage")
            }
            bundle?.getParcelableArray(EXTRA_MESSAGE_DATA_CLASS_KEY) != null -> {
                val arrayobj = bundle?.getParcelableArray(EXTRA_MESSAGE_DATA_CLASS_KEY)
                Log.d(CLASS_NAME, "Array=${arrayobj.contentToString()}")
            }
            else -> {
                val boolean = bundle?.getBoolean(EXTRA_MESSAGE_KEY + "_boolean")
                Log.d(CLASS_NAME, "Boolean=$boolean")
            }
        }
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
}