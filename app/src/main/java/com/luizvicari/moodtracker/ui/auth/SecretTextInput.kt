package com.luizvicari.moodtracker.ui.auth

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import com.luizvicari.moodtracker.R
import com.luizvicari.moodtracker.ui.commom.DefaultTextInput
import com.luizvicari.moodtracker.ui.theme.MoodTrackerTheme

@Composable
fun SecretTextInput(
    modifier: Modifier = Modifier,
    value: String,
    onChange: (String) -> Unit,
    placeholder: String,
    label: String = placeholder,
    show: Boolean = false,
    onIconClick: () -> Unit,
    isError: Boolean = false,
    supportingText: @Composable (() -> (Unit))? = null
) {
    DefaultTextInput(
        modifier = modifier,
        onChange = onChange,
        value = value,
        placeholder = placeholder,
        label = label,
        isError = isError,
        supportingText = supportingText,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password,
            imeAction = ImeAction.Next
        ),
        visualTransformation = if (show) {
            PasswordVisualTransformation()
        } else {
            VisualTransformation.None
        },
        trailingIcon = {
            IconButton(onClick = onIconClick) {
                if (show) {
                    Icon(
                        imageVector = Icons.Filled.Visibility,
                        contentDescription = stringResource(
                            R.string.show_password
                        )
                    )
                } else {
                    Icon(
                        imageVector = Icons.Filled.VisibilityOff,
                        contentDescription = stringResource(
                            R.string.hide_password
                        )
                    )

                }
            }
        }
    )
}


@Preview
@Composable
private fun SecretTextInputPreview() {
    MoodTrackerTheme {
        SecretTextInput(
            value = "password", onChange = {},

            placeholder = "Password",
            show = false,
            onIconClick = {}
        )
    }
}