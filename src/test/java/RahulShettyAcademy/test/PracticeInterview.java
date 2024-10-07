package RahulShettyAcademy.test;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class PracticeInterview {

	public static void main(String[] args)
	{

		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		By radiochk = By.xpath("//input[@value='radio2']"); // Correct
		By countryTxt = By.id("autocomplete"); // Corrected
		By optDropDown = By.id("dropdown-class-example"); // Corrected
		By chkBox = By.id("checkBoxOption2"); // Corrected
		By dropDown=By.id("dropdown-class-example");

		//Radio checkbox
		WebElement radioChk=driver.findElement(radiochk);
		radioChk.click();

		//Auto Select drop-down select
		WebElement inputField = driver.findElement(By.id("autocomplete"));
		inputField.sendKeys("ind");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-menu-item-wrapper")));
		List<WebElement> suggestionItems = driver.findElements(By.className("ui-menu-item-wrapper"));
		for (WebElement item : suggestionItems) {
			if (item.getText().equalsIgnoreCase("India")) {
				item.click();
				break; // Exit the loop once "India" is found and clicked
			}
		}

		WebElement dropDownElement =driver.findElement(dropDown);
		Select selectValues=new Select(dropDownElement);
		selectValues.selectByIndex(2);
		WebElement checkbox=driver.findElement(chkBox);
		checkbox.click();

		driver.findElement(By.id("openwindow")).click();
		Set<String> windowHandles = driver.getWindowHandles();

		// Create an iterator for the window handles
		Iterator<String> windowIterator = windowHandles.iterator();

		// Switch between windows
		while (windowIterator.hasNext()) {
			String window = windowIterator.next();
			driver.switchTo().window(window);

			// Perform actions on the current window
			System.out.println("Window Title: " + driver.getTitle());
			//driver.close();
		}
		
	}
}
