package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)

        // Declaro evento de escucha
        rollButton.setOnClickListener { rollDice() }

        // HAgo que se ejecute al iniciar aplicación
        rollDice()
    }

    // Implementación de método usando imagenes importadas como recursos
    private fun rollDice() {
        // Creo instancia de la clase y le asigno 6 lados
        val dice1 = Dice(6)

        // Llamo al método roll de mi clase intanciada y asigno resultado a una variable
        val diceRoll = dice1.roll()

        // Asigno referencia del imageView de resultado a la variable diceImage
        val diceImage: ImageView = findViewById(R.id.imageView)

        // Asigno el recurso a la propiedad del imageView según el valor que obtenga
        // Forma NORMAL
        when (diceRoll){
            // R.drawable.  contiene todos los recursos importados como drawables
            1 -> diceImage.setImageResource(R.drawable.dice_1)
            2 -> diceImage.setImageResource(R.drawable.dice_2)
            3 -> diceImage.setImageResource(R.drawable.dice_3)
            4 -> diceImage.setImageResource(R.drawable.dice_4)
            5 -> diceImage.setImageResource(R.drawable.dice_5)
            6 -> diceImage.setImageResource(R.drawable.dice_6)
        }

        // Forma COMPACTA
        // Asigno el recurso a la variable drawableResource segun el resultado
        val drawableResource = when (diceRoll){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        // Asigno drawableResource como recurso del imageView
        diceImage.setImageResource(drawableResource)

        // Asigno resultado obtenido a atributo contentDescription del imageView
        // para que pueda ser leido por los lectores de pantalla
        diceImage.contentDescription = diceRoll.toString()
    }
}

// Creo clase Dice con un argumento numSides de tipo ENTERO
// numSides es privada porque sólo se accede a ella a través de clase Dice
class Dice(private val numSides: Int) {

    // Creo función roll con un retorno de tipo ENTERO
    fun roll(): Int {

        // Retorno número aleatorio dentro del rango de 1 a NUMERO DE LADOS [numSides]
        return (1..numSides).random()
    }
}