package com.example.tarea02

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class ConfirmarCompra : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confirmar_compra)

        val comprar: Button = findViewById(R.id.compra_exitosa)
        comprar.setOnClickListener {
            //startActivity(Intent(this, Pagar::class.java))
            startActivity(Intent(this, MainActivity3::class.java))
        }
    }
}