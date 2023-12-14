package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {

    private SelenideElement
            birthMonth = $(".react-datepicker__month-select"),
            birthYear =  $(".react-datepicker__year-select"),
            birthDay = $(".react-datepicker__month");

    public void setDate(String month, String day, String year){
        birthMonth.selectOption(month);
        birthYear.selectOption(year);
        birthDay.$(byText(day)).click();
    }

}
