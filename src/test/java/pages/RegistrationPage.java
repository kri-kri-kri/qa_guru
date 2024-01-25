package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;


import static com.codeborne.selenide.Condition.cssValue;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static utils.DataUtils.*;

public class RegistrationPage {

    private final SelenideElement

            pageTitle = $(".practice-form-wrapper"),
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            genderWrapper = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            dateOfBirthInput = $("#dateOfBirthInput"),
            subjectInput = $("#subjectsInput"),
            inputState = $("#state"),
            inputCity = $("#city"),
            buttonSubmit = $("#submit"),
            inputAddress = $("#currentAddress"),
            uploadPicture = $("#uploadPicture"),
            cityStatePicker = $("#stateCity-wrapper");

    CalendarComponent calendarComponent = new CalendarComponent();

    public RegistrationPage openPage() {
        open(baseUrl.concat("/automation-practice-form"));
        pageTitle.shouldHave(text("Student Registration Form"));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public RegistrationPage setFirstName() {
        firstNameInput.setValue(getFirstName());
        return this;
    }

    public RegistrationPage setFirstName(String value) { // если хотим загнать что-то не из faker
        firstNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setLastName() {
        lastNameInput.setValue(getLastName());
        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setEmailInput() {
        emailInput.setValue(getEmail());
        return this;
    }

    public RegistrationPage setEmailInput(String value) {
        emailInput.setValue(value);
        return this;
    }

    public RegistrationPage setGender(String value) {
        genderWrapper.$(byText(value)).click();
        return this;
    }

    public RegistrationPage setUserNumber() {
        userNumberInput.setValue(getUserNumber());
        return this;
    }

    public RegistrationPage setUserNumber(String value) {
        userNumberInput.setValue(value);
        return this;
    }

    public RegistrationPage setBirthDate(String month, String day, String year) {
        dateOfBirthInput.click();
        calendarComponent.setDate(month, day, year);
        return this;
    }

    public RegistrationPage setSubject(String value) {
        subjectInput.val(value).pressEnter();
        return this;
    }

    public RegistrationPage setHobbies(String value) {
        $(byText(value)).click();
        return this;
    }

    public RegistrationPage enterAddress(String value) {
        inputAddress.sendKeys(value);
        return this;
    }

    public RegistrationPage uploadFile(String picture) {
        uploadPicture.uploadFromClasspath(picture);
        return this;
    }

    public RegistrationPage enterState(String value) {
        inputState.click();
        cityStatePicker.$(byText(value)).click();
        return this;
    }

    public RegistrationPage enterCity(String value) {
        inputCity.click();
        cityStatePicker.$(byText(value)).click();
        return this;
    }

    public RegistrationPage submitForm() {
        buttonSubmit.click();
        return this;
    }

    public void checkInvalidEmail() {
        emailInput.shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
    }

}