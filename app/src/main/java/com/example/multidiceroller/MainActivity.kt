package com.example.multidiceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rollDice()

        val rollButton: Button= findViewById(R.id.button)
        rollButton.setOnClickListener {
            rollDice()
            val toast= Toast.makeText(this, "2 Dice Rolled!!!", Toast.LENGTH_SHORT).show()
        }
    }

    private fun rollDice() {
        val dice= Dice(6)
        val dice2= Dice(6)

        val rolledValue=dice.roll()
        val rolledValue2=dice2.roll()
        val resultText: TextView = findViewById(R.id.textView)
        val resultImage: ImageView = findViewById(R.id.imageView)
        val resultText2: TextView = findViewById(R.id.textView2)
        val resultImage2: ImageView = findViewById(R.id.imageView2)
        resultText.text = rolledValue.toString()
        resultText2.text = rolledValue2.toString()

        resultImage.setImageResource(diceImgChange(rolledValue))
        resultImage2.setImageResource(diceImgChange(rolledValue2))
        resultImage.contentDescription = rolledValue.toString()
        resultImage2.contentDescription = rolledValue2.toString()
    }

    private fun diceImgChange(Value: Int) = when(Value){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
}

class Dice(private val sides: Int)
{
    fun roll(): Int = (1..sides).random()
}