package RahulShettyAcademy.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import RahulShettyAcademy.AbstractComponents.AbstractComponents;

public class CartPage extends AbstractComponents{
	WebDriver driver;
	
	@FindBy(css=".totalRow button")
	WebElement checkoutele;	
	
	@FindBy(css=".cartSection h3")
	List<WebElement> cartProducts;
	
	
	public CartPage(WebDriver driver) 
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);	
		
	}
	public boolean VerifyProductDisplay(String productName) 
	{
		Boolean match=cartProducts.stream().anyMatch(cartItem->cartItem
				.getText().equalsIgnoreCase(productName));	
		return match;
		
	}
	public CheckOutPage GoToCheckout() 
	{
      checkoutele.click();
     CheckOutPage checkoutPage=new CheckOutPage(driver);
     return checkoutPage ;
				


	}

}
