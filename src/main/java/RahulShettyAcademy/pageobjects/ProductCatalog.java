package RahulShettyAcademy.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;

import RahulShettyAcademy.AbstractComponents.AbstractComponents;

public class ProductCatalog extends AbstractComponents {

	WebDriver driver;

	public ProductCatalog(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}

	//PageFactoryConcept



	@FindBy(css=".mb-3")
	List<WebElement> products;	
	
	@FindBy(css=".ng-animating")
	WebElement loadspinner;	

	By prods= By.cssSelector(".mb-3");
	By aadToCart=By.cssSelector(".card-body button:last-of-type");
    By toastMsg=By.cssSelector("#toast-container");

	public List<WebElement> getProductList()

	{
		WaitForElementToAppear(prods);
		return products;

	}

	public WebElement GetProductName(String productName)
	{
		WebElement selproduct=getProductList().stream().filter(s->s.findElement(By.cssSelector("b"))
				.getText().equals(productName)).findFirst().orElse(null);
		selproduct.findElement(By.cssSelector(".card-body button:last-of-type")).click();

		return selproduct;
	}

	public void AddProductToCart(String productName) throws InterruptedException 
	{
		WebElement prod=GetProductName(productName);
				
		Thread.sleep(4000);
	prod.findElement(aadToCart).click();
	
	WaitForElementToAppear(toastMsg);
	WaitForElementToDisapper(loadspinner);

	}
}
