package com.example.eva02

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class noperecederos : AppCompatActivity() {

    private val sharedP = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_noperecederos)

        val codigoNP = findViewById<EditText>(R.id.etxtCodigoNP)
        val descripcionNP = findViewById<EditText>(R.id.etxtDescripcionNP)
        val tipoNP = findViewById<EditText>(R.id.etxtTipoNP)

        val crearNP = findViewById<Button>(R.id.btnCrearNP)
        val consultarNP = findViewById<Button>(R.id.btnConsultarNP)

        val sp = getSharedPreferences(sharedP, Context.MODE_PRIVATE)

        codigoNP.setText(intent.extras?.getString("CODIGOX", ""))
        descripcionNP.setText(intent.extras?.getString("DESCRIPCIONX", ""))

        crearNP.setOnClickListener {
            if (codigoNP.text.isNotEmpty() and descripcionNP.text.isNotEmpty() and tipoNP.text.isNotEmpty()) {

                val editor = sp.edit()
                editor.putString(codigoNP.text.toString() + "descripcionN", descripcionNP.text.toString())
                editor.putString(codigoNP.text.toString() + "tipoN", tipoNP.text.toString())

                editor.apply()
                Toast.makeText(this, "Datos guardados", Toast.LENGTH_LONG).show()
                codigoNP.setText("")
                descripcionNP.setText("")
                tipoNP.setText("")
            }

            else{Toast.makeText(this, "Rellene los campos", Toast.LENGTH_LONG).show()}
        }
        consultarNP.setOnClickListener {
            val desN = sp.getString(codigoNP.text.toString() + "descripcionN", "")
            val tipoN = sp.getString(codigoNP.text.toString() + "tipoN", "")

            if (desN!!.isNotEmpty() and tipoN!!.isNotEmpty()) {
                descripcionNP.setText(desN)
                tipoNP.setText(tipoN)

            }
            else if (codigoNP.text.isEmpty()){
                Toast.makeText(this, "Ingrese el código del producto", Toast.LENGTH_LONG).show()
            }
            else if (desN.isEmpty() and tipoN.isEmpty()){
                Toast.makeText(this,"Código no reconocido", Toast.LENGTH_LONG).show()
            }
            else{Toast.makeText(this, "Hubo un error", Toast.LENGTH_SHORT).show()}
        }


    }
}