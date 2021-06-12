package hn.edu.ujcv.pdm_2021_ii_p1_proyecto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_alumno.*
import kotlinx.android.synthetic.main.activity_libro.*

class LibroActivity : AppCompatActivity() {
    val valores: HashMap<Int,String> = hashMapOf()
    var numero = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_libro)
        iniciarlizar()
        btnGuardar.setOnClickListener { guardar() }
        btnAtras.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            intent.putExtra("valores",valores)
            startActivity(intent)
            onBackPressed()
        }


    }
    private fun guardar() {
        val dato = StringBuilder()

        if (txtNombre.text.toString().isEmpty() || txtNumeroLibro.text.toString().isEmpty()|| txtAutor.text.toString().isEmpty()|| txtFechaPublicacion.text.toString().isEmpty()||txtEditorial.text.toString().isEmpty()){
            Toast.makeText(this,"Debe Rellenar todos los espacios", Toast.LENGTH_SHORT).show()
        }else{
            numero= txtNumeroLibro.text.toString().toInt()
            dato.append(txtNumeroLibro.text.toString()).append("|")
            dato.append(txtNombre.text.toString().trim()).append("|")
            dato.append(txtAutor.text.toString().trim()).append("|")
            dato.append(txtFechaPublicacion.text.toString().trim()).append("|")
            dato.append(txtEditorial.text.toString().trim())
            valores.put(numero,dato.toString())
            val intent = Intent(this,MainActivity::class.java)
            intent.putExtra("valores",valores)
            Toast.makeText(this,"Libro Añadido Exitosamente", Toast.LENGTH_SHORT).show()

        }

    }

    private fun iniciarlizar() {
        btnGuardar.isEnabled = true

    }
}