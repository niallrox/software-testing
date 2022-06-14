import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.awaitility.Awaitility.with;

public interface PageTest {

    default void waitVisibleElement(WebElement we) {
        with().pollInSameThread().pollDelay(10, TimeUnit.MILLISECONDS).await().atMost
                (20, SECONDS).until(we::isDisplayed);
    }

    default Stream<String> browsers() {
        return Stream.of("firefox", "chrome");
    }
}
