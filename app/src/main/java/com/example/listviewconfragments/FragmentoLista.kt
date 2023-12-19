package com.example.listviewconfragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import androidx.fragment.app.Fragment

class FragmentoLista : Fragment() {


    private var comunicador: Comunicador? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        comunicador = context as? Comunicador

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragmento_lista, container, false)

        val escudos = listOf(
            Escudo("Tenerife", R.drawable.cdtenerife),
            Escudo("Atletico", R.drawable.atletico),
            Escudo("Barça", R.drawable.barsa),
            Escudo("Las Palmas", R.drawable.laspalmas)
        )

        val listView = view.findViewById<ListView>(R.id.lista)

        val adapter = EscudoAdapter(requireContext(), R.layout.escudos_spinner, escudos)
        listView.adapter = adapter

        listView.setOnItemClickListener { parent, view, position, id ->
            val escudo = escudos[position]
            val bundle = Bundle()
            bundle.putString("nombre", escudo.nombre)
            bundle.putInt("imagen", escudo.img)
            comunicador?.enviarDatos(escudo)

        }


        return view
    }





}