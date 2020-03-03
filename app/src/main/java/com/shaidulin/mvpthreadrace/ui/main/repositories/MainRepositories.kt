package com.shaidulin.mvpthreadrace.ui.main.repositories

import com.shaidulin.mvpthreadrace.di.models.CustomThread
import com.shaidulin.mvpthreadrace.di.models.customTextFile.WriteAndReadTextFile
import com.shaidulin.mvpthreadrace.ui.main.providers.IMainRepositories
import com.shaidulin.mvpthreadrace.ui.main.repositories.dataservices.MainService
import com.shaidulin.mvpthreadrace.ui.main.repositories.dataservices.MainStore

class MainRepositories(val service:MainService, val store:MainStore):IMainRepositories {
    override fun clearThread() {
        store.listThread.clear()
    }

    override fun deleteThread(thread: CustomThread) {
        store.listThread.remove(thread)
    }

    override fun saveNewThread(thread: CustomThread) {
        store.listThread.add(thread)
    }

    override fun getThreads(): ArrayList<CustomThread> {
        return store.listThread
    }

    override fun saveWriteAndReadTextFile(textFile: WriteAndReadTextFile) {
        store.textFile = textFile
    }

    override fun getWriteAndReadTextFile(): WriteAndReadTextFile? {
        return store.textFile
    }

    override fun setAvailableWrite(isAvailable: Boolean) {
        store.isAvailableWrite = isAvailable
    }

    override fun getAvailableWrite(): Boolean {
        return store.isAvailableWrite
    }

    override fun saveRootPath(path: String) {
        store.rootPath = path
    }

    override fun getRootPath(): String? {
        return store.rootPath
    }
}