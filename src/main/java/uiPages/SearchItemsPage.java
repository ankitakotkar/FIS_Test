package uiPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchItemsPage {
	
	WebDriver driver ;
	public SearchItemsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(id = "atcBtn_btn_1")
    private WebElement addToCartBtn;

    @FindBy(xpath = "//span[@id='gh-cart-n']//span[@class='gh-cart-icon']")
    private WebElement cartIcon;


    public void addToCart() {
        addToCartBtn.click();
    }


}
