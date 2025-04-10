package com.luizvicari.moodtracker.ui.auth

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.luizvicari.moodtracker.R
import com.luizvicari.moodtracker.data.repository.MockAuthRepository
import com.luizvicari.moodtracker.ui.commom.AppTitle
import com.luizvicari.moodtracker.ui.commom.DefaultButton
import com.luizvicari.moodtracker.ui.commom.DefaultTextInput
import com.luizvicari.moodtracker.ui.theme.MoodTrackerTheme
import org.koin.androidx.compose.koinViewModel

@Composable
fun SignUpScreen(
    modifier: Modifier = Modifier,
    viewModel: SignUpViewModel = koinViewModel(),
    onNavigateToSignIn: () -> Unit
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    Scaffold { innerPadding ->
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp, alignment = Alignment.CenterVertically)
        ) {
            AppTitle()
            DefaultTextInput(
                modifier = Modifier.width(
                300.dp
            ),
                onChange = viewModel::onEmailChanged,
                value = uiState.email,
                placeholder = stringResource(R.string.email_example),
                label = stringResource(
                    R.string.email
                ),
                isError = uiState.emailError != null,
                supportingText = if (!uiState.emailError.isNullOrBlank()) {
                    {
                        uiState.emailError?.let {
                            Text(text = it, color = MaterialTheme.colorScheme.error)
                        }
                    }
                } else {
                    null
                })
            DefaultTextInput(
                modifier = Modifier.width(
                300.dp
            ),
                onChange = viewModel::onDisplayNameChanged,
                value = uiState.displayName,
                placeholder = stringResource(
                    R.string.name_placeholder
                ),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                label = stringResource(R.string.name),
                isError = uiState.displayNameError != null,
                supportingText = if (!uiState.displayNameError.isNullOrBlank()) {
                    {
                        uiState.displayNameError?.let {
                            Text(text = it, color = MaterialTheme.colorScheme.error)
                        }
                    }
                } else {
                    null
                })
            SecretTextInput(
                modifier = Modifier.width(
                300.dp
            ),
                onChange = viewModel::onPasswordChanged,
                value = uiState.password,
                placeholder = stringResource(R.string.password),
                show = uiState.showPassword,
                onIconClick = viewModel::togglePasswordVisibility,
                isError = uiState.passwordError != null,
                supportingText = if (!uiState.passwordError.isNullOrEmpty()) {
                    {
                        uiState.passwordError?.let {
                            Text(text = it, color = MaterialTheme.colorScheme.error)
                        }
                    }
                } else {
                    null
                }

            )
            SecretTextInput(
                modifier = Modifier.width(
                300.dp
            ),
                onChange = viewModel::onConfirmPasswordChanged,
                value = uiState.confirmPassword,
                placeholder = stringResource(R.string.confirm_password),
                show = uiState.showConfirmPassword,
                onIconClick = viewModel::toggleConfirmPasswordVisibility,
                isError = uiState.confirmPasswordError != null,
                supportingText = if (!uiState.confirmPasswordError.isNullOrEmpty()) {
                    {
                        uiState.confirmPasswordError?.let {
                            Text(text = it, color = MaterialTheme.colorScheme.error)
                        }
                    }
                } else {
                    null
                })
            DefaultButton(
                modifier = Modifier.width(
                    300.dp
                ),
                text = stringResource(R.string.create_account),
                onClick = viewModel::onSignUpClick
            )
            DefaultButton(
                modifier = Modifier.width(
                    300.dp
                ),
                text = stringResource(R.string.sign_in),
                onClick = onNavigateToSignIn,
                containerColor = MaterialTheme.colorScheme.tertiaryContainer,
                textColor = MaterialTheme.colorScheme.tertiary,
            )
        }
    }
}

@Preview
@Composable
fun SignUpScreenPreview(modifier: Modifier = Modifier) {
    MoodTrackerTheme {
        SignUpScreen(onNavigateToSignIn = {}, viewModel = SignUpViewModel(MockAuthRepository()))
    }
}