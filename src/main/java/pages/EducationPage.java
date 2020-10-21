package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.Driver;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EducationPage {
    private static final By EDUCATIONHEADER_LOCATOR = By.xpath("//div[@class='wiley-slogan']//span[text()='Education']");
    private static final By LEFTSIDEPANEL_LOCATOR = By.xpath("//div[@class='side-panel']");
    private static final By LEFTSIDE_ITEMS_LOCAROR = By.xpath("//div[@class='side-panel']//li//a");

    public void educationHeaderISDisplayed() {
        getHeaderEducation().isDisplayed();
    }

    public void compareTitlesElementsInLeftSidePanel(int sortNumber, String text) {
        String t = getSidePanelElements().get(sortNumber).getText().toLowerCase();
        assertEquals(t, text.toLowerCase());
    }

    public void checkCountAndDisplayElementsInLeftSidePanel(int expectedCount) {
        int i = 0;
        for (WebElement webElement : getSidePanelElements()) {

            if (webElement.isDisplayed()) {
                i++;
            }
            assertEquals(i, expectedCount);
        }
    }

    private WebElement getHeaderEducation() {
        return Driver.getWebDriver().findElement(EDUCATIONHEADER_LOCATOR);
    }

    private WebElement getSidePanel() {
        return Driver.getWebDriver().findElement(LEFTSIDEPANEL_LOCATOR);
    }

    private List<WebElement> getSidePanelElements() {
        return getSidePanel().findElements(LEFTSIDE_ITEMS_LOCAROR);
    }
}
