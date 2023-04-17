package Tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalToIgnoringWhiteSpace;

import Pages.OkAuthorizationPage;
import Pages.OkMainPage;

public class OkAuthorizationTests extends BaseTest {
    @Test
    @Tag("Authorization")
    @DisplayName("User failed authorization test")
    public void userFailedAuthorization() {
        OkAuthorizationPage page = new OkAuthorizationPage();
        page.loginIn("admin", "admin");

        page.checkLoginError();
        String textError = "Неправильно указан логин и/или пароль";
        assertThat(page.getTextError(), equalToIgnoringWhiteSpace(textError));
    }

    @Test
    @Tag("Authorization")
    @DisplayName("User successful authorization test")
    public void userAuthorization() {
        OkAuthorizationPage page = new OkAuthorizationPage();
        page.loginIn(email, password);

        OkMainPage mainPage = new OkMainPage();
        String name = "botS23AT11 botS23AT11";
        assertThat(mainPage.getName(), equalToIgnoringWhiteSpace(name));
    }
}
