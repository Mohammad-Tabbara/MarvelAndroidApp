package com.marvel.characters.framework.api

import java.security.NoSuchAlgorithmException
import java.util.*

class ApiUtils{
    fun getCurrentTimeInMillis(): Long {
        return Calendar.getInstance().timeInMillis
    }

    fun getMd5Hash(input: String): String {
        val MD5 = "MD5"
        try {
            // Create MD5 Hash
            val digest = java.security.MessageDigest
                .getInstance(MD5)
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

}