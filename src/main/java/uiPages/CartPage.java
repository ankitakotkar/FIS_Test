package uiPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage{
	
	WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "atcBtn_btn_1")
    private WebElement addToCartLink;
    

    @FindBy(css = "a.gh-eb-li-a.gh-rvi-menu > i#gh-cart-n")
    private WebElement cartCount;
   
    public void addToCart() {
        addToCartLink.click();
    }

    public int verifyCartItemCount() {
        String cartCountValue = cartCount.getText();
        int count = Integer.parseInt(cartCountValue);

        return count;
    }
}
