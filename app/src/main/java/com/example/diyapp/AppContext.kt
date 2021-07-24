package com.example.diyapp

import android.content.Context

import android.app.Application

class AppContext : Application(){

    init{
        instance = this
    }

    companion object{
        var instance: AppContext ?= null
        fun context() : Context {
            return instance!!.applicationContext
        }
    }
}