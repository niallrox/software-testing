import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class MainPageTest implements PageTest{
    private final MainPage mainPage = new MainPage();


    /**
     * Сценарий 1 - пользователь хочет получить информацию об инвестициях<br>
     * 1.Пользователь выбирает в главном меню вкладку инвестиции<br>
     * 2.Пользователь выбирает вкладку "С чего начать"<br>
     * 3.Пользователь ждет прогрузки меню и видит информацию об инвестициях
     *
     * @param browserName название браузера
     */
    @ParameterizedTest
    @MethodSource("browsers")
    public void checkGoodInvestigation(String browserName) {
        setUp(browserName);
        mainPage.investigation.click();
        var selenideElement = $x("/html/body/div[4]/main/div[1]/div/div[4]/div/div/div/div[1]/div[1]/div/div");
        waitVisibleElement(selenideElement);
        assertTrue(selenideElement.exists());
    }

    /**
     * Сценарий 2 - пользователь хочет узнать свежую новость<br>
     * 1.Пользователь выбирает в главном меню вкладку новости<br>
     * 2.Пользователь ждет прогрузки меню и первой выплывающей новости и видит саму новость
     *
     * @param browserName название браузера
     */
    @ParameterizedTest
    @MethodSource("browsers")
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
