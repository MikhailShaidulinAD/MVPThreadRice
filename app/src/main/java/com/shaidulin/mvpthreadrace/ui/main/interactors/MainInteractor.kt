package com.shaidulin.mvpthreadrace.ui.main.interactors

import com.shaidulin.mvpthreadrace.di.models.CustomThread
import com.shaidulin.mvpthreadrace.di.models.customTextFile.CustomFile
import com.shaidulin.mvpthreadrace.di.models.customTextFile.WriteAndReadTextFile
import com.shaidulin.mvpthreadrace.ui.main.providers.IMainInteractor
import com.shaidulin.mvpthreadrace.ui.main.providers.IMainRepositories

class MainInteractor(private val repository: IMainRepositories):IMainInteractor {
    companion object{
        private const val TAG = "MainInteractor"
    }
    override fun requestCreateTxtFile(nameFile: String) {
        repository.saveWriteAndReadTextFile(WriteAndReadTextFile(CustomFile(fileName = nameFile, format = "txt")))
    }

    override fun requestCreateThreads(names:List<String>, countWriters:Int):Boolean {
        repository.clearThread()
        val textFileWrite = repository.getWriteAndReadTextFile()
        return if (textFileWrite != null) {
            for (i in names) {
                repository.saveNewThread(
                    CustomThread(
                        nameThread = i,
                        count = countWriters,
                        textFile = textFileWrite
                    )
                )
            }
            true
        }else{
            false
        }
    }

    override fun runningAllThreads(call: (message:String?) -> Unit) {
        if (!repository.getAvailableWrite()) {
            call.invoke(null)
            return
        }
        val threads = repository.getThreads()
        for (i in threads){
            i.addListenerThread(object:CustomThread.CustomThreadListener{
                override fun threadComplete(message: String, thread: CustomThread) {
                    repository.deleteThread(thread)
                    repository.saveNewThread(CustomThread(nameThread = thread.nameThread, textFile = thread.textFile, count = thread.count))
                    call.invoke(message)
                }
            })
            if (i.state == Thread.State.NEW){
                i.start()
            }

        }
    }

    override fun fetchAvailableWrite(isAvailable: Boolean) {
        repository.setAvailableWrite(isAvailable)
    }

    override fun clearWinnerStatistic() {
        val textFileReader = repository.getWriteAndReadTextFile()
        textFileReader?.clearWinner()
    }
}