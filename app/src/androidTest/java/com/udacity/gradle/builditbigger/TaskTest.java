package com.udacity.gradle.builditbigger;

import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import xyz.cybersapien.jokeviewer.JokeViewer;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.ComponentNameMatchers.hasClassName;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasExtra;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;

/**
 * Created by ogcybersapien on 27/12/17.
 */
@RunWith(AndroidJUnit4.class)
public class TaskTest {

    @Rule
    public IntentsTestRule<MainActivity> intentsTestRule = new IntentsTestRule<>(MainActivity.class);

    @Test
    public void jokeTaskTest() {
        // Perform a click on the joke button
        onView(withId(R.id.joke_button)).perform(click());

        intended(hasComponent(hasClassName(JokeViewer.class.getName())));
        intended(hasExtra(equalTo(JokeViewer.JOKE_MESSAGE), notNullValue()));
    }
}
