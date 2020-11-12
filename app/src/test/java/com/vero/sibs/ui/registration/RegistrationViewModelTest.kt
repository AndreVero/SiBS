package com.vero.sibs.ui.registration

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.vero.core_db_impl.api.LocalStorage
import com.vero.sibs.utils.NameValidator
import com.vero.sibs.utils.PhoneValidator
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import org.junit.Before
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test

class RegistrationViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var viewModel: RegistrationViewModel

    @MockK
    private lateinit var phoneValidator: PhoneValidator

    @MockK
    private lateinit var nameValidator: NameValidator

    @MockK
    private lateinit var localStorage: LocalStorage

    @Before
    fun setUp() {

        MockKAnnotations.init(this, relaxUnitFun = true)

        viewModel = RegistrationViewModel(
            phoneValidator,
            nameValidator,
            localStorage
        )
    }

    @Test
    fun `test mediator with valid params`() {
        every {phoneValidator.phoneIsValid("1234567890")} returns true
        every {nameValidator.nameIsValid("Name")} returns true

        viewModel.phoneNumber.postValue("1234567890")
        viewModel.name.postValue("Name")
        val validObserver = Observer<Boolean> {
            assertTrue(it)
        }
        viewModel.valid.observeForever(validObserver)
        viewModel.valid.removeObserver(validObserver)
    }

    @Test
    fun `test mediator with not valid params`() {
        every {phoneValidator.phoneIsValid("67890")} returns false
        every {nameValidator.nameIsValid("Na")} returns false

        viewModel.phoneNumber.postValue("67890")
        viewModel.name.postValue("Na")
        val validObserver = Observer<Boolean> {
            assertFalse(it)
        }
        viewModel.valid.observeForever(validObserver)
        viewModel.valid.removeObserver(validObserver)
    }
}