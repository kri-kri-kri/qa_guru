package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class TextBoxPage {

    private SelenideElement
            userName = $("#userName"),
            userEmail = $("#userEmail"),
            currentAddress = $("#currentAddress"),
            permanentAddress = $("#permanentAddress"),
            submitButton = $("#submit"),
            resultUserName = $("#output #name"),
            resultUserEmail = $("#output #email"),
            resultCurrentAddress = $("#output #currentAddress"),
            resultPermanentAddress = $("#output #permanentAddress");

    public TextBoxPage openPage() {
        open(baseUrl.concat("/text-box"));
        executeJavaScript("$('#fixedban').remove()");
        return this;
    }

    public TextBoxPage setUserName(String value) {
        userName.setValue(value);
        return this;
    }

    public TextBoxPage setUserEmail(String value) {
        userEmail.setValue(value);
        return this;
    }

    public TextBoxPage setCurrentAddress(String value) {
        currentAddress.setValue(value);
        return this;
    }

    public TextBoxPage setPermanentAddress(String value) {
        permanentAddress.setValue(value);
        return this;
    }

    public TextBoxPage submitForm( ) {
        submitButton.click();
        return this;
    }

    public TextBoxPage checkResult(String name, String email, String currentAddress, String permanentAddress) {
        resultUserName.shouldHave(Condition.text(name));
        resultUserEmail.shouldHave(Condition.text(email));
        resultCurrentAddress.shouldHave(Condition.text(currentAddress));
        resultPermanentAddress.shouldHave(Condition.text(permanentAddress));
        return this;
    }
}
