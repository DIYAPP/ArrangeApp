package com.example.diyapp

import android.content.Context
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class appListViewitem ( val name : String, val image : Drawable)

class AppListAdapter (private val context: Context) : RecyclerView.Adapter<AppListAdapter.ViewHolder>(){

    var datas = mutableListOf<appListViewitem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AppListAdapter.ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.app_list, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = datas.size

    override fun onBindViewHolder(holder: AppListAdapter.ViewHolder, position: Int) {
        holder.bind(datas[position])
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val txt: TextView = itemView.findViewById(R.id.applist_name)

        fun bind(item: appListViewitem) {
            txt.text = item.name

            }
        }
    }