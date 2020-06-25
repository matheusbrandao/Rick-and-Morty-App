package com.matheusbrandao.rickandmorty.ui

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.matheusbrandao.rickandmorty.R
import com.matheusbrandao.rickandmorty.ui.utils.setupWithNavController
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val onItemSelectedListener = object :
        OnNavigationItemSelectedListener {
        override fun onNavigationItemSelected(menuItem: MenuItem): Boolean {
            return true
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupBottomNavigationBar()
    }

    private fun setupBottomNavigationBar() {
        val navGraphIds = listOf(R.navigation.home, R.navigation.location, R.navigation.episode)

        bottomNavView_main.setupWithNavController(
            navGraphIds = navGraphIds,
            fragmentManager = supportFragmentManager,
            containerId = R.id.navHost_container,
            intent = intent,
            itemSelectedListener = onItemSelectedListener
        )
    }

    interface OnNavigationItemSelectedListener {
        fun onNavigationItemSelected(menuItem: MenuItem): Boolean
    }
}
