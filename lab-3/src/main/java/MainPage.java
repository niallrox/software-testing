import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage {
    public SelenideElement investigation = $x("/html/body/div[4]/header/div/div/div/div[2]/nav/ul/li[6]/div/a");
    public SelenideElement news = $x("/html/body/div[4]/header/div/div/div/div[2]/nav/ul/li[8]/div/a");
}
