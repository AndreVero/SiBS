package com.vero.core.ui.registration

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.vero.core.ui.registration.utils.impl.NameValidatorImpl
import com.vero.core.ui.registration.utils.impl.PhoneValidatorImpl
import org.junit.Before

import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test

class RegistrationViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var viewModel: RegistrationViewModel

    @Before
    fun setUp() {
        viewModel = RegistrationViewModel(PhoneValidatorImpl(), NameValidatorImpl())
    }

    @Test
    fun `test valid mediator`() {
        viewModel.phoneNumber.postValue("1234567890")
        viewModel.name.postValue("Name")
        val validObserver = Observer<Boolean> {
            assertTrue(it)
        }
        viewModel.valid.observeForever(validObserver)
        viewModel.valid.removeObserver(validObserver)
    }

    @Test
    fun `test not valid mediator`() {
        viewModel.phoneNumber.postValue("67890")
        viewModel.name.postValue("Na")
        val validObserver = Observer<Boolean> {
            assertFalse(it)
        }
        viewModel.valid.observeForever(validObserver)
        viewModel.valid.removeObserver(validObserver)
    }
}