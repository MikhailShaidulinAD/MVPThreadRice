package com.shaidulin.mvpthreadrace.ui.main.views

import com.shaidulin.mvpthreadrace.ui.base.views.BaseView

interface MainView:BaseView {
    fun showResultWinner(winner:String)
    fun clearResult()
    fun checkPermissionWriteExternalStorage()
}