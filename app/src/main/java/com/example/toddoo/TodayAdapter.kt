package com.example.toddoo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView




class TodayAdapter ( private val todayList :ArrayList<Todo>)
    :RecyclerView.Adapter<TodayAdapter.TodayViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TodayAdapter.TodayViewHolder {
        val viewLayout = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return TodayViewHolder(viewLayout)
    }

    override fun onBindViewHolder(holder: TodayAdapter.TodayViewHolder, position: Int) {
        val w = todayList[position]
        holder.todoname.text = w.today
    }

    override fun getItemCount() = todayList.size


    class TodayViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val todoname: TextView = itemView.findViewById(R.id.name)
    }


}
