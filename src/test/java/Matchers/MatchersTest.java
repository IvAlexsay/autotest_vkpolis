package Matchers;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.codeborne.selenide.ElementsCollection;

import Pages.OkAuthorizationPage;
import Pages.OkMainPage;
import Tests.BaseTest;

import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.equalToCompressingWhiteSpace;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.not;

public class MatchersTest extends BaseTest {

    @BeforeAll
    public static void init() {
        OkAuthorizationPage page = new OkAuthorizationPage();
        page.loginIn(email, password);
    }

    @Test
    public void checkName() {
        String name = "botS23AT11     botS23AT11";
        OkMainPage mainPage = new OkMainPage();
        String curName = mainPage.getName();
        assertThat(curName, equalToCompressingWhiteSpace(name));
    }

    @Test
    public void checkNameStartWith() {
        OkMainPage mainPage = new OkMainPage();
        String curName = mainPage.getName();
        assertThat(curName, CustomMatcher.startWith("bot"));
    }

    @Test
    public void checkCountChats(){
        open("https://ok.ru/messages");
        ElementsCollection dialogs = $(byClassName("custom-scrollbar")).findAll("msg-chats-list-item");
        assertThat(dialogs, not(empty()));
        assertThat(dialogs.size(), greaterThan(2));
    }


}
