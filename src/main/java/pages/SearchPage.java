package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.Driver;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SearchPage {

    private static final By PRODUCT_LIST_LOCATOR = By.xpath("//*[@class=\"products-list\"]");
    private static final By PRODUCTI_ITEM_LOCATOR = By.xpath("//*[@class=\"product-item\"]");
    private static final By PRODUCT_ITEM_CONTAINS_JAVA_LOCATOR = By.xpath("//*[contains(@class, 'product-title') and contains(.//span, 'Java')]");
    private static final By ADD_TO_CART_BUTTON_LOCATOR = By.xpath("./div/div/div/div/section/div/div/div/div/div/div[@class='product-button']/a/div");
    private static final By VIEW_ONLINELIBRARY_BUTTON_LOCATOR = By.xpath("./div/div/div/div/section/div/div/div/div/div/div[@class='product-button']/a[contains(text(), 'View on Wiley Online Library')]");
    private static final By EBOOK_TAB_ELEMENT_LOCATOR = By.xpath("./div/div/div/div/section/div/ul/li/a[@aria-controls='plpPrintTab']/div[text()='E-Book']");
    private static final By PRINT_TAB_ELEMENT_LOCATOR = By.xpath("./div/div/div/div/section/div/ul/li/a[@aria-controls='plpPrintTab']/div[text()='Print']");
    private static final By OBOOK_TAB_ELEMENT_LOCATOR = By.xpath("./div/div/div/div/section/div/ul/li/a[@aria-controls='plpPrintTab']/div[text()='O-Book']");

    public void checkHowTitelsInPage(int howTitles) {
        assertEquals(getProductContainers().size(), howTitles);
    }

    public void checkAllTitlesContainsJava() {
        assertEquals(getProductContainers().size(), getTitlecontainsJava().size());
    }

    public void checkAddCartButtonIsDisplayed() {
        for (WebElement element : getProductContainers()) {
            List<WebElement> eBookElements = element.findElements(EBOOK_TAB_ELEMENT_LOCATOR);
            List<WebElement> printElements = element.findElements(PRINT_TAB_ELEMENT_LOCATOR);
            if (eBookElements.size() == 1) {
                if (eBookElements.get(0).isDisplayed()) {
                    assertTrue(element.findElement(ADD_TO_CART_BUTTON_LOCATOR).isDisplayed());
                }
            }
            if (printElements.size() == 1) {
                if (printElements.get(0).isDisplayed()) {
                    assertTrue(element.findElement(ADD_TO_CART_BUTTON_LOCATOR).isDisplayed());
                }
            }
            List<WebElement> oBookElements = element.findElements(OBOOK_TAB_ELEMENT_LOCATOR);
            if (oBookElements.size() == 1) {
                if (oBookElements.get(0).isDisplayed()) {
                    assertTrue(element.findElement(VIEW_ONLINELIBRARY_BUTTON_LOCATOR).isDisplayed());
                }
            }
        }
    }

    private WebElement getProductList() {
        return Driver.getWebDriver().findElement(PRODUCT_LIST_LOCATOR);
    }

    private List<WebElement> getProductContainers() {
        return getProductList().findElements(PRODUCTI_ITEM_LOCATOR);
    }

    private List<WebElement> getTitlecontainsJava() {
        return Driver.getWebDriver().findElements(PRODUCT_ITEM_CONTAINS_JAVA_LOCATOR);
    }
}