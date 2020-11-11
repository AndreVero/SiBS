package com.vero.sibs.ui.registration

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.filters.SmallTest
import com.vero.sibs.R
import com.vero.sibs.launchFragmentInHiltContainer
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.hamcrest.Matchers.allOf
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
@SmallTest
@HiltAndroidTest
class RegistrationFragmentTest {

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @Test
    fun testSignUp() {
        launchFragmentInHiltContainer<RegistrationFragment>()
        onView(allOf(withId(R.id.etName), isDisplayed())).perform(typeText("Name"))
        onView(allOf(withId(R.id.etPhone), isDisplayed())).perform(typeText("12345678901"))
        onView(allOf(withId(R.id.btnSignUp), isDisplayed())).perform(click())
    }
}




