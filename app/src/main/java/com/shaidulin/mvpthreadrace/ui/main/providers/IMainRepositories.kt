package com.shaidulin.mvpthreadrace.ui.main.providers

import com.shaidulin.mvpthreadrace.di.models.CustomThread
import com.shaidulin.mvpthreadrace.di.models.customTextFile.WriteAndReadTextFile

interface IMainRepositories {
    fun clearThread()
    fun deleteThread(thread: CustomThread)
    fun saveNewThread(thread:CustomThread)
    fun getThreads():ArrayList<CustomThread>
    fun saveWriteAndReadTextFile(textFile: WriteAndReadTextFile)
    fun getWriteAndReadTextFile():WriteAndReadTextFile?
    fun setAvailableWrite(isAvailable:Boolean)
    fun getAvailableWrite():Boolean
    fun saveRootPath(path:String)
    fun getRootPath():String?
}