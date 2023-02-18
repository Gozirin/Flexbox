
package com.google.android.flexbox.test

import org.hamcrest.BaseMatcher
import org.hamcrest.Description
import org.hamcrest.Factory
import org.hamcrest.Matcher
import java.util.*

/**
 * Custom [BaseMatcher] that expects [Number] value allowing some errors to allow
 * such as rounding errors.
 */
class IsEqualAllowingError<T : Number> private constructor(private val expected: Number, private val errorAllowed: Int) : BaseMatcher<T>() {

    override fun matches(item: Any): Boolean {
        if (item !is Number) {
            return false
        }
        return expected.toInt() - errorAllowed <= item.toInt() && item.toInt() <= expected.toInt() + errorAllowed
    }

    override fun describeTo(description: Description) {
        description.appendText(
                String.format(Locale.US, "expected value is <%s> allowing error of <%s>.", expected,
                        errorAllowed))
    }

    companion object {

        @Factory
        fun <T : Number> isEqualAllowingError(expected: T): Matcher<T> {
            return IsEqualAllowingError(expected, 2)
        }
    }
}
