package com.shaidulin.mvpthreadrace

import android.app.Application
import com.shaidulin.mvpthreadrace.di.components.AppComponent
import com.shaidulin.mvpthreadrace.di.components.DaggerAppComponent
import com.shaidulin.mvpthreadrace.di.components.ca.MainSubcomponent
import com.shaidulin.mvpthreadrace.di.modules.ca.ContextModule
import com.shaidulin.mvpthreadrace.di.modules.ca.MainModule

 class BaseApplication:Application() {

     companion object{
         var baseApplication:BaseApplication? = null
     }

    private var appComponent: AppComponent? = null
    private var mainSubcomponent:MainSubcomponent? = null

    override fun onCreate() {
        super.onCreate()
        initDI()
    }

    private fun initDI(){
        appComponent = DaggerAppComponent.builder().contextModule(ContextModule(this)).build()
        baseApplication = this
    }

    fun removeMainSubcomponent() {mainSubcomponent = null }
    fun getMainSubcomponent():MainSubcomponent{
        return if (mainSubcomponent == null) {
            appComponent!!.main(MainModule())
        }else{
            mainSubcomponent!!
        }
    }

}