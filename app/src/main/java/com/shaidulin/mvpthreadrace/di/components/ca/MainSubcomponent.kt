package com.shaidulin.mvpthreadrace.di.components.ca

import com.shaidulin.mvpthreadrace.di.modules.ca.MainModule
import com.shaidulin.mvpthreadrace.di.scopes.MainScope
import com.shaidulin.mvpthreadrace.ui.main.presenters.MainPresenter
import dagger.Subcomponent

@MainScope
@Subcomponent(modules = [MainModule::class])
interface MainSubcomponent {
    fun inject(presenter: MainPresenter)

}