import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;

import Templates.OkLogin;

import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class OkMessengerTests extends OkLogin {
    private static final ElementsCollection dialogs = $(byClassName("custom-scrollbar")).findAll("msg-chats-list-item");

    @BeforeAll
    public static void init(){
        loginIn();
    }

    @Disabled
    @ParameterizedTest
    @Tag("Messenger")
    @DisplayName("Find dialogs with persons")
    @ValueSource(strings = {"Алексей Ивакин", "Сервисные уведомления"} )
    public void checkDialogsWith(String person) {
        open("https://ok.ru/messages");
        dialogs.findBy(Condition.text(person)).should(Condition.exist);
    }


    @Disabled
    @Test
    @Tag("Messenger")
    public void sendMessage() {
        open("https://ok.ru/messages");
        dialogs.findBy(Condition.text("Алексей Ивакин")).find("a").click();
        $("msg-input").setValue("sada").pressEnter();
    }

}
