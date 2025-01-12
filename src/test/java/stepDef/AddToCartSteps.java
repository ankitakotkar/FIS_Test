package stepDef;

import io.cucumber.java.en.*;
import uiPages.CartPage;
import uiPages.HomePage;
import uiPages.SearchItemsPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import Utils.DriverManager;


public class AddToCartSteps{
	
	WebDriver driver = DriverManager.getDriver();

	HomePage homePage = new HomePage(driver);
	SearchItemsPage searchItemsPage = new SearchItemsPage(driver);
	CartPage cartPage = new CartPage(driver);

    @Given("User navigates to Ebay web site")
    public void User_navigates_to_Ebay_website() {
    	driver.get("https://www.ebay.com"); 
    }

    @When("User searches for {string} and clicks on first result displayed")
    public void User_searches_for_inputItem_and_clicks_on_first_result_displayed (String searchItem) {
    	homePage.searchForItem(searchItem);
    	homePage.clickOnFirstResultAndSwitchToIt();
    }

    @Then("User adds item to the cart")
    public void user_adds_item_to_the_cart() {
    	cartPage.addToCart();
    }
    
    @Then("User verifies if the item is added to cart")
    public void user_verifies_if_the_item_is_added_to_cart() {
    	int count = cartPage.verifyCartItemCount();
       	Assert.assertTrue(count > 0, "Cart count is not updated!");
       	DriverManager.quitDriver();
       
    }
        
   
}

