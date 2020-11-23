package com.vero.sibs.utils

class PhoneValidator {
    fun phoneIsValid(phone: String): Boolean {
        return phone.length in 10..20 && phone.matches(Regex("[0-9]+"))
    }
}