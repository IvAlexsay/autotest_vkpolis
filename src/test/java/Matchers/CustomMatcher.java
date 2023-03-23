package Matchers;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

public class CustomMatcher extends TypeSafeMatcher<String> {
    String start;

    public CustomMatcher(String start){
        this.start = start;
    }

    @Override
    protected boolean matchesSafely(String s) {
        return s.startsWith(start);
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("this string start with " + start);
    }

    public static CustomMatcher startWith(String start){
        return new CustomMatcher(start);
    }
}
