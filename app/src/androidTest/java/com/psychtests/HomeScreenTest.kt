package com.psychtests

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import org.junit.Rule
import org.junit.Test

class HomeScreenTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun appLaunches_andShowsBottomNav() {
        composeTestRule.waitForIdle()

        composeTestRule.onNodeWithText("Home").assertIsDisplayed()
        composeTestRule.onNodeWithText("History").assertIsDisplayed()
    }

    @Test
    fun testCardsAreDisplayed() {
        composeTestRule.waitForIdle()

        composeTestRule.onNodeWithText("Patient Health Questionnaire (PHQ-9)").assertIsDisplayed()
        composeTestRule.onNodeWithText("Generalized Anxiety Disorder Scale (GAD-7)").assertIsDisplayed()
    }

    @Test
    fun tappingTestCard_navigatesToTestTakingScreen() {
        composeTestRule.waitForIdle()

        composeTestRule.onNodeWithText("Patient Health Questionnaire (PHQ-9)").performClick()

        composeTestRule.waitForIdle()

        composeTestRule.onNodeWithText("Little interest or pleasure in doing things").assertIsDisplayed()
        composeTestRule.onNodeWithText("Question 1 of 9").assertIsDisplayed()
    }
}
