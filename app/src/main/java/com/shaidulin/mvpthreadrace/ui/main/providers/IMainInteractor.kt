package com.shaidulin.mvpthreadrace.ui.main.providers

interface IMainInteractor {
    fun requestCreateTxtFile(nameFile:String)
    fun requestCreateThreads(names:List<String>, countWriters:Int):Boolean
    fun runningAllThreads(call: (message:String?) -> Unit)
    fun fetchAvailableWrite(isAvailable:Boolean)
    fun clearWinnerStatistic()
}