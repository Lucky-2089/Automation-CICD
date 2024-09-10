package RahulShettyAcademy.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import RahulShettyAcademy.AbstractComponents.AbstractComponents;

public class ConfirmationPage extends AbstractComponents {
	WebDriver driver;
	
	@FindBy(css=".hero-primary")
	WebElement orderIdConfirmation;
	
	public ConfirmationPage(WebDriver driver) {

		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);	
	}

	
	public String GetConfirmationMsg() 
	
	{
	return 	orderIdConfirmation.getText();
		
	} 
}
