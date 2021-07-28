package com.example.diyapp


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val al = AppList(this.applicationContext)
        val itemList : ArrayList<item> = al.getAppList()
        val itemAdapter = MainListAdapter(this, itemList)
        main_item.adapter = itemAdapter

    }
}