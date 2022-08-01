package com.nanda.customtheme.utils

import android.content.Context
import java.io.IOException


object HelperFunctions {

     fun loadJsonFromAssets(context : Context, filename : String): String? {
        val json: String
    try {
        json = context.assets.open(filename).bufferedReader().use { it.readText() }
    }catch(IoException : IOException) {
        IoException.printStackTrace()
        return null
    }
         return json
    }
}