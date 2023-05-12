package com.example.misw4203moviles2023.TestUtils

import androidx.appcompat.widget.Toolbar
import androidx.test.espresso.Espresso
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.IdlingResource
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.BoundedMatcher
import androidx.test.espresso.matcher.ViewMatchers
import org.hamcrest.CoreMatchers
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.junit.rules.TestRule
import org.junit.runners.model.Statement
import java.util.concurrent.atomic.AtomicBoolean

fun matchToolbarTitle(
    title: CharSequence
): ViewInteraction? {
    return Espresso.onView(ViewMatchers.isAssignableFrom(Toolbar::class.java))
        .check(ViewAssertions.matches(withToolbarTitle(CoreMatchers.`is`(title))))
}

private fun withToolbarTitle(
    textMatcher: Matcher<CharSequence>
): Matcher<Any?>? {
    return object : BoundedMatcher<Any?, Toolbar>(Toolbar::class.java) {
        override fun matchesSafely(toolbar: Toolbar): Boolean {
            return textMatcher.matches(toolbar.title)
        }

        override fun describeTo(description: Description) {
            description.appendText("with toolbar title: ")
            textMatcher.describeTo(description)
        }
    }
}

