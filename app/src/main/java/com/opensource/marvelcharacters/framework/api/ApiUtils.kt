package com.opensource.marvelcharacters.framework.api

import android.content.Context
import android.net.ConnectivityManager
import androidx.core.content.ContextCompat.getSystemService
import java.security.NoSuchAlgorithmException
import java.util.*


class ApiUtils(val context: Context){
    fun getCurrentTimeInMillis(): Long {
        return Calendar.getInstance().timeInMillis
    }

    fun getMd5Hash(input: String): String {
        val md5 = "MD5"
        try {
            // Create MD5 Hash
            val digest = java.security.MessageDigest
                .getInstance(md5)
            digest.update(input.toByteArray())
            val messageDigest = digest.digest()

            // Create Hex String
            val output = StringBuilder()
            for (aMessageDigest in messageDigest) {
                var h = Integer.toHexString(0xFF and aMessageDigest.toInt())
                while (h.length < 2)
                    h = "0$h"
                output.append(h)
            }
            return output.toString()

        } catch (e: NoSuchAlgorithmException) {
            e.printStackTrace()
        }

        return ""
    }

    fun isNetworkAvailable(): Boolean {
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as? ConnectivityManager
        val activeNetworkInfo = connectivityManager?.activeNetworkInfo
        return activeNetworkInfo != null && activeNetworkInfo.isConnected
    }

}