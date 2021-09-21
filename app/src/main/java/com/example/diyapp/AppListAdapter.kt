package com.example.diyapp

import android.content.Context
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class appListViewitem ( val name : String, val image : Drawable, var color : Int) {

}
class AppListAdapter (private val context: Context) : RecyclerView.Adapter<AppListAdapter.ViewHolder>(){

    var datas = mutableListOf<appListViewitem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AppListAdapter.ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.app_list, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = datas.size

    override fun onBindViewHolder(holder: AppListAdapter.ViewHolder, position: Int) {
        holder.bind(datas[position])

        /* 아이템 크기 조정. 레이아웃에 맞게 조정 필요 */
        val layoutParams = holder.itemView.layoutParams
        layoutParams.height = 80
        holder.itemView.requestLayout()

    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val itemName: TextView = itemView.findViewById(R.id.applist_name)
        private val itemIcon : ImageView = itemView.findViewById(R.id.applist_img)

        fun bind(item: appListViewitem) {
            itemName.text = item.name
            itemIcon.setImageDrawable(item.image)

            }
        }

    }