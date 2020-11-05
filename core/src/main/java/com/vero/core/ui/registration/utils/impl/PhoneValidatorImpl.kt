package com.vero.core.ui.registration.utils.impl

import com.vero.core.ui.registration.utils.PhoneValidator

class PhoneValidatorImpl : PhoneValidator {
    override fun phoneIsValid(phone: String): Boolean {
        return phone.length in 10..20 && phone.matches(Regex("[0-9]+"))
    }
}