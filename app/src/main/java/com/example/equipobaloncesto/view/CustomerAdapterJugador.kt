package com.example.equipobaloncesto.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.equipobaloncesto.R
import com.example.equipobaloncesto.database.entities.Jugador

class CustomerAdapterJugador(private val jugadorList:List<Jugador>): RecyclerView.Adapter< CustomerAdapterJugador.JugadorViewHolder>() {


    private var onClickListener: OnClickListener? = null

    interface OnClickListener {
        fun onClick(jugador: Jugador)
    }

    class JugadorViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textViewNombre: TextView
        val textViewDorsal: TextView
        val textViewPosicion: TextView


        init {
            textViewNombre = itemView.findViewById(R.id.nombre)
            textViewDorsal = itemView.findViewById(R.id.dorsal)
            textViewPosicion = itemView.findViewById(R.id.posicion)

        }

        fun bind(jugador: Jugador, onClickListener: OnClickListener?, ) {
            textViewNombre.text = textViewNombre.text.toString() + jugador.nombre
            textViewDorsal.text = textViewDorsal.text.toString() +jugador.dorsal.toString()
            textViewPosicion.text = textViewPosicion.text.toString()+jugador.posición


            itemView.setOnClickListener {
                onClickListener?.onClick(jugador)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JugadorViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.jugador_item, parent, false)
        return JugadorViewHolder(view)
    }

    override fun getItemCount() = jugadorList.size


    override fun onBindViewHolder(holder: JugadorViewHolder, position: Int) {

        holder.bind(jugadorList[position], onClickListener)
    }

    fun setOnItemClickListener(onClickListener: OnClickListener) {
        this.onClickListener = onClickListener
    }

}