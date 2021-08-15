package com.example.diyapp


import android.content.pm.PackageInfo
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.drawable.*
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.palette.graphics.Palette
import com.example.diyapp.sortmethod.Companion.method
import kotlinx.android.synthetic.main.activity_arrange.*

import kotlin.collections.ArrayList

class item ( val name : String, val image : Drawable, val color : Int )

class SubActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_arrange)

        var itemlist = arrayListOf<item>()

        val packageManager = this.packageManager
        val packages: List<PackageInfo> = packageManager.getInstalledPackages(0)

        for (info: PackageInfo in packages)
        {
        var color_number = 0
        val iticon: Drawable = info.applicationInfo.loadIcon(packageManager)
            Palette.from(bitmap_icon(iticon)).generate{ palette ->
                if(palette != null) {
                    color_number = palette.getDominantColor(R.attr.color)
                }
            }
        val it: item = item(info.applicationInfo.processName, iticon,color_number)
        itemlist.add(it)
        }
        if(method==1)
        {
            itemlist =  ArrayList(itemlist.sortedBy { it.name })
           //itemlist = itemlist.reversed() as ArrayList<item>
        }
        else if(method==2){
            itemlist =  ArrayList(itemlist.sortedBy { it.color })
        }
        val itemAdapter = MainListAdapter(this, itemlist)
        mainListView.adapter = itemAdapter
    }
}
fun bitmap_icon(iticon : Drawable): Bitmap
{
    var color : Bitmap

    if (iticon is AdaptiveIconDrawable) {
        val backgroundDrawable = (iticon as AdaptiveIconDrawable).background  // 1
        val foregroundDrawable = (iticon as AdaptiveIconDrawable).foreground  // 2

        val drawables = arrayOfNulls<Drawable>(2)
        drawables[0] = backgroundDrawable
        drawables[1] = foregroundDrawable

        val layerDrawable = LayerDrawable(drawables)  // 3
        val width = layerDrawable.intrinsicWidth
        val height = layerDrawable.intrinsicHeight
        val bitmap = Bitmap.createBitmap(
            width, height, Bitmap.Config.ARGB_8888)  // 4
        val canvas = Canvas(bitmap)  // 5
        layerDrawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight())
        layerDrawable.draw(canvas)  // 6
        color = bitmap
    }
    else if(iticon is VectorDrawable)
    {
        val bitmap = Bitmap.createBitmap(
            iticon.getIntrinsicWidth(),
            iticon.getIntrinsicHeight(), Bitmap.Config.ARGB_8888
        )
        val canvas = Canvas(bitmap)
        iticon.setBounds(0, 0, canvas.width, canvas.height)
        iticon.draw(canvas)

        color = bitmap
    }
    else
    {
        val bitmapDrawable = iticon as BitmapDrawable
        val bitmap = bitmapDrawable.bitmap
        color = bitmap
    }

    return color
}