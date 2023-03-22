package Pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selectors.*;

public class OkMainPage {
    private static final ElementsCollection navigationElements = $(byClassName("__user-main")).findAll(byClassName("nav-side_i-w"));

    public SelenideElement getName() {
        return navigationElements.get(0);
    }
}
