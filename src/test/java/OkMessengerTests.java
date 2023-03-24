import java.util.concurrent.ThreadLocalRandom;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import Templates.OkLogin;

import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;

public class OkMessengerTests extends OkLogin {
    private static final ElementsCollection dialogs = $$("msg-chats-list-item");
    private static final ElementsCollection messages = $$("msg-message");
    private static final SelenideElement input = $(byAttribute("data-tsid", "write_msg_input-input"));

    @BeforeAll
    public static void init(){
        loginIn();
    }

    @ParameterizedTest
    @Tag("Messenger")
    @DisplayName("Find dialogs with persons")
    @ValueSource(strings = {"Алексей Ивакин", "Сервисные уведомления"} )
    public void checkDialogsWith(String person) {
        open("https://ok.ru/messages");
        dialogs.findBy(Condition.text(person)).should(Condition.exist);
    }


    @Test
    @Tag("Messenger")
    @DisplayName("Send message")
    public void sendMessage() {
        open("https://ok.ru/messages");
        dialogs.findBy(Condition.text("Алексей Ивакин")).find("a").click();
        String message = "text" + ThreadLocalRandom.current().nextInt();
        input.val(message).pressEnter();
        messages.findBy(Condition.text(message)).should(Condition.exist);
    }

}
