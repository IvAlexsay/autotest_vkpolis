package Pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selectors.*;

public class OkMainPage {
    private static final ElementsCollection navigationElements = $(byClassName("__user-main")).findAll(byClassName("nav-side_i-w"));
    private static final SelenideElement toolbar = $(byClassName("toolbar"));
    private static final SelenideElement navigation = $(byClassName("navigation"));
    private static final SelenideElement mainLayout = $(byClassName("layout-main"));

    public OkMainPage() {
        check();
    }

    public void check() {
        toolbar.should(Condition.exist);
        navigation.should(Condition.exist);
        mainLayout.should(Condition.exist);

    }

    public String getName() {
        return navigationElements.get(0).getText();
    }
}
