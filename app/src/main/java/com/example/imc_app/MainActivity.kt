package com.example.imc_app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doOnTextChanged
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setListeners()
    }

    private fun setListeners() {
        alturaEDT.doOnTextChanged { text, _, _, _ ->
            titleTXT?.text = text
        }
        pesoEDT.doOnTextChanged { text, _, _, _ ->
            titleTXT?.text = text
        }
        calcularBTN?.setOnClickListener {
            calcularIMC(pesoEDT.text.toString(), alturaEDT.text.toString())
        }
    }

    private fun calcularIMC(peso: String, altura: String) {
        val peso = peso.toFloatOrNull()
        val altura = altura.toFloatOrNull()

        if (peso != null && altura != null) {
            val imc = peso / (altura * altura)
            when{
                imc < 18.5f -> {
                    titleTXT.text = getString(R.string.abaixo).format(imc)}
                imc in 18.5f..24.9f -> {
                    titleTXT.text = getString(R.string.peso_normal).format(imc)}
                imc in 25.0f..29.99f -> {
                    titleTXT.text = getString(R.string.sobrepeso).format(imc)}
                imc in 30.0f..34.9f -> {
                    titleTXT.text = getString(R.string.obesidade_1).format(imc)}
                imc in 35.0f..40f -> {
                    titleTXT.text = getString(R.string.obesidade_1).format(imc)}
                imc > 40f -> {
                    titleTXT.text = getString(R.string.obesidade_3).format(imc)}
                }

                }
            }
        }