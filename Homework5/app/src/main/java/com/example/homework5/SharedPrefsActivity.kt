package com.example.homework5

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.homework5.databinding.ActivitySharedPrefsBinding
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey
import androidx.security.crypto.MasterKeys

class SharedPrefsActivity : AppCompatActivity() {

    companion object {
        const val SHARED_PREFS = "public_prefs"
        const val ENCRYPTED_SHARED_PREFS = "encrypted_shared_prefs"
        const val SHARED_PREFS_KEY = "shared_prefs_key"
        const val FILE_NAME = "file_homework5"
    }

    private lateinit var binding: ActivitySharedPrefsBinding

    private lateinit var securedSharedPrefs: SharedPreferences
    private lateinit var sharedPrefs: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySharedPrefsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initSharedPrefs()
        initUI()
    }

    private fun initSharedPrefs() {
        sharedPrefs = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE)

        val masterKey: MasterKey = MasterKey(this, "master_key")

        securedSharedPrefs = EncryptedSharedPreferences.create(
            this,
            FILE_NAME,
            masterKey,
            EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
            EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
        )
    }

    private fun initUI() {
        binding.saveSharedPrefs.setOnClickListener {
            saveEncryptedSharedPrefs()
        }

        binding.readSharedPrefs.setOnClickListener {
            readEncryptedSharedPrefs()
        }

        binding.deleteInt.setOnClickListener {
            deleteSharedInt()
        }
    }

    private fun saveEncryptedSharedPrefs() {
        sharedPrefs.edit()
            .putString(SHARED_PREFS_KEY, binding.sharedPrefsInput.text.toString())
            .putFloat(SHARED_PREFS_KEY + "_float", 2.03f)
            .putInt(SHARED_PREFS_KEY + "_int", 45)
            .apply()

        securedSharedPrefs.edit()
            .putString(SHARED_PREFS_KEY, binding.sharedPrefsInput.text.toString())
            .apply()
    }

    private fun deleteSharedInt() {
        sharedPrefs.edit()
            .remove(SHARED_PREFS_KEY + "_int")
            .apply()
    }

    private fun readEncryptedSharedPrefs() {
        var sharedPrefsString: String = "SharedPrefsContent: ${sharedPrefs.getString(SHARED_PREFS_KEY, "")}" +
                "\n" + "SharedPrefsFloat: ${sharedPrefs.getFloat(SHARED_PREFS_KEY + "_float", 0f)}" + "\n" +
                "SharedPrefsInt: ${sharedPrefs.getInt(SHARED_PREFS_KEY + "_int", 0)}"
        binding.sharedPrefContent.text = sharedPrefsString
        binding.sharedPrefEncryptedContent.text = "SharedPrefsEncryptesContent: ${securedSharedPrefs.getString(SHARED_PREFS_KEY, "")}"
    }
}