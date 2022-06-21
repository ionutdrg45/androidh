package com.example.homework7

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.homework7.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.fragment.app.commit

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        if (savedInstanceState == null) {
            val fragment = SearchFragment()
            replaceFragment(fragment, "fragment_search")
        }

        setupDrawerContent(binding.bottomNavigation)
    }

    private fun setupDrawerContent(navigationView: BottomNavigationView) {
        navigationView.setOnItemSelectedListener {
            var fragment: Fragment? = null
            when (it.itemId) {
                R.id.search -> fragment = SearchFragment()
                R.id.my_artists -> fragment = MyArtistsFragment()
                R.id.my_albums -> fragment = MyAlbumsFragment()
            }
            fragment?.let {
                if (supportFragmentManager.findFragmentByTag("fragment_container") != null) {
                    supportFragmentManager.popBackStack()
                }
                replaceFragment(fragment, "fragment_container")
            }
            it.isChecked = true
            true
        }
    }
    private fun replaceFragment(fragment: Fragment, tag: String) {
        supportFragmentManager.commit {
            setReorderingAllowed(true)
            setCustomAnimations(R.anim.slide_in_right, R.anim.fade_out, R.anim.fade_in, R.anim.slide_out_right)
            replace(R.id.fragment_container, fragment, tag)
            addToBackStack(tag)
        }
    }

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount == 1) {
            finish()
        } else {
            supportFragmentManager.popBackStack()
        }
    }
}