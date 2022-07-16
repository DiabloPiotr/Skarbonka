package com.example.skarbonka

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.skarbonka.databinding.ActivityDodawanieSkarbonkiBinding

class dodawanieSkarbonki : AppCompatActivity() {
    private lateinit var binding: ActivityDodawanieSkarbonkiBinding
    private lateinit var connectionToMainActivity: MainActivity
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDodawanieSkarbonkiBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.przyciskWroc.setOnClickListener{
            finish()
        }

        binding.przyciskDodaj.setOnClickListener {
            var nazwa = binding.inputNazwa.text.toString()
            var cel = binding.InputCel.text.toString()
            var poczatek = binding.inputPoczatkowaWartosc.text.toString()
            var ile = binding.inputIle.text.toString()
            if (nazwa.isEmpty()){
                nazwa = "Bezcelowa Skarbonka"
            }
            if (poczatek.isEmpty()){
                poczatek = "0"
            }
            if (ile.isEmpty()){
               ile = "5"
            }
            if (cel.isEmpty()){
                Toast.makeText(this, "Skarbonka nie może być bezcelowa", Toast.LENGTH_SHORT).show()
            } else {
            }
            connectionToMainActivity.skarbonkaAdapter.nowaSkarbonka("asd", 344, 2, 2)
        }
    }
}