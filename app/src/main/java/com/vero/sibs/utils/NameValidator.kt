package com.vero.sibs.utils

class NameValidator  {
    fun nameIsValid(name: String): Boolean {
        return name.length in 3..30
    }
}