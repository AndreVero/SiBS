package com.vero.sibs.ui.registration.impl

import com.google.common.truth.Truth.assertThat
import com.vero.sibs.utils.NameValidator
import org.junit.Before
import org.junit.Test
import java.lang.StringBuilder

class NameValidatorImplTest {

    private lateinit var nameValidator: NameValidator

    @Before
    fun setUp() {
        nameValidator = NameValidator()
    }

    @Test
    fun `empty name return false`() {
        val result = nameValidator.nameIsValid("")
        assertThat(result).isFalse()
    }

    @Test
    fun `name that have more than 30 symbols return false`() {
        val name = StringBuilder()
        for (i in 0..30)
            name.append(i)
        val result = nameValidator.nameIsValid(name.toString())
        assertThat(result).isFalse()
    }

    @Test
    fun `name with count of symbols in range 3-30 return true`() {
        val result = nameValidator.nameIsValid("Name")
        assertThat(result).isTrue()
    }
}