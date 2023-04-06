package com.example.prova

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val rollButton: Button = findViewById(R.id.verificar)
        rollButton.setOnClickListener{
            val toast = Toast.makeText(this, "Verificado!", Toast.LENGTH_SHORT).show()

            rollButton.setOnClickListener {
                verifica()
            }
        }



    }

    private fun verifica(){
        val botaoverificar = findViewById<Button>(R.id.verificar)
        val respostausuario = findViewById<EditText>(R.id.TextoUsuario)
        val mensagemaousuario = findViewById<TextView>(R.id.Resposta)
        val tiposanguineo = respostausuario.text.toString()


        val tiposang = respostausuario.text.toString()
        val mensagemapp = when (tiposang.toUpperCase()) {
            "A+" -> "Você pode doar para: A+, AB+ \nVocê pode receber de: A+, A-, O+, O-"
            "A-" -> "Você pode doar para: A+, A-, AB+, AB- \nVocê pode receber de: A-, O-"
            "B+" -> "Você pode doar para: B+, AB+ \nVocê pode receber de: B+, B-, O+, O-"
            "B-" -> "Você pode doar para: B+, B-, AB+, AB- \nVocê pode receber de: B-, O-"
            "AB+" -> "Você pode doar para: AB+ \nVocê pode receber de: A+, A-, B+, B-, AB+, AB-, O+, O-"
            "AB-" -> "Você pode doar para: AB+, AB- \nVocê pode receber de: A-, B-, AB-, O-"
            "O+" -> "Você pode doar para: A+, B+, AB+, O+ \nVocê pode receber de: O+, O-"
            "O-" -> "Você pode doar para: A+, A-, B+, B-, AB+, AB-, O+, O- \nVocê pode receber de: O-"
            else -> "Tipo sanguíneo inválido"
        }
        mensagemaousuario.text = mensagemapp

        val respostasangue: ImageView = findViewById<ImageView>(R.id.imgsangue)
        val drawableResource = when (tiposang.toUpperCase()) {
            "A+" -> R.drawable.amais
            "A-" -> R.drawable.amenos
            "B+" -> R.drawable.bmenos
            "B-" -> R.drawable.bmenos
            "AB+" -> R.drawable.abmais
            "AB-" -> R.drawable.abmenos
            "O+" -> R.drawable.omais
            "O-" -> R.drawable.omenos
            else -> R.drawable.sangue
        }
        respostasangue.setImageResource(drawableResource)
    }
}