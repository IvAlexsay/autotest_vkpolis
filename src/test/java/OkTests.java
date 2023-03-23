import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import com.codeborne.selenide.Condition;

import Pages.OkAuthorizationPage;
import Pages.OkMainPage;
import Templates.OkLogin;

public class OkTests extends OkLogin {
    @Test
    @Tag("Authorization")
    @DisplayName("User failed authorization test")
    public void userFailedAuthorization() {
        OkAuthorizationPage page = new OkAuthorizationPage();
        page.loginIn("admin", "admin");

        page.checkLoginError();
    }

    @Test
    @Tag("Authorization")
    @DisplayName("User successful authorization test")
    public void userAuthorization(){
        OkAuthorizationPage page = new OkAuthorizationPage();
        page.loginIn(email, password);

        OkMainPage mainPage = new OkMainPage();
        mainPage.getName().shouldHave(Condition.exactText("botS23AT11 botS23AT11"));
    }

    @Test
    @Tag("Rick")
    public void openVideoRick(){
        OkVideoRick video = new OkVideoRick();
        video.load();
        video.isLoaded();
        video.isDisplayExist();
        video.checkName();
    }
}
