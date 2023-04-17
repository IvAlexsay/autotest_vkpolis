package Tests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class OkLoadVideoTests extends BaseTest {
    @Test
    @Tag("Rick")
    public void openVideoRick() {
        OkVideoRick video = new OkVideoRick();
        video.load();
        video.isLoaded();
        video.isDisplayExist();
        video.checkName();
    }
}
