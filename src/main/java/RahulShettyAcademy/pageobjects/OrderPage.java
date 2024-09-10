package RahulShettyAcademy.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import RahulShettyAcademy.AbstractComponents.AbstractComponents;

public class OrderPage extends AbstractComponents{
	WebDriver driver;
	
	@FindBy(css=".totalRow button")
	WebElement checkoutele;	
	
	@FindBy(css="tr td:nth-child(3)")
	List<WebElement> productsNames;
	
	
	public OrderPage(WebDriver driver) 
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);	
		
	}
	public boolean VerifyOrderDisplay(String productName) 
	{
		Boolean match=productsNames.stream().anyMatch(cartItem->cartItem
				.getText().equalsIgnoreCase(productName));	
		return match;
		
	}


}
