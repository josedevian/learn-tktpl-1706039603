package id.ac.ui.cs.mobileprogramming.activity1;

import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

public class MainActivityInstrumentedTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<MainActivity>(MainActivity.class);

    private MainActivity mActivity = mActivityTestRule.getActivity();


    @Test
    public void testVisibilityOfTextOnButtonClick() throws Exception {
        onView(withId(R.id.button)).perform(click());

        onView(withId(R.id.text)).check(matches(isDisplayed()));
    }
}