package com.vero.sibs.ui.buy

import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.filters.MediumTest
import com.vero.sibs.R
import com.vero.sibs.launchFragmentInHiltContainer
import com.vero.sibs.ui.main.MainFragment
import com.vero.sibs.ui.main.MainFragmentDirections
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.hamcrest.Matchers
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito
import org.mockito.Mockito.mock

@ExperimentalCoroutinesApi
@MediumTest
@HiltAndroidTest
class BuyFragmentTest {

    @get:Rule
    var hiltAndroidRule = HiltAndroidRule(this)

    @Test
    fun clickToBuyImageView_navigateToBuyFragment() {
        val navController = mock(NavController::class.java)
        launchFragmentInHiltContainer<MainFragment> {
            Navigation.setViewNavController(requireView(), navController)
        }

        Espresso.onView(
            Matchers.allOf(
                ViewMatchers.withId(R.id.btnBuy),
                ViewMatchers.isDisplayed()
            )
        ).perform(ViewActions.click())

        Mockito.verify(navController).navigate(
            MainFragmentDirections.actionMainFragment2ToBuyFragment()
        )
    }
}