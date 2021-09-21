package com.example.diyapp

import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.drawable.*
import android.os.Build

class DAColor {
    /* color 변수에 app icon image 특정 픽셀 색상을 추출하여 값을 저장*/
    var color: Int = 0
    fun setIconImage(icon: Drawable) {
        /*app icon image를 비트맵으로 변환 후 특정좌표(x,y) 픽셀 ARGB 색상 추출*/
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            color = bitmap_icon(icon).getColor(0, 0).toArgb()
        }
    }

    fun getColorList(): Int {
        return color
    }
}

fun bitmap_icon(iticon: Drawable): Bitmap {
    /* app icon image 타입에 따라 이미지 수정하여 bitmap 타입으로 반환*/
    var color: Bitmap
    /* 적응형 타입인 경우 아이콘의 전경과 배경 2가지 구분을 합쳐서 한 이미지로 저장 */
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
            width, height, Bitmap.Config.ARGB_8888
        )  // 4
        val canvas = Canvas(bitmap)  // 5
        layerDrawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight())
        layerDrawable.draw(canvas)  // 6
        color = bitmap
    }
    /* 백터 타입 경우 Canvas에 그려서 비트맵으로 저장 변환 */
    else if (iticon is VectorDrawable) {
        val bitmap = Bitmap.createBitmap(
            iticon.getIntrinsicWidth(),
            iticon.getIntrinsicHeight(), Bitmap.Config.ARGB_8888
        )
        val canvas = Canvas(bitmap)
        iticon.setBounds(0, 0, canvas.width, canvas.height)
        iticon.draw(canvas)

        color = bitmap
    } else {
        val bitmapDrawable = iticon as BitmapDrawable
        val bitmap = bitmapDrawable.bitmap
        color = bitmap
    }
    return color
}