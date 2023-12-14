package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import pages.components.ResultComponent;

public class PracticeFormTest extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    ResultComponent resultComponent = new ResultComponent();

    @Test
    void fillFormTest() {

        registrationPage
                .openPage()
                .setFirstName("Ivan")
                .setLastName("Ivanov")
                .setEmailInput("ivan@mai.ru")
                .setGender("Male")
                .setUserNumber("7917111111")
                .setBirthDate("December", "9", "2003")
                .setSubject("Chemistry")
                .setSubject("Maths")
                .setHobbies("Reading")
                .setHobbies("Music")
                .uploadFile("image.jpg")
                .enterAddress("Beverly Hills, 90210")
                .enterState("NCR")
                .enterCity("Delhi")
                .submitForm();

        resultComponent
                .checkResult("Student Name", "Ivan Ivanov")
                .checkResult("Student Email", "ivan@mai.ru")
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "7917111111")
                .checkResult("Date of Birth", "09 December,2003")
                .checkResult("Subjects", "Chemistry, Maths")
                .checkResult("Hobbies", "Reading, Music")
                .checkResult("Picture", "image.jpg")
                .checkResult("Address", "Beverly Hills, 90210")
                .checkResult("State and City", "NCR Delhi");
    }

    @Test
    void fillFormWithRequiredFieldsTest() {

        registrationPage.openPage()
                .setFirstName("Ivan")
                .setLastName("Ivanov")
                .setUserNumber("7917111111")
                .setGender("Male")
                .setBirthDate("December","9","2003")
                .submitForm();

        resultComponent.checkResult("Student Name", "Ivan Ivanov")
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "7917111111")
                .checkResult("Date of Birth", "09 December,2003");
    }

    @Test
    void invalidEmailTest() {
        registrationPage.openPage()
                .setFirstName("Ivan")
                .setLastName("Ivanov")
                .setEmailInput("abobus")
                .setUserNumber("79171111111")
                .setGender("Male")
                .setBirthDate("December","9","2003")
                .submitForm()
                .checkInvalidEmail();
    }
}