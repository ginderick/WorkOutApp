package com.example.workoutapp


import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class WorkOutHomeFeature: BaseUITest() {

    @Test
    fun displayStartButton() {
        onView(withId(R.id.startButton))
    }

    @Test
    fun navigateToWorkOutDetails() {
        onView(withId(R.id.startButton)).perform(click())
        onView(withId(R.id.workOutDetailsFragment)).check(matches(isDisplayed()))
    }
}