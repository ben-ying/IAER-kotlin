package com.yjh.iaer.util

import java.math.BigInteger
import java.security.MessageDigest

class MD5Utils {
    public companion object {
        private const val MD5_ENCRYPTION = "md51988"

        fun String.md5(): String {
            val md = MessageDigest.getInstance("MD5")
            return BigInteger(1, md.digest(toByteArray()))
                .toString(16).padStart(32, '0')
        }

        fun getMD5ofStr(plainText: String): String {
            return (MD5_ENCRYPTION + plainText).md5()
        }
    }
}