package com.example.listviewconfragments

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

data class Escudo(val nombre: String, val img: Int)

class EscudoAdapter(context: Context, resource: Int, private val escudos: List<Escudo>) :
    ArrayAdapter<Escudo>(context, resource, escudos) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        return createItemView(position, convertView, parent)
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        return createItemView(position, convertView, parent)
    }

    private fun createItemView(position: Int, convertView: View?, parent: ViewGroup): View {
        val itemView = convertView ?: LayoutInflater.from(context)
            .inflate(R.layout.escudos_spinner, parent, false)

        val escudo = getItem(position)
        val nombreTextView: TextView = itemView.findViewById(R.id.nombreTextView)
        val imagenImageView: ImageView = itemView.findViewById(R.id.imagenImageView)

        nombreTextView.text = escudo?.nombre
        imagenImageView.setImageResource(escudo?.img ?: 0)

        return itemView
    }
}