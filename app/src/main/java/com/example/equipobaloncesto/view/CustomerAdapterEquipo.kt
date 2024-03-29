package com.example.equipobaloncesto.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.equipobaloncesto.R
import com.example.equipobaloncesto.database.entities.Equipo

class CustomerAdapterEquipo(private val equipoList:List<Equipo>): RecyclerView.Adapter<CustomerAdapterEquipo.EquipoViewHolder>() {

    private var onClickListener: OnClickListener? = null

    interface OnClickListener {
        fun onClick(equipo: Equipo)
    }
    class EquipoViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val textViewNombre: TextView
        val textViewCiudad: TextView
        val textViewPabellon: TextView

        init {
            textViewNombre = itemView.findViewById(R.id.nombre1)
            textViewCiudad = itemView.findViewById(R.id.Ciudad)
            textViewPabellon = itemView.findViewById(R.id.pabellon)
        }
        fun bind(equipo: Equipo, onClickListener: OnClickListener?, ) {
            textViewNombre.text = textViewNombre.text.toString() + equipo.nombre_equipo
            textViewCiudad.text = textViewCiudad.text.toString() + equipo.ciudad
            textViewPabellon.text = textViewPabellon.text.toString()+equipo.nombre_pabellón


            itemView.setOnClickListener {
                onClickListener?.onClick(equipo)
            }
        }
    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): EquipoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.equipo_item,parent,false)
        return EquipoViewHolder(view)
    }

    override fun onBindViewHolder(holder: EquipoViewHolder, position: Int) {
        holder.bind(equipoList[position], onClickListener)
    }

    override fun getItemCount()= equipoList.size
    fun setOnItemClickListener(onClickListener: MainActivityViewEquipo) {
        this.onClickListener = onClickListener
    }
}