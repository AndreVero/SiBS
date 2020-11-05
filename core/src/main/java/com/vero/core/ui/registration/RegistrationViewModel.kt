package com.vero.core.ui.registration

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vero.core.ui.registration.utils.NameValidator
import com.vero.core.ui.registration.utils.PhoneValidator
import com.vero.core_db_impl.api.DataStorage
import com.vero.core_db_impl.model.User
import kotlinx.coroutines.launch

class RegistrationViewModel @ViewModelInject constructor (
    private val phoneValidator: PhoneValidator,
    private val nameValidator: NameValidator,
    private val dataStorage: DataStorage
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

    fun signUpUser() {
        viewModelScope.launch {
            dataStorage.saveUser(
                User(
                    username = name.value ?: "",
                    phone = phoneNumber.value ?: ""))
        }
    }
}