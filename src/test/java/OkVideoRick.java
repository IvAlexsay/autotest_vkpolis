import org.openqa.selenium.support.ui.LoadableComponent;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.url;

public class OkVideoRick extends LoadableComponent<OkVideoRick> {
    private static final SelenideElement display = $(byClassName("html5-vpl_vid_display"));
    private static final SelenideElement name = $(byClassName("vp-layer-info"));
    @Override
    protected void load() {
        open("https://ok.ru/video/1626140838623");
    }

    @Override
    protected void isLoaded() throws Error {
        webdriver().shouldHave(url("https://ok.ru/video/1626140838623"));
    }

    public void isDisplayExist(){
        display.should(Condition.exist);
        display.shouldBe(Condition.visible);
    }

    public void checkName(){
        name.shouldHave(Condition.text("Rick Astley - Never Gonna Give You Up"));
    }
}
