import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProfilePageTest implements PageTest {
    private static String mail;
    private static String password;
    private final ProfilePage mainPage = new ProfilePage();

    @BeforeAll
    public static void loadConfig() throws IOException {
        var path = Objects
                .requireNonNull(Thread.currentThread().getContextClassLoader().getResource("test.properties"))
                .getPath();
        var appProps = new Properties();
        appProps.load(new FileInputStream(path));
        mail = appProps.getProperty("mail");
        password = appProps.getProperty("password");
    }

    @ParameterizedTest
    @ValueSource(strings = {"firefox", "chrome"})
    public void calculationTest(String browserName) {
        setUp(browserName);
        $x("//*[@id=\"root\"]/div/div/div[2]/div/div/div/nav/ul/li[2]/a").click();
        var credits = $x("//*[@id=\"root\"]/div/div/div[2]/div/div/div/div/div[2]/div/ul/li[1]/div").getText();
        assertEquals("Кредиты", credits);
    }

    @ParameterizedTest
    @ValueSource(strings = {"firefox", "chrome"})
    public void profileTest(String browserName) {
        setUp(browserName);
        $x("//*[@id=\"root\"]/div/div/div[2]/div/div/div/nav/ul/li[7]/a").click();
        $x("//*[@id=\"root\"]/div/div/div[2]/div/div/div/div/div[2]/div/ul/li[1]").click();
        SelenideElement selenideElement = $x("//*[@id=\"root\"]/div/div/div[2]/div/div/div/div/div[2]/div/form/div[3]/div/div[2]");
        waitVisibleElement(selenideElement);
        var mailDiv = selenideElement.getText();
        assertEquals(mail, mailDiv);
    }

    public void setUp(String browserName) {
        Configuration.browser = browserName;
        open("https://www.banki.ru/");
        $x("/html/body/div[1]/div/div/span/button").click();
        mainPage.profileButtonDisabled.click();
        $x("/html/body/div[6]/div/div/div/div/div[2]/div/span/span/div").click();
        $x("/html/body/div[6]/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/input").sendKeys(mail);
        $x("/html/body/div[6]/div/div/div/div/div[2]/div/div[1]/div/div[2]/div/div/input").sendKeys(password);
        $x("/html/body/div[6]/div/div/div/div/div[2]/div/div[1]/button").click();
        mainPage.profileButtonEnabled.click();
        mainPage.profilePage.click();
    }

    @AfterEach
    public void tearDown() {
        closeWindow();
    }
}
