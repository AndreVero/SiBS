package com.vero.sibs.ui.registration

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.vero.sibs.fake.FakeDataStorage
import com.vero.sibs.ui.registration.utils.impl.NameValidatorImpl
import com.vero.sibs.ui.registration.utils.impl.PhoneValidatorImpl
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
        viewModel = RegistrationViewModel(
            PhoneValidatorImpl(),
            NameValidatorImpl(),
            FakeDataStorage()
        )
    }

    @Test
    fun `test mediator with valid params`() {
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
        viewModel.phoneNumber.postValue("67890")
        viewModel.name.postValue("Na")
        val validObserver = Observer<Boolean> {
            assertFalse(it)
        }
        viewModel.valid.observeForever(validObserver)
        viewModel.valid.removeObserver(validObserver)
    }
}