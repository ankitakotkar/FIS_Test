package uiPages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class HomePage {
	
	WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "gh-ac")
    private WebElement searchBox;

    @FindBy(id = "gh-btn")
    private WebElement searchButton;
    
    @FindBy(xpath = "//*[@id='srp-river-results']/ul/li")
    List<WebElement> searchResultsList;

    @FindBy(css ="li[data-viewport*='trackableId']")
    private WebElement listItem;

    public void searchForItem(String item) {
        searchBox.sendKeys(item);
        searchButton.click();
    }
    
    public void clickOnFirstResultAndSwitchToIt() {

        if (searchResultsList.size() > 0) {
            WebElement firstResult = searchResultsList.get(0);
            String itemId = firstResult.getAttribute("id");
            System.out.println("Clicking on the first result - " + firstResult.getText());
            
            String dynamicLocator = "//*[@id='" + itemId + "']/div/div[2]/a";

            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", firstResult);

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement link = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(dynamicLocator)));
            
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", link);
            
            try {
            	switchToNewWindow();
            }catch(Exception e) {
            	Assert.fail("Could not load or switch to new window on clicking first result for 'Books'");
            }

        } else {
            throw new NoSuchElementException("No search results found!");
        }

    }
    
    public void switchToNewWindow() {
    	for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }
    }

}
