package RahulShettyAcademy.pageobjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import RahulShettyAcademy.AbstractComponents.AbstractComponents;

public class CheckOutPage extends AbstractComponents {

	WebDriver driver;

	@FindBy(xpath="//a[.='Place Order ']")
	WebElement submit;	

	@FindBy(xpath="(//button[contains(@class,'ta-item')])[2]")
	WebElement selectedCountry;	

	@FindBy(css="[placeholder='Select Country']")
	WebElement countryTextBox;


	By results =By.cssSelector(".ta-results");
	
	public CheckOutPage(WebDriver driver) {

		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);	
	}
	public void selectCountry(String countryName) {

		Actions a =new Actions(driver);
		a.sendKeys(countryTextBox, countryName).build().perform();
		WaitForElementToAppear(results);
		selectedCountry.click();

	}

	public ConfirmationPage SubmitOrder() {

		submit.click();
		ConfirmationPage confirmPage=new ConfirmationPage(driver);
		return confirmPage;
	}

	}
