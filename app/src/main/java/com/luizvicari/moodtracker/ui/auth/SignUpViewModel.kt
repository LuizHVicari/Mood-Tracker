package com.luizvicari.moodtracker.ui.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.luizvicari.moodtracker.util.validators.isStrongPassword
import io.konform.validation.Validation
import io.konform.validation.ValidationResult
import io.konform.validation.constraints.minLength
import io.konform.validation.constraints.pattern
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class SignUpViewModel : ViewModel() {
    data class SignUpFormState(
        val email: String = "",
        val displayName: String = "",
        val password: String = "",
        val confirmPassword: String = "",
        val showPassword: Boolean = false,
        val showConfirmPassword: Boolean = false,
        val isFormValid: Boolean = false,
        val isLoading: Boolean = false,
        val emailError: String? = null,
        val displayNameError: String? = null,
        val passwordError: String? = null,
        val confirmPasswordError: String? = null
    )

    private val _uiState = MutableStateFlow(SignUpFormState())
    val uiState: StateFlow<SignUpFormState> = _uiState.asStateFlow()

    private val emailErrorMessage = " stringResource(R.string.should_be_a_valid_e_mail)"
    private val confirmPasswordErrorMessage = "stringResource(R.string.passwords_should_match)"
    private val uppercaseErrorMessage = "Password should contain at least one uppercase character"
    private val lowercaseErrorMessage = "Password should contain at least one lowercase character"
    private val numberErrorMessage = "Password should contain at least one digit"

    fun onEmailChanged(email: String) {
        _uiState.update { it.copy(email = email, emailError = null) }
        validateForm()
    }

    fun onDisplayNameChanged(name: String) {
        _uiState.update { it.copy(displayName = name, displayNameError = null) }
        validateForm()
    }

    fun onPasswordChanged(password: String) {
        _uiState.update { it.copy(password = password, passwordError = null) }
        validateForm()
    }

    fun onConfirmPasswordChanged(confirmPassword: String) {
        _uiState.update { it.copy(confirmPassword = confirmPassword, confirmPasswordError = null) }
        validateForm()
    }

    fun togglePasswordVisibility() {
        _uiState.update { it.copy(showPassword = !it.showPassword) }
    }

    fun toggleConfirmPasswordVisibility() {
        _uiState.update { it.copy(showConfirmPassword = !it.showConfirmPassword) }
    }

    private val validateSignUpForm = Validation<SignUpFormState> {

        SignUpFormState::email {
            pattern(".+@.+\\.com") hint emailErrorMessage
        }
        SignUpFormState::displayName {
            minLength(4)
        }

        SignUpFormState::password {
            isStrongPassword(uppercaseErrorMessage, lowercaseErrorMessage, numberErrorMessage)
        }

        SignUpFormState::confirmPassword {
            constrain(confirmPasswordErrorMessage) { it == _uiState.value.password }
        }
    }

    fun onSignUpClick() {
        if (!_uiState.value.isFormValid) {
            validateForm(showErrors = true)
            return
        }

        _uiState.update { it.copy(isLoading = true) }

        viewModelScope.launch {
            kotlinx.coroutines.delay(1000)
            _uiState.update { it.copy(isLoading = false) }
        }
    }

    private fun validateForm(showErrors: Boolean = false) {
        val result: ValidationResult<SignUpFormState> = validateSignUpForm(_uiState.value)
        val isValid = result.errors.isEmpty()

        if (showErrors || isValid) {
            _uiState.update {
                it.copy(
                    isFormValid = isValid,
                    emailError = result.errors.find { e -> e.dataPath == ".email" }?.message,
                    displayNameError = result.errors.find { e -> e.dataPath == ".displayName" }?.message,
                    passwordError = result.errors.find { e -> e.dataPath == ".password" }?.message,
                    confirmPasswordError = result.errors.find { e -> e.dataPath == ".confirmPassword" }?.message
                )
            }
        } else {
            _uiState.update { it.copy(isFormValid = isValid) }
        }
    }


}