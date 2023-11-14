package com.example.eva02

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Switch
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val codigoX = findViewById<EditText>(R.id.txtCodigo)
        val descripcionX = findViewById<EditText>(R.id.txtDescripcion)
        val precioX = findViewById<EditText>(R.id.txtPrecio)
        val swX = findViewById<Switch>(R.id.swP)
        val crearX = findViewById<Button>(R.id.btnCrear)

        crearX.setOnClickListener {
            if (codigoX.text.isNotEmpty() and descripcionX.text.isNotEmpty() and precioX.text.isNotEmpty() and swX.isChecked) {
                val intentMainP = Intent(this, Perecederos::class.java)
                intentMainP.putExtra("CODIGOX", codigoX.text.toString())
                intentMainP.putExtra("DESCRIPCIONX", descripcionX.text.toString())
                intentMainP.putExtra("PRECIOX", precioX.text.toString())
                startActivity(intentMainP)
            }
            else if (codigoX.text.isNotEmpty() and descripcionX.text.isNotEmpty() and precioX.text.isNotEmpty()){
                val intentMainNP = Intent(this, noperecederos::class.java)
                intentMainNP.putExtra("CODIGOX", codigoX.text.toString())
                intentMainNP.putExtra("DESCRIPCIONX", descripcionX.text.toString())
                intentMainNP.putExtra("PRECIOX", precioX.text.toString())
                startActivity(intentMainNP)
            }
            else{Toast.makeText(this,"Rellene los campos", Toast.LENGTH_LONG).show()
                }
        }
    }
}