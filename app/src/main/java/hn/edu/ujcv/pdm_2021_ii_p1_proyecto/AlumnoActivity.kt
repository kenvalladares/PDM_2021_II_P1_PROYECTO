package hn.edu.ujcv.pdm_2021_ii_p1_proyecto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_alumno.*
import kotlinx.android.synthetic.main.activity_libro.*

class AlumnoActivity : AppCompatActivity() {
    val valores: HashMap<Int,String> = hashMapOf()
    var numero2 = 0
    val dato = StringBuilder()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alumno)
        btnGuardarA.setOnClickListener { guardar() }
        btnAtrasA.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            intent.putExtra("valores2",valores)
            startActivity(intent)
            onBackPressed()
        }
    }
    private fun guardar() {
        if (txtNumeroCuenta.text.toString().isEmpty() || txtAlumno.text.toString().isEmpty()|| txtCarrera.text.toString().isEmpty()|| txtFechaIngreso.text.toString().isEmpty()||txtCorreo.text.toString().isEmpty()){
            Toast.makeText(this,"Debe Rellenar todos los espacios", Toast.LENGTH_SHORT).show()
        }else{
            dato.append(txtNumeroCuenta.text.toString()).append("|")
            dato.append(txtAlumno.text.toString().trim()).append("|")
            dato.append(txtCarrera.text.toString().trim()).append("|")
            dato.append(txtFechaIngreso.text.toString().trim()).append("|")
            dato.append(txtCorreo.text.toString().trim())
            valores.put(txtNumeroCuenta.text.toString().toInt(),dato.toString())

            Toast.makeText(this,"Alumno Añadido Exitosamente", Toast.LENGTH_SHORT).show()

        }

    }

}