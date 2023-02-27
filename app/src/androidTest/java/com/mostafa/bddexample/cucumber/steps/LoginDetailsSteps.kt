package com.mostafa.bddexample.cucumber.steps

import com.mostafa.bddexample.cucumber.espresso.login.LoginScreenRobot
import com.mostafa.bddexample.utils.ActivityFinisher
import cucumber.api.java.After
import cucumber.api.java.Before
import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When

class LoginDetailsSteps {
    private val robot = LoginScreenRobot()
//    private val activityRule = ActivityTestRule(LoginActivity::class.java, false, false)

    @Before
    fun setup() {
        //not needed now, but you may needed to setup mock responses before your screen starts
    }

    @After
    fun tearDown() {
        ActivityFinisher.finishOpenActivities() // Required for test scenarios with multiple activities or scenarios with more cases
    }

    @Given("^I start the application$")
    fun i_start_app(){
        robot.launchLoginScreen()
    }
    @When("^I click email field$")
    fun i_click_email_field(){
        robot.selectEmailField()
    }
    @When("^I click password field$")
    fun i_click_password_field(){
        robot.selectPasswordField()
    }
    @And("^I close the keyboard$")
    fun close_the_keyboard(){
        robot.closeKeyboard()
    }
    @And("^I enter valid email (\\S+)$")
    fun enter_valid_email(email: String){
        robot.enterEmail(email)
    }
    @And("^I enter valid password (\\S+)$")
    fun enter_valid_password(password: String){
        robot.enterPassword(password)
    }
    @And("^I click sign in button$")
    fun i_click_sign_in_button() {
        robot.clickSignInButton()
    }
    @Then("^I expect to see successful login message$")
    fun i_expect_to_see_successful_login_message() {
        robot.isSuccessfulLogin()
    }
}