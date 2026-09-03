package com.psychtests

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import org.junit.Rule
import org.junit.Test

class TestTakingFlowTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    private fun navigateToPhq9() {
        composeTestRule.waitForIdle()
        composeTestRule.onNodeWithText("Patient Health Questionnaire (PHQ-9)").performClick()
        composeTestRule.waitForIdle()
    }

    @Test
    fun phq9_canBeStarted_firstQuestionVisible() {
        navigateToPhq9()

        composeTestRule.onNodeWithText("Little interest or pleasure in doing things").assertIsDisplayed()
        composeTestRule.onNodeWithText("Question 1 of 9").assertIsDisplayed()
    }

    @Test
    fun progressIndicator_isDisplayed() {
        navigateToPhq9()

        composeTestRule.onNode(hasTestTag("LinearProgressIndicator")).assertExists()
    }

    @Test
    fun answerSelection_works() {
        navigateToPhq9()

        composeTestRule.onNodeWithText("Not at all").performClick()

        composeTestRule.onNodeWithText("Not at all").assertIsSelected()
    }

    @Test
    fun backButton_returnsToHome() {
        navigateToPhq9()

        composeTestRule.onNodeWithText("\u2190").performClick()

        composeTestRule.waitForIdle()

        composeTestRule.onNodeWithText("Patient Health Questionnaire (PHQ-9)").assertIsDisplayed()
    }
}
