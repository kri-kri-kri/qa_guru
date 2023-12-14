package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ResultComponent {

    private SelenideElement resultForm = $("tbody");

    public ResultComponent checkResult(String key, String value) {
        resultForm.$(byText(key)).parent().shouldHave(text(value));
        return this;
    }
}