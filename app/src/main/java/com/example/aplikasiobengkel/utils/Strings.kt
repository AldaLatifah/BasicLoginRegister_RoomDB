package com.example.aplikasiobengkel.utils

import androidx.annotation.StringRes
import com.example.aplikasiobengkel.utils.App

object Strings {
    fun get(@StringRes stringRes: Int, vararg formatArgs: Any = emptyArray()): String {
        return App.instance.getString(stringRes, *formatArgs)
    }
}