package com.luizvicari.moodtracker.ui.commom

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import com.luizvicari.moodtracker.ui.theme.MoodTrackerTheme

@Composable
fun DefaultTextInput(
    modifier: Modifier = Modifier,
    onChange: (String) -> Unit,
    value: String,
    label: String = "",
    placeholder: String = "",
    visualTransformation: VisualTransformation = VisualTransformation.None,
    trailingIcon: @Composable (() -> Unit)? = null,
    leadingIcon: @Composable (() -> Unit)? = null,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    isError: Boolean = false,
    supportingText: @Composable (() -> (Unit))? = null
) {
    OutlinedTextField(
        modifier = modifier,
        onValueChange = onChange,
        value = value,
        label = { Text(text = label) },
        placeholder = { Text(text = placeholder) },
        visualTransformation = visualTransformation,
        trailingIcon = trailingIcon,
        leadingIcon = leadingIcon,
        keyboardOptions = keyboardOptions,
        isError = isError,
        supportingText = supportingText,
    )
}

@Preview(showBackground = true)
@Composable
private fun DefaultTextInputPreview() {
    MoodTrackerTheme {
        DefaultTextInput(onChange = {}, value = "Text Input")
    }
}