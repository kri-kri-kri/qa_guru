import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class FormTests {
    @BeforeEach
    public void init(){
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void successfulSearchTest() {
        open("/automation-practice-form");
        $("#firstName").setValue("Ivan");
        $("#lastName").setValue("Ivanov");
        $("#userEmail").setValue("ivan@mai.ru");
        $("#gender-radio-3~label").click();
        $("#userNumber").setValue("7917111111");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").click();
        $("[value='11']").click();
        $(".react-datepicker__year-select").click();
        $("[value='2003']").click();
        $(".react-datepicker__day.react-datepicker__day--009").click();
        $("#subjectsInput").setValue("chem").pressEnter();
        $("#subjectsInput").setValue("mat").pressEnter();
        $("#hobbies-checkbox-2~label").click();
        $("#hobbies-checkbox-3~label").click();
        $("#uploadPicture").scrollIntoView(true).uploadFromClasspath("image.jpg");;
        $("#currentAddress").setValue("Beverly Hills, 90210");
        $("#state").click();
        $("#react-select-3-option-0").scrollIntoView(true).click();
        $("#city").click();
        $("#react-select-4-option-0").click();
        $("#submit").click();
        //проверки на успешность
        $(".modal-title.h4").shouldHave(text("Thanks for submitting the form"));
        $(byXpath("//td[contains(text(),'Student Name')]/following-sibling::*")).shouldHave(text("Ivan Ivanov"));
        $(byXpath("//td[contains(text(),'Student Email')]/following-sibling::*")).shouldHave(text("ivan@mai.ru"));
        $(byXpath("//td[contains(text(),'Gender')]/following-sibling::*")).shouldHave(text("Other"));
        $(byXpath("//td[contains(text(),'Mobile')]/following-sibling::*")).shouldHave(text("7917111111"));
        $(byXpath("//td[contains(text(),'Date of Birth')]/following-sibling::*")).shouldHave(text("09 December,2003"));
        $(byXpath("//td[contains(text(),'Subjects')]/following-sibling::*")).shouldHave(text("Chemistry, Maths"));
        $(byXpath("//td[contains(text(),'Hobbies')]/following-sibling::*")).shouldHave(text("Reading, Music"));
        $(byXpath("//td[contains(text(),'Picture')]/following-sibling::*")).shouldHave(text("image.jpg"));
        $(byXpath("//td[contains(text(),'Address')]/following-sibling::*")).shouldHave(text("Beverly Hills, 90210"));
        $(byXpath("//td[contains(text(),'State and City')]/following-sibling::*")).shouldHave(text("NCR Delhi"));
        $("#closeLargeModal").shouldBe(visible);
    }
}