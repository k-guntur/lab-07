package com.example.lab_7

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class DriversScreenTest {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>() // access MainActivity

    @Test
    fun navigate_to_drivers_add_driver_clear_and_return_home() {
        // navigate to the drivers screen
        composeTestRule
            .onNodeWithTag("driverButton")
            .performClick()

        // verify drivers screen
        composeTestRule
            .onNodeWithText("Drivers")
            .assertExists()

        // enter driver
        composeTestRule
            .onNodeWithTag("driverInput")
            .performTextInput("Max Hamilton")

        // add driver
        composeTestRule
            .onNodeWithTag("addDriverButton")
            .performClick()

        // verify that the driver appears
        composeTestRule
            .onNodeWithText("Max Hamilton")
            .assertExists()

        // clear the drivers list
        composeTestRule
            .onNodeWithTag("clearButton")
            .performClick()

        // verify that the drivers list is clear
        composeTestRule
            .onNodeWithText("")
            .assertExists()

        // return to the home screen
        composeTestRule
            .onNodeWithTag("homeButton")
            .performClick()

        // verify return to the home screen
        composeTestRule
            .onNodeWithText("FormulaZero Home")
            .assertExists()
    }
}