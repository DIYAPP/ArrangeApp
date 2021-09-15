package com.example.diyapp

import android.content.pm.PackageInfo
import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_arrange.*
import kotlin.collections.ArrayList

class AppList : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_arrange)

        /* intent로 받은 값을 가져온다. */
        var name = intent.getSerializableExtra("arrangeName")

        var itemlist = arrayListOf<appListViewitem>()

        val packageManager = this.packageManager
        val packages: List<PackageInfo> = packageManager.getInstalledPackages(0)

        for (info: PackageInfo in packages)
        {
        val iticon: Drawable = info.applicationInfo.loadIcon(packageManager)
        val it: appListViewitem = appListViewitem(info.applicationInfo.processName, iticon)
        itemlist.add(it)
        }

        //예외처리 필요
        if(name != null) {
            if (name.equals("ABC"))
                itemlist =  ArrayList(itemlist.sortedBy { it.name })
        }
        //if(method==1)
        {
            itemlist =  ArrayList(itemlist.sortedBy { it.name })
           //itemlist = itemlist.reversed() as ArrayList<item>
        }
        //else{}

        /* 정렬한 아이템 리스트를 화면에 출력한다.*/
        lateinit var appItemAdapter : AppListAdapter

        appItemAdapter = AppListAdapter(this)

        appItemAdapter.datas = itemlist
        appListViewMain.adapter = appItemAdapter

        appListViewMain.addItemDecoration(ItemDecorator.Vertical(20))
        appItemAdapter.notifyDataSetChanged()

    }
}