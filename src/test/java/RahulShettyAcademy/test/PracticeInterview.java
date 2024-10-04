package RahulShettyAcademy.test;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class PracticeInterview {

	public static void main(String[] args)
	{
	
	WebDriver driver=new ChromeDriver();
	 driver.manage().window().maximize();
     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
     WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(15));
	driver.get("https://rahulshettyacademy.com/AutomationPractice/");
	By radiochk = By.name("radioButton"); // Correct
	By countryTxt = By.id("autocomplete"); // Corrected
	By optDropDown = By.id("dropdown-class-example"); // Corrected
	By chkBox = By.id("checkBoxOption2"); // Corrected

	
	WebElement radioBtn=driver.findElement(chkBox);
	radioBtn.click();
	WebElement countrySel=driver.findElement(countryTxt);
	countrySel.sendKeys("India");
	
	
	
	}
}
