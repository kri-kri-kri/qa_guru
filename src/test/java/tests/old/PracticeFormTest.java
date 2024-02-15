package tests.old;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import pages.components.ResultComponent;

public class PracticeFormTest extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    ResultComponent resultComponent = new ResultComponent();
    TestData data = new TestData();

    @Test
    void fillFormTest() {

        registrationPage
                .openPage()
                .setFirstName(data.firstName)
                .setLastName(data.lastName)
                .setEmailInput(data.email)
                .setGender(data.gender)
                .setUserNumber(data.phone)
                .setBirthDate(data.month, data.day, data.year)
                .setSubject(data.subject)
                .setHobbies(data.hobby)
                .uploadFile(data.picture)
                .enterAddress(data.address)
                .enterState(data.state)
                .enterCity(data.city)
                .submitForm();

        resultComponent
                .checkResult("Student Name", String.format("%s %s", data.firstName, data.lastName))
                .checkResult("Student Email", data.email)
                .checkResult("Gender", data.gender)
                .checkResult("Mobile", data.phone)
                .checkResult("Date of Birth", String.format("%s %s,%s", data.day, data.month, data.year))
                .checkResult("Subjects", data.subject)
                .checkResult("Hobbies", data.hobby)
                .checkResult("Picture", data.picture)
                .checkResult("Address", data.address)
                .checkResult("State and City", String.format("%s %s", data.state, data.city));
    }

    @Test
    void fillFormWithRequiredFieldsTest() {

        registrationPage.openPage()
                .setFirstName(data.firstName)
                .setLastName(data.lastName)
                .setUserNumber(data.phone)
                .setGender(data.gender)
                .setBirthDate(data.month, data.day, data.year)
                .submitForm();

        resultComponent
                .checkResult("Student Name", String.format("%s %s", data.firstName, data.lastName))
                .checkResult("Gender", data.gender)
                .checkResult("Mobile", data.phone)
                .checkResult("Date of Birth", String.format("%s %s,%s", data.day, data.month, data.year));
    }

    @Test
    void invalidEmailTest() {
        registrationPage.openPage()
                .setFirstName(data.firstName)
                .setLastName(data.lastName)
                .setEmailInput("invalid")
                .setGender(data.gender)
                .setUserNumber(data.phone)
                .setBirthDate(data.month, data.day, data.year)
                .submitForm()
                .checkInvalidEmail();
    }
}