package com.has.prova

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import java.text.SimpleDateFormat
import java.util.*
import android.widget.ImageView
import com.has.prova.R
import kotlin.math.sign

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dateEditText = findViewById<EditText>(R.id.dateEditText)
        val calculateButton = findViewById<Button>(R.id.calculateButton)

        calculateButton.setOnClickListener {
            val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
            val date = dateEditText.text.toString()

            try {
                val birthDate = dateFormat.parse(date)
                val sign = getZodiacSign(birthDate)
                val toastMessage = "Seu signo é $sign"

                Toast.makeText(this, toastMessage, Toast.LENGTH_SHORT).show()
            } catch (e: Exception) {
                val toastMessage = "Data inválida"
                Toast.makeText(this, toastMessage, Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun getZodiacSign(birthDate: Date) {
        val calendar = Calendar.getInstance()
        calendar.time = birthDate
        val month = calendar.get(Calendar.MONTH) + 1
        val day = calendar.get(Calendar.DAY_OF_MONTH)
        val zodiacosImage: ImageView = findViewById(R.id.imageView)
        zodiacosImage.contentDescription = zodiacosImage.toString()
        val drawableResource = when (month) {
            1 -> if (day < 20)  R.drawable.capricornio else R.drawable.aquario
            2 -> if (day < 19) R.drawable.aquario else R.drawable.peixes
            3 -> if (day < 21) R.drawable.peixes else R.drawable.aries
            4 -> if (day < 20) R.drawable.aries else R.drawable.touro
            5 -> if (day < 21) R.drawable.touro else R.drawable.gemeos
            6 -> if (day < 21) R.drawable.gemeos else R.drawable.cancer
            7 -> if (day < 23) R.drawable.cancer else R.drawable.leao
            8 -> if (day < 23) R.drawable.leao else R.drawable.virgem
            9 -> if (day < 23) R.drawable.virgem else R.drawable.libra
            10 -> if (day < 23) R.drawable.libra else R.drawable.escorpiao
            11 -> if (day < 22) R.drawable.escorpiao else R.drawable.sagitario
            else -> if (day < 22) R.drawable.sagitario else R.drawable.capricornio
        }
        zodiacosImage.setImageResource(drawableResource)
    }
}




