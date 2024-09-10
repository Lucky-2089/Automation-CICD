package RahulShettyAcademy.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import RahulShettyAcademy.pageobjects.CartPage;
import RahulShettyAcademy.pageobjects.OrderPage;

public class AbstractComponents {

	WebDriver driver;
	public AbstractComponents(WebDriver driver) {

		this.driver=driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(css="[routerlink*='cart']")
	WebElement cartHeader;
	
	@FindBy(css="[routerlink*='myorders']")
	WebElement orderHeader;
	
	public void WaitForElementToAppear(By findby) 
	{
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
		w.until(ExpectedConditions.visibilityOfElementLocated(findby));
	}
	
	
	public void WaitForWebElementToAppear(WebElement findby) 
	{
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
		w.until(ExpectedConditions.visibilityOf(findby));
	}
	public void WaitForElementToDisapper(WebElement ele)  
	{
		//Thread.sleep(1000);//Its due to application traffic 
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
		w.until(ExpectedConditions.invisibilityOf(ele));
	}
	
	public CartPage GoToCartPage()
	{
		cartHeader.click();
		 CartPage cartPage=new CartPage(driver);
	      return cartPage;
		
		
	}
	public OrderPage GoToOrderPage()
	{
		orderHeader.click();
		 OrderPage orderPage=new OrderPage(driver);
	      return orderPage;
		
		
	}
}
