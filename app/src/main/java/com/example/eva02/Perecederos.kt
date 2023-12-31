package com.example.eva02

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class Perecederos : AppCompatActivity() {

    private val sharedP = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perecederos)

        val codigoP = findViewById<EditText>(R.id.etxtCodigoP)
        val descripcionP = findViewById<EditText>(R.id.etxtDescripcionP)
        val precioP = findViewById<EditText>(R.id.etxtPrecioP)
        val diasVP = findViewById<EditText>(R.id.etxtDíasP)
        val nuevoValorP = findViewById<EditText>(R.id.etxtNuevovalorP)

        val calcularNV = findViewById<Button>(R.id.btnCalcularNuevovalorP)
        val crearP = findViewById<Button>(R.id.btnCrearP)
        val consultarP = findViewById<Button>(R.id.btnConsultarP)

        codigoP.setText(intent.extras?.getString("CODIGOX", ""))
        descripcionP.setText(intent.extras?.getString("DESCRIPCIONX", ""))
        precioP.setText(intent.extras?.getString("PRECIOX", ""))

        val sp = getSharedPreferences(sharedP, Context.MODE_PRIVATE)

        crearP.setOnClickListener {
            if (codigoP.text.isNotEmpty() and descripcionP.text.isNotEmpty() and precioP.text.isNotEmpty() and diasVP.text.isNotEmpty() and nuevoValorP.text.isEmpty()){
                Toast.makeText(this, "Calcule el nuevo valor antes de continuar", Toast.LENGTH_SHORT).show()
            }
            else if (codigoP.text.isNotEmpty() and descripcionP.text.isNotEmpty() and precioP.text.isNotEmpty() and diasVP.text.isNotEmpty() and nuevoValorP.text.isNotEmpty()) {

                val editor = sp.edit()
                editor.putString(codigoP.text.toString() + "precio", precioP.text.toString())
                editor.putString(codigoP.text.toString() + "descripcion", descripcionP.text.toString())
                editor.putString(codigoP.text.toString() + "diasV", diasVP.text.toString())
                editor.putString(codigoP.text.toString() + "nuevoVP", nuevoValorP.text.toString())

                editor.apply()
                Toast.makeText(this, "Datos guardados", Toast.LENGTH_SHORT).show()
                codigoP.setText("")
                descripcionP.setText("")
                precioP.setText("")
                diasVP.setText("")
                nuevoValorP.setText("")
            }
            else{ Toast.makeText(this, "Rellene todos los campos", Toast.LENGTH_LONG).show()
            }

        }

        calcularNV.setOnClickListener {
            if (diasVP.text.toString()=="3"){
                nuevoValorP.setText((precioP.text.toString().toDouble()/2.0).toString())}
            else if (diasVP.text.toString()=="2"){
                nuevoValorP.setText((precioP.text.toString().toDouble()/3.0).toString())}
            else if (diasVP.text.toString()=="1"){
                nuevoValorP.setText((precioP.text.toString().toDouble()/4.0).toString())}
            else if (diasVP.text.isEmpty()){
                Toast.makeText(this, "Primero ingrese los días de vencimiento" , Toast.LENGTH_SHORT).show()}
            else {nuevoValorP.setText((precioP.text.toString()))}
        }

        consultarP.setOnClickListener {
            val prec = sp.getString(codigoP.text.toString() + "precio","")
            val des = sp.getString(codigoP.text.toString() + "descripcion","")
            val dias = sp.getString(codigoP.text.toString() + "diasV","")
            val nuevV = sp.getString(codigoP.text.toString()+"nuevoVP", "")

            if (des!!.isNotEmpty() and prec!!.isNotEmpty() and dias!!.isNotEmpty() and nuevV!!.isNotEmpty()){
                descripcionP.setText(des)
                precioP.setText(prec)
                diasVP.setText(dias)
                nuevoValorP.setText(nuevV)
            }
            else if (codigoP.text.isEmpty()){
                Toast.makeText(this,"Ingrese un código", Toast.LENGTH_LONG).show()
            }
            else if (prec.isEmpty() and des.isEmpty() and dias.isEmpty() and nuevV.isEmpty()){
                Toast.makeText(this,"Código no reconocido", Toast.LENGTH_LONG).show()
            }
            else{Toast.makeText(this, "Hubo un error", Toast.LENGTH_SHORT).show()}
        }

    }




}
