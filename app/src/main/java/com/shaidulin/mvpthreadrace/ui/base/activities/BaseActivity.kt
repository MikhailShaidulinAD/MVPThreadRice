package com.shaidulin.mvpthreadrace.ui.base.activities

import com.arellomobile.mvp.MvpActivity
import com.shaidulin.mvpthreadrace.ui.base.views.BaseView

abstract class BaseActivity:MvpActivity(),BaseView {
    override fun onShowAlertDialog(
        message: String,
        isCancelable: Boolean,
        positiveAction: (() -> Unit)?
    ) {
    }

    override fun onShowAlertDialog(
        strRes: Int,
        isCancelable: Boolean,
        positiveAction: (() -> Unit)?
    ) {
    }

    override fun onShowProgressBar() {
    }

    override fun onHideProgressBar() {
    }

    override fun onShowOptionDialog(
        message: String,
        positiveAction: (() -> Unit)?,
        negativeAction: (() -> Unit)?
    ) {
    }

    override fun onLogout() {
    }

    override fun onToast(strRes: Int, toastLength: Int) {
    }
}