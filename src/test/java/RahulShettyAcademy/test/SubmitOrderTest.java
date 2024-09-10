package RahulShettyAcademy.test;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import RahulShettyAcademy.TestComponents.BaseTest;
import RahulShettyAcademy.pageobjects.CartPage;
import RahulShettyAcademy.pageobjects.CheckOutPage;
import RahulShettyAcademy.pageobjects.ConfirmationPage;
import RahulShettyAcademy.pageobjects.OrderPage;
import RahulShettyAcademy.pageobjects.ProductCatalog;

public class SubmitOrderTest  extends BaseTest{
	String productName="ZARA COAT 3";
@Test
public void submitOrder() throws IOException, InterruptedException
	{
		// TODO Auto-generated method stubsss

		//WebDriver driver= new ChromeDriver();
		
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5)); 
		ProductCatalog productCatalog=landingPage.LoginApplication("laxman2089@gmail.com", "Lucky@123");
		
		List<WebElement> prods=productCatalog.getProductList();
		productCatalog.AddProductToCart(productName);
		CartPage  cartPage=productCatalog.GoToCartPage();
		
		Boolean match =cartPage.VerifyProductDisplay(productName);
		Assert.assertTrue(match);
		CheckOutPage checkoutPage=cartPage.GoToCheckout();
		checkoutPage.selectCountry("India");
		ConfirmationPage confirmationpage=checkoutPage.SubmitOrder();
		String confirmMessage=confirmationpage.GetConfirmationMsg();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
			
		
	}
@Test(dependsOnMethods= {"submitOrder"})

public void OrderHistoryTest() 
{
	ProductCatalog productCatalog=landingPage.LoginApplication("laxman2089@gmail.com", "Lucky@123");
	OrderPage orderPage=productCatalog.GoToOrderPage();
	Assert.assertTrue(orderPage.VerifyOrderDisplay(productName));
	
}
	@DataProvider
	public Object [][] getData() 
	{
	return new Object[][] {{"laxman2089@gmail.com","Lucky@123","ZARA COAT 3"},{"laxm089@gmail.com","Lucky@123","ADIDAS ORIGNAL"}};	
	}
		
	}


