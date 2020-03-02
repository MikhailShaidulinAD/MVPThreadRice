package com.shaidulin.mvpthreadrace.di.models.customTextFile

import java.io.BufferedWriter
import java.io.FileReader
import java.io.FileWriter

class WriteAndReadTextFile(val textFile:CustomFile) {

    var winner:Boolean = false

    @Synchronized
    fun writeToFile(message:String){
        val buffer = BufferedWriter(FileWriter(textFile.file, true))
        buffer.append(message)
        buffer.newLine()
        buffer.flush()
        buffer.close()
    }
    @Synchronized
    fun readFileLastLine():String{
        textFile.reader = FileReader(textFile.file)
        val lastString = textFile.reader.readLines().last()
        textFile.reader.close()
        return lastString
    }

    fun isHaveWinner():Boolean{
        return if (winner){
            true
        }else{
            winner = true
            false
        }
    }

    fun clearWinner(){
        winner = false
    }
}