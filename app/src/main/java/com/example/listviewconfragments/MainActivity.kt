package com.example.listviewconfragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity(), Comunicador {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            // Comienza una transacción de fragmentos. Las transacciones se utilizan para añadir, reemplazar o realizar otras operaciones con fragmentos.
            supportFragmentManager.beginTransaction()
                // Reemplaza el contenido del contenedor (identificado por R.id.containerFragmentoA) con una instancia de FragmentoA.
                // Este es el proceso de agregar el fragmento a la actividad.
                .replace(R.id.contenedor1, FragmentoLista())
                // Confirma la transacción. Hasta que no se llama a commit, los cambios no son efectivos.
                .commit()

            supportFragmentManager.beginTransaction()
                // Reemplaza el contenido del contenedor (identificado por R.id.containerFragmentoA) con una instancia de FragmentoA.
                // Este es el proceso de agregar el fragmento a la actividad.
                .replace(R.id.contenedor2, FragmentoSeleccionado())
                // Confirma la transacción. Hasta que no se llama a commit, los cambios no son efectivos.
                .commit()
        }
    }

    override fun enviarDatos(escudo: Escudo) {
        val fragmento2 = supportFragmentManager.findFragmentById(R.id.contenedor2) as? FragmentoSeleccionado
        fragmento2?.actualizarEscudo(escudo)
    }
}