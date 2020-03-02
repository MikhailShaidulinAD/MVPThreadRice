package com.shaidulin.mvpthreadrace.ui.main.repositories.dataservices

import com.shaidulin.mvpthreadrace.di.models.CustomThread
import com.shaidulin.mvpthreadrace.di.models.customTextFile.WriteAndReadTextFile
import com.shaidulin.mvpthreadrace.ui.main.providers.IMainStore
import java.util.ArrayList

class MainStore:IMainStore {
    var listThread:ArrayList<CustomThread> = arrayListOf()
    var textFile:WriteAndReadTextFile? = null
    var isAvailableWrite:Boolean = false
}