package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Driver;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainPage {
    private static final By CHANGE_LOCATION_LOCATOR = By.xpath("//*[@id='country-location-form']/div[3]/button[2]");
    private static final By SUB_HEADER_ELEMENTS_LOCATOR = By.xpath("//div[@class='row who-we-serve-blocks']//div//a");
    private static final By SEARCH_FIELD_LOCATOR = By.xpath("//div[@class='input-group']//input");
    private static final By CHECK_AREA_LOCATOR = By.xpath("//*[@id='main-header-container']//*[@id='ui-id-2']");
    private static final By SEARCH_HIGH_LIGHTED_ELEMENTS_LOCATOR = By.xpath("//*[@id='main-header-container']//*[@class='search-highlight']");
    private static final By SEARCH_BUTTON_LOCATOR = By.xpath("//button[text()='Search']");
    private static final By SUBJECT_HEADER_LOCATOR = By.xpath("//a[contains(text(), 'SUBJECTS')]");
    private static final By EDUCATION_SUBMENU_LOCATOR = By.xpath("//*[contains(@class, 'dropdown-item dropdown-submenu') and contains(.//a, 'Education')]");

    public void skipLocation() {
        WebDriverWait wait = new WebDriverWait(Driver.getWebDriver(), 10);
        wait.until(ExpectedConditions.visibilityOf(getChangeLocationElement()));
        getChangeLocationElement().click();
    }

    public void compareHowMuchElementsInSubHeader(int howShouldBe) {
        assertEquals(getSubHeaderElements().size(), howShouldBe);
    }

    public void compareTitlesInSubHeader(int sortingNumber, String title) {
        String t = getSubHeaderElements().get(sortingNumber).getAttribute("title");
        assertEquals(t, title);
    }

    public void textInSerachField(String text) {
        getSearchFieldElement().sendKeys(text);
    }

    public void checkAreaIsDisplayed() {
        WebDriverWait wait = new WebDriverWait(Driver.getWebDriver(), 10);
        wait.until(ExpectedConditions.visibilityOf(getCheckArea()));
        assertTrue(getCheckArea().isDisplayed());
    }

    public void checkSearchResultIsCorrect(String compareText) {
        for (int i = 0; i < getSearchHighlightElements().size(); i++) {
            String text = getSearchHighlightElements().get(i).getText();
            assertEquals(text.toLowerCase(), compareText.toLowerCase());
        }
    }

    public void clickSearchButton() {
        getSearchButton().click();
    }

    public void clickToSubHeaderEducationElement() {
        Actions action = new Actions(Driver.getWebDriver());
        WebDriverWait wait = new WebDriverWait(Driver.getWebDriver(), 10);
        wait.until(ExpectedConditions.visibilityOf(getSubjectTopMenu()));
        action.moveToElement(getSubjectTopMenu()).moveToElement(getEducationSubMenu()).click().build().perform();
    }

    private WebElement getChangeLocationElement() {
        return Driver.getWebDriver().findElement(CHANGE_LOCATION_LOCATOR);
    }

    private List<WebElement> getSubHeaderElements() {
        return Driver.getWebDriver().findElements(SUB_HEADER_ELEMENTS_LOCATOR);
    }

    private WebElement getSearchFieldElement() {
        return Driver.getWebDriver().findElement(SEARCH_FIELD_LOCATOR);
    }

    private WebElement getCheckArea() {
        return Driver.getWebDriver().findElement(CHECK_AREA_LOCATOR);
    }

    private List<WebElement> getSearchHighlightElements() {
        return Driver.getWebDriver().findElements(SEARCH_HIGH_LIGHTED_ELEMENTS_LOCATOR);
    }

    private WebElement getSearchButton() {
        return Driver.getWebDriver().findElement(SEARCH_BUTTON_LOCATOR);
    }

    private WebElement getSubjectTopMenu() {
        return Driver.getWebDriver().findElement(SUBJECT_HEADER_LOCATOR);
    }

    private WebElement getEducationSubMenu() {
        return Driver.getWebDriver().findElement(EDUCATION_SUBMENU_LOCATOR);
    }
}