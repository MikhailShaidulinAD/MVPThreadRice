package com.shaidulin.mvpthreadrace.ui.main.activities

import android.Manifest
import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.arellomobile.mvp.presenter.InjectPresenter
import com.shaidulin.mvpthreadrace.R
import com.shaidulin.mvpthreadrace.ui.base.activities.BaseActivity
import com.shaidulin.mvpthreadrace.ui.main.presenters.MainPresenter
import com.shaidulin.mvpthreadrace.ui.main.views.MainView
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity:BaseActivity(), MainView, View.OnClickListener {

    @InjectPresenter
    lateinit var presenter:MainPresenter

    private lateinit var handler:Handler


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        this.start_rice.setOnClickListener(this)
        handler = Handler(this.mainLooper)
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == 1){
            presenter.setIsAvailableWrite(true)
        }
    }


    @SuppressLint("SetTextI18n")
    override fun showResultWinner(winner: String) {
        handler.post { this.winner_name.text = "${this.winner_name.text} $winner \n" }

    }

    override fun clearResult() {
        this.winner_name.text = ""
    }

    override fun checkPermissionWriteExternalStorage() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE), 1)
            presenter.setIsAvailableWrite(false)
        }else{
            presenter.setIsAvailableWrite(true)
        }
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.start_rice->presenter.needRunThreads()
        }
    }

}