package com.vero.core.ui.registration

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.vero.core.ui.registration.utils.NameValidator
import com.vero.core.ui.registration.utils.PhoneValidator

class RegistrationViewModel @ViewModelInject constructor (
    phoneValidator: PhoneValidator,
    nameValidator: NameValidator
) : ViewModel() {

    val phoneNumber = MutableLiveData("")
    val name = MutableLiveData("")

    val valid = MediatorLiveData<Boolean>().apply {
        addSource(phoneNumber) {
            value = phoneValidator.phoneIsValid(it) && nameValidator.nameIsValid(name.value ?: "")
        }
        addSource(name) {
            value = nameValidator.nameIsValid(it) && phoneValidator.phoneIsValid(phoneNumber.value ?: "")
        }
    }
}