package com.portales.proyecto_apps.principal.inicio.rutinaVistaPrevia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.portales.proyecto_apps.R

class RutinaVistaPreviaActivity : AppCompatActivity() {
    private lateinit var data :HashMap<String, Any?>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rutina_vista_previa)
        this.title = "Vista previa de rutina"
        intent.extras?.get("data") as HashMap<String, Any?>
    }
}