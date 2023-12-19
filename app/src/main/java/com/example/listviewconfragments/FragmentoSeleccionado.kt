package com.example.listviewconfragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import androidx.fragment.app.Fragment

class FragmentoSeleccionado : Fragment() {

    var escudoActual: Escudo? = null


    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        escudoActual?.img?.let { outState.putInt("imgEscudo", it) }
        outState.putString("nombreEscudo", escudoActual?.nombre)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragmento_seleccionado, container, false)

        if (savedInstanceState != null) {
            // Recuperamos el texto guardado y lo asignamos a la variable textoActual.
            val imgEscudo = savedInstanceState.getInt("imgEscudo")
            val nombreEscudo = savedInstanceState.getString("nombreEscudo")

            if (imgEscudo != 0 && nombreEscudo != null) {
                view?.findViewById<ImageView>(R.id.imgEscudo)?.setImageResource(imgEscudo)
                view?.findViewById<TextView>(R.id.nombreEscudo)?.text = nombreEscudo
                escudoActual = Escudo(nombreEscudo, imgEscudo)
            }
        }


        return view
    }

    fun actualizarEscudo(escudo: Escudo) {
        view?.findViewById<ImageView>(R.id.imgEscudo)?.setImageResource(escudo.img)
        view?.findViewById<TextView>(R.id.nombreEscudo)?.text = escudo.nombre
        escudoActual = escudo
    }



}