package base;

import constants.UrlConstants;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import utils.Driver;

public class BaseTest {
    @BeforeEach
    public void setup() {
        Driver.initWebDriver();
        Driver.getWebDriver().get(UrlConstants.WEB_APP_BASE_URL);
    }

    @AfterEach
    public void quit() {
        Driver.getWebDriver().quit();
    }
}
