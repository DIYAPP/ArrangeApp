package com.example.diyapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class recycleViewitem ( val name : String)

class RecycleViewAdapter( private val context: Context) : RecyclerView.Adapter<RecycleViewAdapter.ViewHolder>() {

    var datas = mutableListOf<recycleViewitem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.arrange_list, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = datas.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(datas[position])
    }


    fun getDataList(): MutableList<recycleViewitem> {
        val dataList = mutableListOf<recycleViewitem>()

        dataList.apply { add(recycleViewitem("Now")) };
        dataList.apply { add(recycleViewitem("ABC")) };
        dataList.apply { add(recycleViewitem("Color")) };
        dataList.apply { add(recycleViewitem("Category")) };

        return dataList;
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val txt: TextView = itemView.findViewById(R.id.list_name)

        fun bind(item: recycleViewitem) {
            txt.text = item.name

            val pos = adapterPosition
            if (pos != RecyclerView.NO_POSITION) {
                itemView.setOnClickListener {
                    listener?.onClick(itemView, item, pos)
                }
            }
        }
    }

    interface OnItemClickListener {
        fun onClick(v: View, data: recycleViewitem, pos: Int)
    }

    private var listener: OnItemClickListener? = null
    fun setOnItemClickListener(listener: OnItemClickListener) {
        this.listener = listener
    }
}