package Pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class OkMessengerPage {
    private static final SelenideElement dialogsList = $(byClassName("content"));
    private static final ElementsCollection dialogs = $$("msg-chats-list-item");
    private static final ElementsCollection messages = $$("msg-message");
    private static final SelenideElement input = $(byAttribute("data-tsid", "write_msg_input-input"));

    public OkMessengerPage() {
        check();
    }

    private void check() {
        dialogsList.should(Condition.exist);
    }

    public void findDialogsByName(String name){
        dialogs.findBy(Condition.text(name)).should(Condition.exist);
    }

    public void clickToDialogByName(String name){
        dialogs.findBy(Condition.text(name)).find("a").click();
    }

    public void sendMessage(String message){
        input.val(message).pressEnter();
    }

    public void checkMessage(String message){
        messages.findBy(Condition.text(message)).should(Condition.exist);
    }
}
