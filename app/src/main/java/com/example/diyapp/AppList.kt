package com.example.diyapp

import android.content.pm.PackageInfo
import android.content.pm.PackageManager
import android.graphics.drawable.*
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_arrange.*
import kotlin.collections.ArrayList
import android.os.Build
import androidx.annotation.RequiresApi


class AppList : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.Q)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_arrange)

        /* intent로 받은 값을 가져온다. */
        val name = intent.getSerializableExtra("arrangeName")

        var itemlist = arrayListOf<appListViewitem>()

        val ctx = AppContext.context()
        val packageManager = this.packageManager
        val packages: List<PackageInfo> = packageManager.getInstalledPackages(PackageManager.MATCH_SYSTEM_ONLY)

        for (info: PackageInfo in packages) {

            val appIcon = AppInfo().getIcon(info, packageManager)
            val appName = AppInfo().getAppName(info, packageManager)
            val it: appListViewitem = appListViewitem(appName, appIcon, 0)
            itemlist.add(it)
        }
        //예외처리 필요
        if(name != null) {
            if (name.equals("ABC")) {
                itemlist = ArrayList(itemlist.sortedBy { it.name })
            }
            else if(name.equals("Color")) {
                var dac = DAColor()
                for(args : appListViewitem in itemlist) {
                    dac.setIconImage(args.image)
                    args.color = dac.getColorList()
                }
                itemlist = ArrayList(itemlist.sortedBy { it.color })
            }
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
