package tests.old;

import org.junit.jupiter.api.Test;
import pages.TextBoxPage;

public class TestBoxTest extends TestBase {

    TextBoxPage textBoxPage = new TextBoxPage();

    @Test
    void testBoxTest() {
        textBoxPage
                .openPage()
                .setUserName("Ivan")
                .setUserEmail("ivan@mai.ru")
                .setCurrentAddress("Beverly Hills, 90210")
                .setPermanentAddress("Twin Peaks")
                .submitForm()
                .checkResult("Ivan", "ivan@mai.ru", "Beverly Hills, 90210", "Twin Peaks");
    }
}
