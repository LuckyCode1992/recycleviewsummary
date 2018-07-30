package com.justcode.hxl.recycleviewsummary

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item.view.*

class MyAdapter(var list: List<Int>, var context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        var myViewHolder: RecyclerView.ViewHolder? = null
        var view = LayoutInflater.from(context).inflate(R.layout.item, parent, false)
        myViewHolder = ViewHolder(view)

        return myViewHolder

    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        with(holder.itemView){
            title.text = "title:"+list[position]
            content.text = "content:"+list[position]
        }
    }

    fun update(list: MutableList<Int>){
        this.list = list
        notifyDataSetChanged()
    }
    class ViewHolder( itemView: View) : RecyclerView.ViewHolder(itemView)

}