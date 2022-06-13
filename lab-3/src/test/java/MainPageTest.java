import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainPageTest implements PageTest{
    private final MainPage mainPage = new MainPage();


    @ParameterizedTest
    @ValueSource(strings = {"firefox", "chrome"})
    public void checkGoodInvestigation(String browserName) {
        setUp(browserName);
        mainPage.investigation.click();
        var selenideElement = $x("/html/body/div[4]/main/div[1]/div/div[4]/div/div/div/div[1]/div[1]/div/div");
        waitVisibleElement(selenideElement);
        assertTrue(selenideElement.exists());
    }

    @ParameterizedTest
    @ValueSource(strings = {"firefox", "chrome"})
    public void checkNews(String browserName) {
        setUp(browserName);
        $x("/html/body/div[1]/div/div/span/button").click();
        mainPage.news.click();
        var selenideElement = $x("/html/body/div[4]/main/div[1]/div[1]/h1");
        waitVisibleElement(selenideElement);
        assertTrue(selenideElement.exists());
    }

    private void setUp(String browserName) {
        Configuration.browser = browserName;
        open("https://www.banki.ru/");
    }

    @AfterEach
    public void tearDown() {
        closeWindow();
    }
}
