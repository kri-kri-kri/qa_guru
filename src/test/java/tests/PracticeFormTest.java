package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import pages.components.ResultComponent;

import static utils.DataUtils.*;

public class PracticeFormTest extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    ResultComponent resultComponent = new ResultComponent();

    @Test
    void fillFormTest() {

        registrationPage
                .openPage()
                .setFirstName()
                .setLastName()
                .setEmailInput()
                .setGender("Male")
                .setUserNumber()
                .setBirthDate(getMonth(), getDay(), getYear())
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
//                .checkResult("Student Name", getFirstName() + ' ' + getLastName())
                .checkResult("Student Name", String.format("%s %s", getFirstName(), getLastName()))
                .checkResult("Student Email", getEmail())
                .checkResult("Gender", "Male")
                .checkResult("Mobile", getUserNumber())
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
                .setFirstName()
                .setLastName()
                .setUserNumber()
                .setGender("Male")
                .setBirthDate(getMonth(), getDay(), getYear())
                .submitForm();

        resultComponent.checkResult("Student Name", "Ivan Ivanov")
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "7917111111")
                .checkResult("Date of Birth", "09 December,2003");
    }

    @Test
    void invalidEmailTest() {
        registrationPage.openPage()
                .setFirstName()
                .setLastName()
                .setEmailInput("invalid")
                .setUserNumber()
                .setGender("Male")
                .setBirthDate(getMonth(), getDay(), getYear())
                .submitForm()
                .checkInvalidEmail();
    }
}