package tests.hw10;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import tests.data.Language;

import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.*;

public class DataProvidersLearningTest {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        baseUrl = "https://vk.com/";
        Configuration.pageLoadStrategy = "eager";
    }

    static Stream<Arguments>vkComShouldDisplayCorrectButtons() {
        return Stream.of(
                Arguments.of(
                        Language.Русский,
                        List.of("О ВКонтакте", "Правила", "Для бизнеса", "Разработчикам")
                ),
                Arguments.of(
                        Language.English,
                        List.of("About VK", "Terms", "Developers")
                )
        );
    }
    @MethodSource
    @ParameterizedTest
    @Tag("Accessibility")
    @DisplayName("Для выбранного языка должны отображаться корректные кнопки")
    void vkComShouldDisplayCorrectButtons(Language language, List <String> expectedButtons) {
        open(baseUrl);
        $$(".footer_lang a").find(text(language.name())).click();
        $$(".footer_links a").filter(visible).shouldHave(texts(expectedButtons));
    }

    @CsvSource(value = {
            "English , .language_name_hl",
            "Английский , .language_title"
    })
    @Tag("Accessibility")
    @DisplayName("Поле выбора языков должно допускать поиск названий языков на разных языках")
    @ParameterizedTest
    void vkComShouldAllowSearchingForLanguagesInDifferentLanguages(String languageName, String highlightedClass) {
        open(baseUrl);
        $$(".footer_lang a").find(partialText("все языки")).click();
        $("#language_search_form").setValue(languageName);
        $(highlightedClass).shouldHave(text("English"));
    }

    @ValueSource(strings = {
            "Русский", "English", "Français"
    })
    @Tag("Accessibility")
    @DisplayName("Поле выбора языков должно допускать поиск разных языков")
    @ParameterizedTest
    void vkComShouldAllowSearchingForDifferentLanguages(String languageName) {
        open(baseUrl);
        $$(".footer_lang a").find(partialText("все языки")).click();
        $("#language_search_form").setValue(languageName);
        $(".language_name_hl").shouldHave(text(languageName));
    }
}
