package com.example.lab2_guidopadilla

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
/*
* Guido Padilla 19200 LAB 2 apps
* */
class MainActivity : AppCompatActivity() {

    lateinit var prizeImage: ImageView
    lateinit var button_toast: Button
    lateinit var count_text: TextView
    var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        prizeImage = findViewById(R.id.variety_image)
        button_toast = findViewById(R.id.loop_button)
        count_text = findViewById(R.id.count_text)
        count_text.setText("0")

        /*Al presionar durante un periodod prolongado se despliega el mensaje con las vueltas faltantes para el siguiente objetivo*/
        button_toast.setOnLongClickListener {
            var texto = ""
            texto = "Faltan "
            if (count < 10) {
                texto += Integer.toString(10-count) + " vueltas para terminar el objetivo"
                Toast.makeText(getApplicationContext(), texto, Toast.LENGTH_SHORT).show()
            }
            if (count >= 10) {
                texto += Integer.toString(20-count) + " vueltas para terminar el objetivo"
                Toast.makeText(getApplicationContext(), texto, Toast.LENGTH_SHORT).show()
            }
            true
        }
    }
    /*incrementa el contador de vueltas hasta llegar a su objetivo despliega un toast*/
    fun incrementCount(view: View){
        if(count<20) {
            count += 1
            if (count == 10) {
                Toast.makeText(getApplicationContext(), "Felicitaciones!!", Toast.LENGTH_SHORT)
                    .show()
                prizeImage.setImageResource(R.drawable.congrats_image)
            }
            if (count == 20) {
                Toast.makeText(getApplicationContext(), "Logrado!!", Toast.LENGTH_SHORT).show()
                prizeImage.setImageResource(R.drawable.trophy_image)
            }
            val texto = Integer.toString(count)
            count_text.setText(texto)
        }
    }


    /* reinicia el contador asi como el texto que lo despliega*/
    fun resetCount(view: View){
        count = 0
        count_text.setText("0")
        prizeImage.setImageResource(R.drawable.empty_dice)
    }

    /*fun viewCount(view: View){
        var texto = ""
        texto = "Faltan "
        if (count < 10) {
            texto += Integer.toString(10-count) + " vueltas para terminar"
            Toast.makeText(getApplicationContext(), "Felicitaciones!!", Toast.LENGTH_SHORT).show()
        }
        if (count < 20) {
            texto += Integer.toString(20-count) + " vueltas para terminar"
            Toast.makeText(getApplicationContext(), "Logrado!!", Toast.LENGTH_SHORT).show()
        }
    }*/


}
