package com.luizvicari.moodtracker.util.validators

import io.konform.validation.ValidationBuilder
import io.konform.validation.constraints.minLength

fun ValidationBuilder<String>.isStrongPassword(uppercaseErrorMessage: String, lowercaseErrorMessage: String, numberErrorMessage: String) {
    minLength(8)
    constrain(uppercaseErrorMessage) {
        it.any{char -> char.isUpperCase()}
    }
    constrain(lowercaseErrorMessage) {
        it.any{char -> char.isLowerCase()}
    }
    constrain(numberErrorMessage){
        it.any{char -> char.isDigit()}
    }
}