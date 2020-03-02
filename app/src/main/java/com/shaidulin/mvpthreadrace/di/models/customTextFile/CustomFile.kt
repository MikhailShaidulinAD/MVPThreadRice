package com.shaidulin.mvpthreadrace.di.models.customTextFile

import java.io.*

class CustomFile(fileName:String, format:String, rootPath:String) {
    companion object{
        private const val TAG = "CustomFile"
    }
    val file:File
    var writer: FileWriter
    var reader:FileReader
    init {
        val root = File(rootPath, "Folder")
        if (!root.exists())
            root.mkdirs()
        file = File(root, "$fileName")
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