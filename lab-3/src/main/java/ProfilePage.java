import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class ProfilePage {
    public SelenideElement profileButtonDisabled = $x("/html/body/div[4]/header/div/div/div/div[4]/div/div/a/span");
    public SelenideElement profileButtonEnabled = $x("/html/body/div[4]/header/div/div/div/div[4]/div/div/div/span");
    public SelenideElement profilePage = $x("/html/body/div[4]/header/div/div/div/div[4]/div/div/div/div/div/div/ul/li[1]/a");
}
