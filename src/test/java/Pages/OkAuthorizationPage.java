package Pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class OkAuthorizationPage {
    private static final SelenideElement emailField = $(byName("st.email"));
    private static final SelenideElement passwordField = $(byName("st.password"));

    private static final SelenideElement loginError = $(byClassName("form_i__error"));

    public void loginIn(String email, String password){
        emailField.val(email);
        passwordField.setValue(password).pressEnter();
    }


    public void checkLoginError() {
        loginError.should(Condition.exist);
        loginError.shouldBe(Condition.visible);
    }
}
