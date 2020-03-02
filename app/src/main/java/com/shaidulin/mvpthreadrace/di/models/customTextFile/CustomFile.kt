package com.shaidulin.mvpthreadrace.di.models.customTextFile

import android.os.Environment
import java.io.*

class CustomFile(fileName:String, format:String) {
    companion object{
        private const val TAG = "CustomFile"
    }
    val file:File
    var writer: FileWriter
    var reader:FileReader
    init {
        val root = File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), "Folder")
        if (!root.exists())
            root.mkdir()
        file = File(root, "$fileName.$format")
        if (file.exists()){
            file.createNewFile()
        }else{
            file.delete()
            file.createNewFile()
        }
        writer = FileWriter(file)
        reader = FileReader(file)
    }


}