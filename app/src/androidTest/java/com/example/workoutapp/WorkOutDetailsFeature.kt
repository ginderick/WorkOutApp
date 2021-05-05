package com.example.workoutapp

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class WorkOutDetailsFeature: BaseUITest() {

    @Test
    fun displayGetReady() {
        navigateToWorkOutDetails()

        onView(ViewMatchers.withId(R.id.get_ready_text))
        onView(ViewMatchers.withId(R.id.upcoming_workout_text))
        onView(ViewMatchers.withId(R.id.workout_exercise))
        onView(ViewMatchers.withId(R.id.rv_workout_status))
    }

    private fun navigateToWorkOutDetails() {
        onView(ViewMatchers.withId(R.id.startButton)).perform(ViewActions.click())
        onView(ViewMatchers.withId(R.id.workOutDetailsFragment)).check(
            ViewAssertions.matches(
                ViewMatchers.isDisplayed()
            )
        )
    }


}