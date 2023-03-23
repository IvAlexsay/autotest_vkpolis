package Templates;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import Pages.OkAuthorizationPage;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.setWebDriver;

public class OkLogin {
    protected static final String email = "botS23AT11";
    protected static final String password = "autotests2023";

    @BeforeAll
    public static void openOk(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver_win32/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setBinary("C:\\Users\\roman\\AppData\\Local\\Yandex\\YandexBrowser\\Application\\browser.exe");
        WebDriver driver = new ChromeDriver(options);
        setWebDriver(driver);
        open("https://ok.ru/");
    }
    public static void loginIn(){
        OkAuthorizationPage authorizationPage = new OkAuthorizationPage();
        authorizationPage.loginIn(email, password);
    }

    @AfterAll
    public static void closeDriver(){
        closeWebDriver();
    }
}
