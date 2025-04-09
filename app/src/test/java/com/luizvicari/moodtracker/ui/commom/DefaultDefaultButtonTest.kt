package com.luizvicari.moodtracker.ui.commom

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsEnabled
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import org.junit.Rule
import org.junit.Test


class DefaultDefaultButtonTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun buttonDisplaysCorrectTest() {
        val buttonText = "Test Button"
        composeTestRule.setContent {
            DefaultButton(onClick = {}, text = buttonText)
        }
        composeTestRule.onNodeWithText(buttonText).assertIsDisplayed()
    }

    @Test
    fun buttonIsEnabledByDefault() {
        val buttonText = "Test Button"
        composeTestRule.setContent {
            DefaultButton(
                text = buttonText,
                onClick = {}
            )
        }
        composeTestRule.onNodeWithText(buttonText).assertIsEnabled()
    }

}