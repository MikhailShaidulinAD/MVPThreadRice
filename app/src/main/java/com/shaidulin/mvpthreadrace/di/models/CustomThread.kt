package com.shaidulin.mvpthreadrace.di.models

import android.util.Log
import com.shaidulin.mvpthreadrace.di.models.customTextFile.WriteAndReadTextFile

class CustomThread( var nameThread:String,  var count:Int, val textFile: WriteAndReadTextFile):Thread() {

    init {
        name = nameThread
    }

    private var index = 0
    private lateinit var listener:CustomThreadListener
    companion object{
        private const val TAG = "CustomThread"
    }

    fun addListenerThread(listener:CustomThreadListener){
        this.listener = listener
    }

    override fun run() {
        while (index <= count){
            textFile.writeToFile("Поток $name счет: $index")
            Log.d(TAG, "$nameThread: $index")
            index +=1
        }
        val endResult = if (!textFile.isHaveWinner()){
            "Поток $nameThread выиграл"
        }else{
            "Поток $nameThread проиграл"
        }
        textFile.writeToFile(endResult)
        if (::listener.isInitialized) {
                listener.threadComplete(endResult, this)
        }
    }

interface CustomThreadListener{
    fun threadComplete(message:String, thread: CustomThread)
}
}