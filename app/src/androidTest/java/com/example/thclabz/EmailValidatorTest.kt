package com.example.thclabz

import android.util.Patterns
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class EmailValidatorTest {

    // A simple helper function to validate email format
    fun isValidEmail(email: String): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    @Test
    fun testValidEmail_ReturnsTrue() {
        val email = "testuser1@thclabz.co.za"
        assertTrue(isValidEmail(email))
    }

    @Test
    fun testInvalidEmail_ReturnsFalse() {
        val email = "invalid-email"
        assertFalse(isValidEmail(email))
    }
}
