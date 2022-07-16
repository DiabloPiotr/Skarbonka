package com.example.skarbonka

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.skarbonka.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    //activity binding
    private lateinit var binding: ActivityMainBinding
    lateinit var skarbonkaAdapter: SkarbonkaAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        skarbonkaAdapter = SkarbonkaAdapter(mutableListOf())
        binding.rvSkarbonki.adapter = skarbonkaAdapter
        binding.rvSkarbonki.layoutManager = LinearLayoutManager(this)

        binding.przyciskDodawanie.setOnClickListener {
            startActivity(Intent(this, dodawanieSkarbonki::class.java))
        }
    }




}