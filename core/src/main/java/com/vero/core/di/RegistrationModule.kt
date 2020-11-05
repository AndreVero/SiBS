package com.vero.core.di

import com.vero.core.ui.registration.utils.NameValidator
import com.vero.core.ui.registration.utils.PhoneValidator
import com.vero.core.ui.registration.utils.impl.NameValidatorImpl
import com.vero.core.ui.registration.utils.impl.PhoneValidatorImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent

@Module
@InstallIn(ActivityRetainedComponent::class)
object RegistrationModule {

    @Provides
    fun providePhoneValidator() : PhoneValidator = PhoneValidatorImpl()

    @Provides
    fun provideNameValidator() : NameValidator = NameValidatorImpl()
}