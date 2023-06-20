package com.example.tarea02

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.startActivity

class MainActivity : AppCompatActivity() {

    private lateinit var login: Login

    override fun onCreate(savedInstanceState: Bundle?) {
        // Interface de abertura de la aplicación
        Thread.sleep(2000)
        setTheme(R.style.Theme_Tarea02)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        login = Login(this)

        val btn1: Button = findViewById(R.id.button)
        val btn2: Button = findViewById(R.id.buttonSignUp)

        setOnClickListener(btn1, MainActivity3::class.java)
        setOnClickListener(btn2, MainActivity4::class.java)

        val editTextCorreo = findViewById<EditText>(R.id.editTextTextPersonName)
        val editTextContraseña = findViewById<EditText>(R.id.editTextTextPassword)

        btn1.setOnClickListener {
            val correo = editTextCorreo.text.toString()
            val contraseña = editTextContraseña.text.toString()

            val sesionExitosa = login.iniciarSesion(correo, contraseña)

            if (sesionExitosa) {
                // La sesión se inició correctamente
                Toast.makeText(this, "Inicio de sesión exitoso", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, MainActivity3::class.java)
                startActivity(intent)
            } else {
                // La sesión no se inició correctamente
                Toast.makeText(this, "Datos incorrectos", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun setOnClickListener(button: Button, activity: Class<*>) {
        button.setOnClickListener {
            val intent = Intent(this, activity)
            startActivity(intent)
        }
    }
}
