package com.example.lab_week_03

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

interface CoffeeListener {
    fun onSelected(id: Int)
    fun onBackFromDetail()
}

class MainActivity : AppCompatActivity(), CoffeeListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    private fun showDetail() {
        findViewById<View>(R.id.fragment_detail).visibility = View.VISIBLE
        findViewById<View>(R.id.divider).visibility = View.VISIBLE
    }
    private fun showListOnly() {
        findViewById<View>(R.id.fragment_detail).visibility = View.GONE
        findViewById<View>(R.id.divider).visibility = View.GONE
    }
    override fun onSelected(id: Int) {
        val detailFragment =
                supportFragmentManager.findFragmentById(R.id.fragment_detail) as DetailFragment
        showDetail()
        detailFragment.setCoffeeData(id)
    }
    override fun onBackFromDetail() {
        showListOnly()
    }
}
