package Pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class OkAuthorizationPage {
    private static final SelenideElement emailField = $(byName("st.email"));
    private static final SelenideElement passwordField = $(byName("st.password"));

    private static final SelenideElement loginError = $(byClassName("form_i__error"));

    private static final SelenideElement loginForm = $(byClassName("login-form-actions"));

    private static final SelenideElement textError = $(byClassName("login_error"));

    public OkAuthorizationPage() {
        check();
    }

    public void check(){
        emailField.should(Condition.exist);
        passwordField.should(Condition.exist);
        loginForm.should(Condition.exist);
    }

    public void loginIn(String email, String password) {
        emailField.val(email);
        passwordField.setValue(password).pressEnter();
    }

    public void checkLoginError() {
        loginError.should(Condition.exist);
        loginError.shouldBe(Condition.visible);
    }

    public String getTextError(){
        return textError.getText();
    }
}
