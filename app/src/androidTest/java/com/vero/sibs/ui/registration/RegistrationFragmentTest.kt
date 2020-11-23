package com.vero.sibs.ui.registration

import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.filters.MediumTest
import com.vero.sibs.R
import com.vero.sibs.launchFragmentInHiltContainer
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.hamcrest.Matchers.allOf
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify

@ExperimentalCoroutinesApi
@MediumTest
@HiltAndroidTest
class RegistrationFragmentTest {

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @Test
    fun clickToSignUp_navigateToMainFragment() {
        val navController = mock(NavController::class.java)
        launchFragmentInHiltContainer<RegistrationFragment>() {
            Navigation.setViewNavController(requireView(), navController)
        }

        onView(allOf(withId(R.id.etName), isDisplayed())).perform(replaceText("Name")) 
        onView(allOf(withId(R.id.etPhone), isDisplayed())).perform(replaceText("12345678901")).perform(closeSoftKeyboard())
        onView(allOf(withId(R.id.btnSignUp), isDisplayed())).perform(click())

        verify(navController).navigate(
            RegistrationFragmentDirections.actionRegistrationFragment2ToMainFragment2()
        )
    }
}




