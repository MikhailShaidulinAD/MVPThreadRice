package com.shaidulin.mvpthreadrace.ui.main.presenters

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.shaidulin.mvpthreadrace.BaseApplication
import com.shaidulin.mvpthreadrace.ui.main.interactors.MainInteractor
import com.shaidulin.mvpthreadrace.ui.main.views.MainView
import javax.inject.Inject

@InjectViewState
class MainPresenter:MvpPresenter<MainView>() {

    @Inject
    lateinit var interactor: MainInteractor

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        BaseApplication.baseApplication?.getMainSubcomponent()?.inject(this)
        requestRootPath()
        sendRequestPermission()
    }

    private fun requestRootPath(){
        viewState.getPathDownloadDirectory()
    }

    private fun sendRequestPermission(){
        viewState.checkPermissionWriteExternalStorage()
    }


    private fun createTextFile(name:String){
        interactor.requestCreateTxtFile(nameFile = name)
    }

    private fun createThreads(names:List<String>, countWrite:Int){
        interactor.requestCreateThreads(names = names, countWriters = countWrite)
    }

    fun setIsAvailableWrite(isAvailable:Boolean){
        if (isAvailable){
            createTextFile("LogThreadRice")
            createThreads(arrayListOf("А","Б"), 100)
        }
        interactor.fetchAvailableWrite(isAvailable)
    }

    fun rootPathForFile(path:String){
        if (path.isNotEmpty())
        interactor.rootPathForFile(path)
    }


    fun needRunThreads(){
        viewState.clearResult()
        interactor.clearWinnerStatistic()
        interactor.runningAllThreads { message: String? ->
            if (message.isNullOrEmpty())
                viewState.checkPermissionWriteExternalStorage()
            viewState.showResultWinner(message?:"") }
    }


    override fun onDestroy() {
        super.onDestroy()
        BaseApplication.baseApplication?.removeMainSubcomponent()
    }
}