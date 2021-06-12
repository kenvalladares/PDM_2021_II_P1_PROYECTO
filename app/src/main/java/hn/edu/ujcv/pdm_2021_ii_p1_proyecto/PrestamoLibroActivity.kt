package hn.edu.ujcv.pdm_2021_ii_p1_proyecto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_libro.*
import kotlinx.android.synthetic.main.activity_prestamo_libro.*

class PrestamoLibroActivity : AppCompatActivity() {
    val valores: HashMap<Int,String> = hashMapOf()
    var numero3 = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_prestamo_libro)
        btnGuardarP.setOnClickListener { guardar() }
        btnAtrasP.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            intent.putExtra("valores3",valores)
            startActivity(intent)
            onBackPressed()
        }
    }
    private fun guardar() {
        val dato = StringBuilder()
        if (txtNumeroPrestamo.text.toString().isEmpty() || txtFechaPrestamo.text.toString().isEmpty()|| txtNumeroCuentaP.text.toString().isEmpty()|| txtNumeroLibroP.text.toString().isEmpty()||txtFechaDevolucion.text.toString().isEmpty()){
            Toast.makeText(this,"Debe Rellenar todos los espacios", Toast.LENGTH_SHORT).show()
        }else{
            numero3= txtNumeroPrestamo.text.toString().toInt()
            dato.append(txtNumeroPrestamo.text.toString()).append("|")
            dato.append(txtFechaPrestamo.text.toString()).append("|")
            dato.append(txtNumeroCuentaP.text.toString()).append("|")
            dato.append(txtNumeroLibroP.text.toString()).append("|")
            dato.append(txtFechaDevolucion.text.toString().trim())
            valores.put(numero3,dato.toString())
            Toast.makeText(this,"Prestamo de Libro Añadido Exitosamente", Toast.LENGTH_SHORT).show()
        }

    }
}