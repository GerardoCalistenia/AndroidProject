package com.example.tarea02

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class Pagar : AppCompatActivity() {

    private lateinit var editTextNumber1: EditText
    private lateinit var editTextNumber2: EditText
    private lateinit var editTextNumber3: EditText

    private var noTarjeta: Int? = null
    private var fecha: Int? = null
    private var cvv: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pagar)

        editTextNumber1 = findViewById(R.id.pago_no_tarjeta)
        editTextNumber2 = findViewById(R.id.pago_fecha)
        editTextNumber3 = findViewById(R.id.pago_cvv)

        editTextNumber1.addTextChangedListener(textWatcher)
        editTextNumber2.addTextChangedListener(textWatcher)
        editTextNumber3.addTextChangedListener(textWatcher)

        val pagar: Button = findViewById(R.id.pagar)
        pagar.setOnClickListener {
            pagoSeguro()
        }
    }

    private val textWatcher = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            val number = s.toString().toIntOrNull()
            if (number != null) {
                when {
                    s.hashCode() == editTextNumber1.text.hashCode() -> {
                        noTarjeta = number
                    }
                    s.hashCode() == editTextNumber2.text.hashCode() -> {
                        fecha = number
                    }
                    s.hashCode() == editTextNumber3.text.hashCode() -> {
                        cvv = number
                    }
                }
            }
        }
        override fun afterTextChanged(s: Editable?) {}
    }

    private fun pagoSeguro() {
        /**val usuario = Usuario.getInstance()

        if (usuario != null) {
            Log.d("NOMBRE PAGO", usuario.nombre ?: "")
            Log.d("CORREO PAGO", usuario.correo ?: "")
            Log.d("CONTRASENNA PAGO", usuario.contraseña ?: "")
            Log.d("CVV PAGO", usuario.CVV.toString())
            Log.d("NO TARJETA PAGO", usuario.tarjeta.toString())
            Log.d("FECHA VENCIMIENTO PAGO", usuario.vencimiento.toString())
        }

        Log.d("NO TARJETA PAGO---------", noTarjeta?.toString() ?: "")
        Log.d("FECHA VENCIMIENTO PAGO--------", fecha?.toString() ?: "")
        Log.d("CVV PAGO---------", cvv?.toString() ?: "")

        if (noTarjeta != null && fecha != null && cvv != null) {
            if (usuario != null && noTarjeta == usuario.tarjeta && fecha == usuario.vencimiento && cvv == usuario.CVV) {
                Toast.makeText(this, "Informacion Correcta", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Datos Incorrectos, verifica tu información.", Toast.LENGTH_SHORT).show()
            }
        } else {
            Toast.makeText(this, "Rellena los datos para proceder al pago.", Toast.LENGTH_SHORT).show()
        }*/
    }







}