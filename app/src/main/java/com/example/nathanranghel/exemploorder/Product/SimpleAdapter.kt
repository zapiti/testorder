package com.example.nathanranghel.exemploorder.Product

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.nathanranghel.exemploorder.R


class SimpleAdapter : RecyclerView.Adapter<SimpleAdapter.SimpleViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SimpleViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_card, parent, false)
        return SimpleViewHolder(view)
    }

    override fun onBindViewHolder(holder: SimpleViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return 12
    }

    inner class SimpleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}