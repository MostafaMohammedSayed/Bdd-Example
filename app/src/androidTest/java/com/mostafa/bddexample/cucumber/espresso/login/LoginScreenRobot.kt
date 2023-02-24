package com.mostafa.bddexample.cucumber.espresso.login

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.platform.app.InstrumentationRegistry
import com.mostafa.bddexample.LoginActivity
import com.mostafa.bddexample.R
import java.lang.Thread.sleep

class LoginScreenRobot {
    fun launchLoginScreen() {
        ActivityScenario.launch(LoginActivity::class.java)
    }

    fun selectEmailField() {
        onView(withId(R.id.email)).perform(click())
    }

    fun selectPasswordField() {
        onView(withId(R.id.password)).perform(click())
    }

    fun enterEmail(email: String) {
        onView(withId(R.id.email)).perform(typeText(email))
    }

    fun enterPassword(Password: String) {
        onView(withId(R.id.email)).perform(typeText(Password))
    }

    fun closeKeyboard() {
        Espresso.closeSoftKeyboard()
        sleep(100)
    }

    fun clickSignInButton() {
        onView(withText(InstrumentationRegistry.getInstrumentation().targetContext.getString(
            R.string.action_sign_in))).perform(
            click()
        )
    }
    fun isSuccessfulLogin(){
        onView(withId(R.id.successful_login_text_view)).check(
            matches(isDisplayed()))
        onView(withId(R.id.successful_login_text_view)).check(
            matches(withText(R.string.successful_login)))
    }
}