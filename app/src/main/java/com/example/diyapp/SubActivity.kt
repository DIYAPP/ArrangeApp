package com.example.diyapp

import android.content.Context
import android.content.pm.PackageInfo
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.telephony.ims.ImsMmTelManager
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.diyapp.sortmethod.Companion.method
import kotlinx.android.synthetic.main.activity_arrange.*
import kotlinx.android.synthetic.main.main_item.*
import java.util.*
import kotlin.collections.ArrayList

class SubActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_arrange)

        var itemlist = arrayListOf<item>()

        val packageManager = this.packageManager
        val packages: List<PackageInfo> = packageManager.getInstalledPackages(0)

        for (info: PackageInfo in packages)
        {
        val iticon: Drawable = info.applicationInfo.loadIcon(packageManager)
        val it: item = item(info.applicationInfo.processName, iticon)
        itemlist.add(it)
        }
        if(method==1)
        {
            itemlist =  ArrayList(itemlist.sortedBy { it.name })
           //itemlist = itemlist.reversed() as ArrayList<item>
        }
        else{}
        val itemAdapter = MainListAdapter(this, itemlist)
        mainListView.adapter = itemAdapter
    }
}