package com.vero.sibs.ui.registration.utils.impl

import com.vero.sibs.ui.registration.utils.NameValidator

class NameValidatorImpl : NameValidator {
    override fun nameIsValid(name: String): Boolean {
        return name.length in 3..30
    }
}