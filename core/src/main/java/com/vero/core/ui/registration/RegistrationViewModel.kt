package com.vero.core.ui.registration

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.vero.core.ui.registration.utils.NameValidator
import com.vero.core.ui.registration.utils.PhoneValidator

class RegistrationViewModel @ViewModelInject constructor(
    phoneValidator: PhoneValidator,
    nameValidator: NameValidator
) : ViewModel() {

}