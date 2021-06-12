package hn.edu.ujcv.pdm_2021_ii_p1_proyecto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_visualizar_alumno.*
import kotlinx.android.synthetic.main.activity_visualizar_libro.*

class VisualizarAlumnoActivity : AppCompatActivity() {
    var valores: HashMap<Int, String> = hashMapOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_visualizar_alumno)
        btnBuscarA.setOnClickListener { buscara(txtNumeroCuentab.text.toString().toInt()) }
    }
    private fun buscara(NumeroCuentabuscar:Int) {
        var intent = intent
        valores = intent.getSerializableExtra("valores2") as HashMap<Int, String>
        var alumno:Alumno = Alumno()

        if (NumeroCuentabuscar.toString().isEmpty()){
            Toast.makeText(this,"No hay registros con ese numero", Toast.LENGTH_SHORT).show()

        }else{
            for (valor in valores){
                val lista = valor.toString().split("|").toTypedArray()
                if (valores.containsKey(NumeroCuentabuscar.toString().toInt())){
                    alumno.NumeroCuenta    = lista[0].toString()
                    alumno.Alumno         = lista[1]
                    alumno.Carrera         = lista[2]
                    alumno.FechaIngreso    = lista[3].toString()
                    alumno.Correo          = lista[4]
                }else{
                    Toast.makeText(this,"No hay registros con ese numero", Toast.LENGTH_SHORT).show()
                }
            }

        }
        txvNumeroCuentab.setText("Numero de cuenta: "+alumno.NumeroCuenta.toString())
        txvNombreb.setText("Alumno: "+alumno.Alumno.toString())
        txvCarrerab.setText("Carrera:" +alumno.Carrera.toString())
        txvFechaIngresob.setText("Fecha de Ingreso: "+alumno.FechaIngreso.toString())
        txvCorreob.setText("Correo :"+alumno.Correo.toString())
    }

}
