package com.example.assignment.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView
import androidx.recyclerview.widget.RecyclerView
import com.example.assignment.Classes.Essentials
import com.example.assignment.R

class EssentialsAdapter (private val essentialsList : List<Essentials>) :
    RecyclerView.Adapter<EssentialsAdapter.EssentialViewHolder>() {

    override fun onCreateViewHolder( parent: ViewGroup, viewType: Int): EssentialViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_essentials,parent,false)
        return EssentialViewHolder(view)
    }

    override fun onBindViewHolder(holder: EssentialViewHolder, position: Int) {
        val user = essentialsList[position]
        holder.imageId.setImageResource(user.icon)
        holder.Primarytext.text = user.PrimaryText
        if(user.flag==true){
            holder.SecondaryText.text = user.Secondarytext
            holder.SecondaryText.visibility = View.VISIBLE
        }
        holder.Values.text = user.Actiontext
    }

    override fun getItemCount(): Int {
        return essentialsList.size
    }



    inner class EssentialViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val imageId = itemView.findViewById<ImageView>(R.id.imageEssentials)
        val Primarytext = itemView.findViewById<TextView>(R.id.PrimaryText)
        val SecondaryText = itemView.findViewById<TextView>(R.id.SecondaryText)
        val Values = itemView.findViewById<TextView>(R.id.Values)
    }
}