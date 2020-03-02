package com.shaidulin.mvpthreadrace.di.components

import android.content.Context
import com.shaidulin.mvpthreadrace.di.components.ca.MainSubcomponent
import com.shaidulin.mvpthreadrace.di.modules.ca.ContextModule
import com.shaidulin.mvpthreadrace.di.modules.ca.MainModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ContextModule::class
])
interface AppComponent {

    fun main(module:MainModule):MainSubcomponent

    fun getContext() : Context
}