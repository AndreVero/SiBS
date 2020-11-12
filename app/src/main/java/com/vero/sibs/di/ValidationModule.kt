package com.vero.sibs.di

import com.vero.sibs.utils.NameValidator
import com.vero.sibs.utils.PhoneValidator
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent

@Module
@InstallIn(ActivityRetainedComponent::class)
object ValidationModule {

    @Provides
    fun providePhoneValidator() = PhoneValidator()

    @Provides
    fun provideNameValidator() = NameValidator()
}