package com.example.assignment.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.assignment.Classes.Rewards
import com.example.assignment.R

class RewardsAdapter(private val rewardsList : List<Rewards>) :
    RecyclerView.Adapter<RewardsAdapter.RewardsviewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RewardsviewHolder {
        val view = LayoutInflater.from(parent.context,)
            .inflate(R.layout.item_rewards,parent,false)
        return RewardsviewHolder(view)
    }

    override fun onBindViewHolder(holder: RewardsviewHolder, position: Int) {
        val rewards = rewardsList[position]
        holder.PrimaryText.text = rewards.title
        holder.Secondarytext.text = rewards.content

    }

    override fun getItemCount(): Int {
        return  rewardsList.size
    }

    inner class RewardsviewHolder(itemView:View) : RecyclerView.ViewHolder(itemView){
        val PrimaryText = itemView.findViewById<TextView>(R.id.PrimaryText)
        val Secondarytext = itemView.findViewById<TextView>(R.id.SecondaryText)

    }
}