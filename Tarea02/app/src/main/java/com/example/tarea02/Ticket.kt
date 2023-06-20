package com.example.tarea02

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class Ticket : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ticket)

        val pedido = intent.getIntArrayExtra("pedido")
        if (pedido != null && pedido.size >= 3) {
            // Realiza el procesamiento necesario con el arreglo pedido
            ticketToString(pedido)
        }

        val comprar: Button = findViewById(R.id.comprar)
        comprar.setOnClickListener {
            //startActivity(Intent(this, Pagar::class.java))
            startActivity(Intent(this, ConfirmarCompra::class.java))
        }
    }

    fun ticketToString(pedido: IntArray){
        var ticketFinal: String = "\n\n"
        var hamburguesasUno :Int = pedido[0]
        var hamburguesasDos :Int = pedido[1]
        var hamburguesasTres :Int = pedido[2]
        if (hamburguesasUno > 0) {
            ticketFinal += "x" + pedido[0] + "      Pollo       = $ " + (hamburguesasUno * 60) + " MX\n"
        }
        if (hamburguesasDos > 0) {
            ticketFinal += "x" + pedido[1] + "      Maxi        = $ " + (hamburguesasDos * 100) + " MX\n"
        }
        if (hamburguesasTres > 0) {
            ticketFinal += "x" + pedido[2] + "      Tocino      = $ " + (hamburguesasTres * 80) + " MX\n"
        }
        val textView8: TextView = findViewById(R.id.ticket)
        textView8.text = ticketFinal
        val precioTotal: TextView = findViewById(R.id.price_total)
        precioTotal.text = "TOTAL = $ " + ((hamburguesasUno * 60) + (hamburguesasDos * 100) + (hamburguesasTres * 80)) + " MX"
    }
}