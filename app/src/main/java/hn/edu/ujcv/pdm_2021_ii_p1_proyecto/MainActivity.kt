package hn.edu.ujcv.pdm_2021_ii_p1_proyecto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var valores: HashMap<Int,String> = hashMapOf()
    var valores2: HashMap<Int,String> = hashMapOf()
    var valores3: HashMap<Int,String> = hashMapOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnlibros.setOnClickListener {
            val intent: Intent = Intent(this,LibroActivity::class.java)
            startActivity(intent)
        }
        btnVisualizarLibro.setOnClickListener {
            var intent = intent
            valores = intent.getSerializableExtra("valores") as HashMap<Int, String>
            intent = Intent(this,VisualizarLibroActivity::class.java)
            intent.putExtra("valores",valores)
            startActivity(intent)
        }
        btnAlumnos.setOnClickListener {
            intent = Intent(this,AlumnoActivity::class.java)
            startActivity(intent) }

        btnvisualizaralumnos.setOnClickListener {
            var intent = intent
            valores2 = intent.getSerializableExtra("valores2") as HashMap<Int, String>
            intent = Intent(this,VisualizarAlumnoActivity::class.java)
            intent.putExtra("valores2",valores2)
            startActivity(intent)
        }
        btnprestamolibro.setOnClickListener {
            val intent = Intent(this,PrestamoLibroActivity::class.java)
            startActivity(intent) }
        btnvisualizarprestamolibro.setOnClickListener {
            var intent = intent
            valores3 = intent.getSerializableExtra("valores3") as HashMap<Int, String>
            intent = Intent(this,VisualizarPrestamoLibroActivity::class.java)
            intent.putExtra("valores3",valores3)
            startActivity(intent)
        }
    }
}