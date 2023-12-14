package tests.old;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selenide.*;

public class SearchTest {
    @BeforeAll
    static void beforeAll() {
        baseUrl = "https://github.com/";
        Configuration.browserSize = "1920x1080";
    }
    @Test
    void searchExampleCodeForJunit5(){
        open(baseUrl);
        $(".search-input").click();
        $("#query-builder-test").setValue("Selenide").pressEnter();
        $("[data-testid='results-list']").$("span").click();
        $("#wiki-tab").click();
        $("#wiki-pages-filter").setValue("SoftAssertions").pressEnter();
        $("[data-filterable-for='wiki-pages-filter']").shouldHave(text("SoftAssertions"));
        $(byTagAndText("a","SoftAssertions")).click();
        String exampleCode = """
                @ExtendWith({SoftAssertsExtension.class})
                class Tests {
                  @Test
                  void test() {
                    Configuration.assertionMode = SOFT;
                    open("page.html");
                                
                    $("#first").should(visible).click();
                    $("#second").should(visible).click();
                  }
                }
                """;
        $(".markdown-body").shouldHave(text("Using JUnit5 extend test class")).shouldHave(text(exampleCode));
    }
}
