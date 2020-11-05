package com.vero.core.ui.registration.utils

interface PhoneValidator {
    fun phoneIsValid(phone: String) : Boolean
}