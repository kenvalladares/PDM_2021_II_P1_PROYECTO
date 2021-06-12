package hn.edu.ujcv.pdm_2021_ii_p1_proyecto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_libro.*
import kotlinx.android.synthetic.main.activity_visualizar_libro.*

class VisualizarLibroActivity : AppCompatActivity() {
    var valores: HashMap<Int, String> = hashMapOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_visualizar_libro)

        btnBuscar.setOnClickListener { buscar(txtbuscarnumerolibro.text.toString().toInt()) }
    }

    /*private fun inicializar() {
        var intent = intent
        valores = intent.getSerializableExtra("valores") as HashMap<Int, String>
        var Numerolibros = 0
        var Nombre = " "
        var Autor = ""
        var FechaPublicacion = ""
        var Editorial = ""
        for (valor in valores){
            val lista = valor.toString().split("|").toTypedArray()
            Numerolibros = lista[0].toString().toInt()
            Nombre           = lista[1]
            Autor            = lista[2]
            FechaPublicacion = lista[3]
            Editorial        = lista[4]
        }
        txvnumerolibrob.setText(Numerolibros.toString())
        txvnombreb.setText(Nombre.toString())
        txvnumerolibrob.setText(Numerolibros.toString().toInt())
        txvAutor.setText(Autor.toString())
        t

    }*/

    private fun buscar(Numerolibroabuscar:Int) {
        var intent = intent
        valores = intent.getSerializableExtra("valores") as HashMap<Int, String>
        var libro: Libro = Libro()
        var Numerolibros = ""
        var Nombre = " "
        var Autor = ""
        var FechaPublicacion = " "
        var Editorial = ""
        if (Numerolibroabuscar.toString().isEmpty()){
            Toast.makeText(this,"No hay registros con ese numero", Toast.LENGTH_SHORT).show()

        }else{
        for (valor in valores){
            val lista = valor.toString().split("|").toTypedArray()
            if (valores.containsKey(Numerolibroabuscar.toString().toInt())){
                libro.Numerolibros     = lista[0].toString()
                libro.Nombre           = lista[1]
                libro.Autor            = lista[2]
                libro.FechaPublicacion = lista[3].toString()
                libro.Editorial        = lista[4]
            }else{
                Toast.makeText(this,"No hay registros con ese numero", Toast.LENGTH_SHORT).show()
            }
        }

            //Numerolibros     = lista[0].toString().toInt()
        }
        txvnumerolibrob.setText("Numero de Libro: "+libro.Numerolibros.toString())
        txvnombreb.setText("Nombre: "+libro.Nombre.toString())
        txvautorb.setText("Autor:" +libro.Autor.toString())
        txvfechapublicacionb.setText("Fecha de Publicacion: "+libro.FechaPublicacion.toString())
        txveditorialb.setText("Editorial :"+libro.Editorial.toString())
    }

}