package com.vero.sibs.ui.registration

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vero.sibs.utils.NameValidator
import com.vero.sibs.utils.PhoneValidator
import com.vero.core_db_impl.api.LocalStorage
import com.vero.core.model.User
import kotlinx.coroutines.launch

class RegistrationViewModel @ViewModelInject constructor (
    private val phoneValidator: PhoneValidator,
    private val nameValidator: NameValidator,
    private val localStorage: LocalStorage
) : ViewModel() {

    val phoneNumber = MutableLiveData("")
    val name = MutableLiveData("")
    val isAuthorize = MutableLiveData(false)

    val valid = MediatorLiveData<Boolean>().apply {
        addSource(phoneNumber) {
            value = phoneValidator.phoneIsValid(it) && nameValidator.nameIsValid(name.value ?: "")
        }
        addSource(name) {
            value = nameValidator.nameIsValid(it) && phoneValidator.phoneIsValid(phoneNumber.value ?: "")
        }
    }

    fun signUpUser() {
        viewModelScope.launch {
            localStorage.saveUser(
                User(
                    username = name.value ?: "",
                    phone = phoneNumber.value ?: "")
            )
            isAuthorize.postValue(true)
        }
    }
}