import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class OkAuthorizationPage {
    private SelenideElement emailField = $(byName("st.email"));
    private SelenideElement passwordField = $(byName("st.password"));

    public void loginIn(String email, String password){
        emailField.val(email);
        passwordField.setValue(password).pressEnter();
    }

}
