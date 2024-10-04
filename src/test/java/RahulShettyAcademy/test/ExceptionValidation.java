package RahulShettyAcademy.test;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import RahulShettyAcademy.TestComponents.BaseTest;
import RahulShettyAcademy.pageobjects.CartPage;
import RahulShettyAcademy.pageobjects.ProductCatalog;

public class ExceptionValidation  extends BaseTest{
@Test (groups= {"ErrorHandling"})
public void LoginErrorValidation() throws IOException, InterruptedException
	{
		// TODO Auto-generated method stubsss

		//WebDriver driver= new ChromeDriver();
		//String productName="ZARA COAT 3";
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		landingPage.LoginApplication("sure089@gmail.com", "Lucky@123");
		Assert.assertEquals("Incorrect email or password.", landingPage.GetErrorMsg());
		
		
		
		
		
		
	}
@Test

public void ProductErrorValidation() throws IOException, InterruptedException
{

	String productName="ZARA COAT 3";
	ProductCatalog productcatalog= landingPage.LoginApplication("raja089@gmail.com", "Lucky@123");
	//List<WebElement> prods=productcatalog.getProductList();
	productcatalog.AddProductToCart(productName);
	CartPage  cartPage=productcatalog.GoToCartPage();
	Boolean match =cartPage.VerifyProductDisplay(productName);
	Assert.assertTrue(match);
	
	
	
	
	
	
	
	
}
		
	}


