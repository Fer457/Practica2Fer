package com.example.practica2fer

import androidx.appcompat.app.AppCompatActivity
import com.example.practica2fer.databinding.ActivityMainBinding
import android.os.Bundle
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        }
    }