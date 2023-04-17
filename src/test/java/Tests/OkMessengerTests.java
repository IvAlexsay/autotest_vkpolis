package Tests;

import java.util.concurrent.ThreadLocalRandom;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.hamcrest.MatcherAssert.assertThat;

import Pages.OkAuthorizationPage;
import Pages.OkMessengerPage;

public class OkMessengerTests extends BaseTest {

    @BeforeEach
    public void init(){
        OkAuthorizationPage authorizationPage = new OkAuthorizationPage();
        authorizationPage.loginIn(email, password);
    }

    @ParameterizedTest
    @Tag("Messenger")
    @DisplayName("Find dialogs with persons")
    @ValueSource(strings = {"Алексей Ивакин", "Сервисные уведомления"} )
    public void checkDialogsWith(String name) {
        openMessages();
        OkMessengerPage messengerPage = new OkMessengerPage();
        messengerPage.findDialogsByName(name);
    }


    @Test
    @Tag("Messenger")
    @DisplayName("Send message")
    public void sendMessage() {
        openMessages();
        OkMessengerPage messengerPage = new OkMessengerPage();
        messengerPage.clickToDialogByName("Алексей Ивакин");
        String message = "text" + ThreadLocalRandom.current().nextInt();
        messengerPage.sendMessage(message);
        messengerPage.checkMessage(message);
    }

}
