package RahulShetty.stepDefinations;

import java.io.IOException;

import org.testng.Assert;

import RahulShettyAcademy.TestComponents.BaseTest;
import RahulShettyAcademy.pageobjects.CartPage;
import RahulShettyAcademy.pageobjects.CheckOutPage;
import RahulShettyAcademy.pageobjects.ConfirmationPage;
import RahulShettyAcademy.pageobjects.LandingPage;
import RahulShettyAcademy.pageobjects.ProductCatalog;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinition extends BaseTest {

    public LandingPage landingPage;
    public ProductCatalog productCatalog;
    public ConfirmationPage confirmationPage;

    @Given("I landed on Ecommerce Page")
    public void iLandedOnEcommercePage() throws IOException {
        landingPage = LaunchApplication();
        System.out.println("Print 1 method works ");
    }
 //logged in with username <name> and password <password>
    @Given("logged in with username {word} and password {word}")
    public void loggedInWithUsernameAndPassword(String username, String password) {
    	   System.out.println("Print 2 in progress ");
        productCatalog = landingPage.LoginApplication(username,password);
    }
// When I add the product <ProductName> to the cart
    @When("I add the product {string} to the cart")
    public void iAddProductToCart(String productName) throws InterruptedException {
        productCatalog.AddProductToCart(productName);
    }

    //And Checkout <Product Name> and submit the order
    @When("Checkout {string} and submit the order")
    public void checkoutAndSubmitOrder(String productName) {
        CartPage cartPage = productCatalog.GoToCartPage();
        Assert.assertTrue(cartPage.VerifyProductDisplay(productName));
        CheckOutPage checkoutPage = cartPage.GoToCheckout();
        checkoutPage.selectCountry("India");
        confirmationPage = checkoutPage.SubmitOrder();
    }

    //Then "THANKYOU FOR THE ORDER." message is displayed on the ConfirmationPage
    @Then("{string} message is displayed on the ConfirmationPage")
    public void messageDisplayedOnConfirmationPage(String expectedMessage) {
        String confirmMessage = confirmationPage.GetConfirmationMsg();
        Assert.assertEquals(confirmMessage, expectedMessage, "Confirmation message mismatch!");
        driver.close();
    }
    
    @Then("^\"([^\"]*)\" message is displayed$")
    public void message_is_displayed(String expectedMessage) throws Throwable {
        
        Assert.assertEquals(expectedMessage, landingPage.GetErrorMsg());
        driver.close();
    }
}