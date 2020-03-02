package com.shaidulin.mvpthreadrace.ui.base.views

import android.widget.Toast
import androidx.annotation.StringRes
import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.SkipStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType

interface BaseView : MvpView {
    fun onShowAlertDialog(message: String, isCancelable: Boolean = true, positiveAction: (() -> Unit)? = null)
    fun onShowAlertDialog(@StringRes strRes: Int, isCancelable: Boolean = true, positiveAction: (() -> Unit)? = null)
    @StateStrategyType(SkipStrategy::class)
    fun onShowProgressBar()
    @StateStrategyType(SkipStrategy::class)
    fun onHideProgressBar()
    fun onShowOptionDialog(message: String,
                           positiveAction: (() -> Unit)? = null,
                           negativeAction: (() -> Unit)? = null)
    fun onLogout()
    fun onToast(@StringRes strRes: Int, toastLength: Int = Toast.LENGTH_SHORT)
}