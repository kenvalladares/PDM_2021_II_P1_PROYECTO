package hn.edu.ujcv.pdm_2021_ii_p1_proyecto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_visualizar_alumno.*
import kotlinx.android.synthetic.main.activity_visualizar_prestamo_libro.*

class VisualizarPrestamoLibroActivity : AppCompatActivity() {
    var valores: HashMap<Int, String> = hashMapOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_visualizar_prestamo_libro)
        btnBuscarP.setOnClickListener { buscarp(txtNumeroPrestamoBu.text.toString().toInt()) }
    }
    private fun buscarp(NumeroPrestamobuscar:Int) {
        var intent = intent
        valores = intent.getSerializableExtra("valores3") as HashMap<Int, String>
        var prestamolibro: PrestamoLibro = PrestamoLibro()
        if (NumeroPrestamobuscar.toString().isEmpty()){
            Toast.makeText(this,"No hay registros con ese numero", Toast.LENGTH_SHORT).show()

        }else{
            for (valor in valores){
                val lista = valor.toString().split("|").toTypedArray()
                if (valores.containsKey(NumeroPrestamobuscar.toString().toInt())){
                    prestamolibro.NumeroPrestamo    = lista[0].toString()
                    prestamolibro.FechaPrestamo     = lista[1]
                    prestamolibro.NumeroCuentap     = lista[2]
                    prestamolibro.NumeroLibroP      = lista[3].toString()
                    prestamolibro.FechaDevolucion   = lista[4]
                }else{
                    Toast.makeText(this,"No hay registros con ese numero", Toast.LENGTH_SHORT).show()
                }
            }

        }
        txvNumeroPrestamoB.setText("Numero de Prestamo: "+prestamolibro.NumeroPrestamo.toString())
        txvFechaPrestamoB.setText("Fecha de Prestamo: "+prestamolibro.FechaPrestamo.toString())
        txvNumeroCuentaPB.setText("Numero de Cuenta:" +prestamolibro.NumeroCuentap.toString())
        txvNumeroLibroPB.setText("Numero de Libro: "+prestamolibro.NumeroLibroP.toString())
        txvFechaDevolucionPB.setText("Fecha de Devolucion :"+prestamolibro.FechaDevolucion.toString())
    }
}