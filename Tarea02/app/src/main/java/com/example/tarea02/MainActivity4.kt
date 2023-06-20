package com.example.tarea02

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity4 : AppCompatActivity() {

    private lateinit var daoUsuario: daoUsuario


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)
        daoUsuario = daoUsuario(this)

        val btnRegister = findViewById<Button>(R.id.button2)
        btnRegister.setOnClickListener {
            // Obtén los datos del formulario de registro (editTexts)
            val nombre = findViewById<EditText>(R.id.editTextTextPersonName6).text.toString()
            val correo = findViewById<EditText>(R.id.editTextTextPersonName9).text.toString()
            val direccion = findViewById<EditText>(R.id.editTextTextPersonName10).text.toString()
            val contraseña = findViewById<EditText>(R.id.editTextTextPersonName20).text.toString()

            val telefono: Int
            val cp: Int
            val noExt: Int
            val tarjeta: Int
            val cvv: Int
            val vencimiento: Int

            try {
                telefono = findViewById<EditText>(R.id.editTextTextPersonName8).text.toString().toInt()
                cp = findViewById<EditText>(R.id.editTextTextPersonName12).text.toString().toInt()
                noExt = findViewById<EditText>(R.id.editTextTextPersonName13).text.toString().toInt()
                tarjeta = findViewById<EditText>(R.id.editTextTextPersonName15).text.toString().toInt()
                cvv = findViewById<EditText>(R.id.editTextTextPersonName19).text.toString().toInt()
                vencimiento = findViewById<EditText>(R.id.editTextTextPersonName17).text.toString().toInt()
            } catch (e: NumberFormatException) {
                // Error en la conversión de enteros
                Toast.makeText(this, "Registro fallido", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Crea un objeto Usuario con los datos ingresados
            val usuario = Usuario(nombre, correo, direccion, contraseña, cp, telefono, noExt, tarjeta, cvv, vencimiento)

            // Llama al método insertUsuario del objeto daoUsuario
            val registroFallido = daoUsuario.insertUsuario(usuario)

            if (registroFallido) {
                //Si registroFallido es true, entonces no se realizo el registro
                // Registro fallido
                Toast.makeText(this, "Registro fallido", Toast.LENGTH_SHORT).show()
            } else {
                //Si registroFallido es false, entonces tuvo exito el registro
                // Registro exitoso
                Toast.makeText(this, "Registro exitoso", Toast.LENGTH_SHORT).show()
                // Redirige al usuario a ActivityMain2 y borra la pila de actividades
                val intent = Intent(this, MainActivity3::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
                startActivity(intent)

            }
        }
    }




}