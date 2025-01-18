package com.example.selectpartition

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.selectpartition.databinding.ActivityMainBinding
import com.example.selectpartition.presentation.fragment.ProductSectionFragment

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding
        get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportFragmentManager.beginTransaction()
            .replace(R.id.main_container, ProductSectionFragment())
            .addToBackStack(null)
            .commit()

    }
}