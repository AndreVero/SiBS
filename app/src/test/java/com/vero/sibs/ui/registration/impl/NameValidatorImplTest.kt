package com.vero.sibs.ui.registration.impl

import com.google.common.truth.Truth.assertThat
import org.junit.Before
import org.junit.Test
import java.lang.StringBuilder

class NameValidatorImplTest {

    private lateinit var nameValidatorImpl: com.vero.sibs.ui.registration.utils.impl.NameValidatorImpl

    @Before
    fun setUp() {
        nameValidatorImpl = com.vero.sibs.ui.registration.utils.impl.NameValidatorImpl()
    }

    @Test
    fun `empty name return false`() {
        val result = nameValidatorImpl.nameIsValid("")
        assertThat(result).isFalse()
    }

    @Test
    fun `name that have more than 30 symbols return false`() {
        val name = StringBuilder()
        for (i in 0..30)
            name.append(i)
        val result = nameValidatorImpl.nameIsValid(name.toString())
        assertThat(result).isFalse()
    }

    @Test
    fun `name with count of symbols in range 3-30 return true`() {
        val result = nameValidatorImpl.nameIsValid("Name")
        assertThat(result).isTrue()
    }
}