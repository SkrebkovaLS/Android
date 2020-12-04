package com.example.krestnol

import org.junit.Rule
import org.junit.Test
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.rule.ActivityTestRule
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class MainActivityTest{
    @Rule
    @JvmField
    var activityRule = ActivityTestRule<MainActivity>(
        MainActivity::class.java
    )

    @Test
    fun testXWin(){
        val result_expected = ""

        Espresso.onView(withId(R.id.button1)).perform(ViewActions.click())
        Espresso.onView(withId(R.id.button4)).perform(ViewActions.click())
        Espresso.onView(withId(R.id.button2)).perform(ViewActions.click())
        Espresso.onView(withId(R.id.button5)).perform(ViewActions.click())
        Espresso.onView(withId(R.id.button3)).perform(ViewActions.click())

        Espresso.onView(ViewMatchers.withId(R.id.polepobedi)).check(
            ViewAssertions.matches(
                ViewMatchers.withText((result_expected))))


    }
    @Test
    fun testOWin(){
        val result_expected = ""




    }


}