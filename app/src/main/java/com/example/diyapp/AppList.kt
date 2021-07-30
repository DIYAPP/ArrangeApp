package com.example.diyapp

import android.content.Context
import android.content.pm.PackageInfo
import android.graphics.drawable.Drawable

class item ( val name : String, val image : Drawable )

class AppList(val ctx :Context) {

    fun getAppList() : ArrayList<item> {
        val itemlist = arrayListOf<item>()
        val packageManager = ctx.packageManager
        val packages : List<PackageInfo> = packageManager.getInstalledPackages(0)

        for(info:PackageInfo in packages)
        {
            val iticon: Drawable = info.applicationInfo.loadIcon(packageManager)
            val it = item(info.applicationInfo.processName, iticon)
            itemlist.add(it)
        }
        return itemlist
    }

}