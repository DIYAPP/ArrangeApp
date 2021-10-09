package com.example.diyapp

import android.content.Context
import android.content.pm.PackageInfo
import android.content.pm.PackageManager
import android.graphics.drawable.Drawable


class AppInfo {

    /**
     * app id 가져오기
     * @param context context
     * @return appId
     */
    fun getAppId(context: Context): String {
        var appId = ""
        try {
            val pm: PackageManager = context.packageManager
            val pi: PackageInfo = pm.getPackageInfo(context.packageName, 0)
            appId = pi.applicationInfo.loadDescription(pm).toString() + ""
        } catch (e: PackageManager.NameNotFoundException) { }
        return appId
    }

    fun getAppId(pi: PackageInfo, pm: PackageManager): String {
        var appId = ""
        try {
            appId = pi.applicationInfo.loadDescription(pm).toString() + ""
        } catch (e: PackageManager.NameNotFoundException) { }
        return appId
    }

    /**
     * app name 가져오기
     * @param context context
     * @return appName
     */
    fun getAppName(context : Context): String {
        var appName = ""
        try {
            val pm: PackageManager = context.packageManager
            val pi: PackageInfo = pm.getPackageInfo(context.packageName, 0)
            appName = pi.applicationInfo.loadLabel(pm).toString() + ""
        } catch (e: PackageManager.NameNotFoundException) { }
        return appName
    }

    fun getAppName(pi: PackageInfo, pm: PackageManager): String {
        var appName = ""
        try {
            appName = pi.applicationInfo.loadLabel(pm).toString() + ""
        } catch (e: PackageManager.NameNotFoundException) { }
        return appName
    }

    /**
     * package name 가져오기
     * @param context
     * @return packageName
     */
    fun getPackageName(context: Context): String {
        var packageName = "" // 패키지명 예시 데이터
        try {
            val packagemanager = context.packageManager
            val appinfo =
                packagemanager.getApplicationInfo(packageName, PackageManager.GET_META_DATA)
            packageName = packagemanager.getApplicationLabel(appinfo).toString()
        } catch (e: PackageManager.NameNotFoundException) {
            e.printStackTrace()
        }
        return packageName
    }

    /**
     * app version 가져오기
     * @param context context
     * @return version
     */
    fun getVersion(context: Context): String {
        var version = ""
        try {
            val pInfo = context.packageManager.getPackageInfo(context.packageName, 0)
            version = pInfo.versionName + ""
        } catch (e: PackageManager.NameNotFoundException) {
            e.printStackTrace()
        }
        return version
    }

    /**
     * app Icon 가져오기
     * @param context context
     * @return icon
     */
    fun getIcon(context: Context): Drawable {
        val pm: PackageManager = context.packageManager
        val pi: PackageInfo = pm.getPackageInfo(context.packageName, 0)
        val icon: Drawable = pi.applicationInfo.loadIcon(pm)
        return icon
    }

    /**
     * PackageInfo의 app Icon 가져오기
     * @param context context
     * @return icon
     */
    fun getIcon(pi: PackageInfo, pm: PackageManager): Drawable {
        val icon: Drawable = pi.applicationInfo.loadIcon(pm)
        return icon
    }
}