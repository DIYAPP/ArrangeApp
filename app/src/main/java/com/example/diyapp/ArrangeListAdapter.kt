package com.example.diyapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class arrangeViewitem ( val name : String)

class ArrangeListAdapter( private val context: Context) : RecyclerView.Adapter<ArrangeListAdapter.ViewHolder>() {

    var datas = mutableListOf<arrangeViewitem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.arrange_list, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = datas.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(datas[position])
    }


    fun getDataList(): MutableList<arrangeViewitem> {
        val dataList = mutableListOf<arrangeViewitem>()

        /* 앱 정렬 목록 */
        dataList.apply { add(arrangeViewitem("Now")) };
        dataList.apply { add(arrangeViewitem("ABC")) };
        dataList.apply { add(arrangeViewitem("Color")) };
        dataList.apply { add(arrangeViewitem("Category")) };

        return dataList;
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val txt: TextView = itemView.findViewById(R.id.list_name)

        fun bind(item: arrangeViewitem) {
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
        fun onClick(v: View, data: arrangeViewitem, pos: Int)
    }

    private var listener: OnItemClickListener? = null
    fun setOnItemClickListener(listener: OnItemClickListener) {
        this.listener = listener
    }
}