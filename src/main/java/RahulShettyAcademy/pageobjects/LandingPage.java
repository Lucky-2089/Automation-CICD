package RahulShettyAcademy.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import RahulShettyAcademy.AbstractComponents.AbstractComponents;

public class LandingPage extends AbstractComponents{

	WebDriver driver;

	public LandingPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}

	//PageFactoryConcept
	@FindBy(id="userEmail")
	WebElement userEmail;

	@FindBy(id="userPassword")
	WebElement pass;

	@FindBy(id="login")
	WebElement submitBtn;

	@FindBy(css="[class*='flyInOut'")
	WebElement errorMsg;

	public ProductCatalog LoginApplication(String email,String password) 
	{

		userEmail.sendKeys(email);
		pass.sendKeys(password);
		submitBtn.click();
		ProductCatalog productCatalog=new ProductCatalog(driver);
		return productCatalog;

	}
	
	public String GetErrorMsg() {
		
		WaitForWebElementToAppear(errorMsg);
		return errorMsg.getText();
	}
	public void GoTo()
	{
		driver.get("https://rahulshettyacademy.com/client");
	}

}

