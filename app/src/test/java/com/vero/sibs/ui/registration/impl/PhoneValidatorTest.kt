package com.vero.sibs.ui.registration.impl

import com.google.common.truth.Truth.assertThat
import com.vero.sibs.utils.PhoneValidator
import org.junit.Before
import org.junit.Test
import java.lang.StringBuilder

class PhoneValidatorImplTest {

    private lateinit var phoneValidatorImpl : PhoneValidator

    @Before
    fun setUp() {
        phoneValidatorImpl = PhoneValidator()
    }

    @Test
    fun `empty phone return false`() {
        val result = phoneValidatorImpl.phoneIsValid("")
        assertThat(result).isFalse()
    }

    @Test
    fun `phone number that have not only numbers return false`() {
        val result = phoneValidatorImpl.phoneIsValid("3806839aa343")
        assertThat(result).isFalse()
    }

    @Test
    fun `phone that in range of 10-20 and only with numbers return true`() {
        val result = phoneValidatorImpl.phoneIsValid("3806839435343")
        assertThat(result).isTrue()
    }

    @Test
    fun `phone with more symbols than 20 return false`() {
        val phone = StringBuilder()
        for (i in 0..21)
            phone.append(i)
        val result = phoneValidatorImpl.phoneIsValid(phone.toString())
        assertThat(result).isFalse()
    }
}