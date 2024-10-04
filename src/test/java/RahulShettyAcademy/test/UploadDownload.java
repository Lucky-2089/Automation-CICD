package RahulShettyAcademy.test;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
public class UploadDownload {
	public static void main(String[] args)
	{
		 WebDriver driver = new ChromeDriver();
	        driver.manage().window().maximize();
             driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	        // Setting up explicit wait
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));

	        // Navigating to the test page
	        driver.get("https://rahulshettyacademy.com/upload-download-test/");
	        driver.findElement(By.cssSelector("#downloadButton")).click();
	        

	        // Locating the file input element and uploading the file
	        WebElement file = driver.findElement(By.cssSelector("input[type='file']"));
	        file.sendKeys("C:\\Users\\laxma\\Downloads\\download.xlsx");

	        // Waiting for the toast message to become visible
	        By toastLocator = By.cssSelector(".Toastify__toast-body div:nth-child(2)");
	        wait.until(ExpectedConditions.visibilityOfElementLocated(toastLocator));

	        // Retrieving the toast message text
	        String toastMsg = driver.findElement(toastLocator).getText();

	        // Asserting the toast message is as expected
	        Assert.assertEquals(toastMsg, "Updated Excel Data Successfully.");

	        // Printing the toast message
	        System.out.println(toastMsg);
	        wait.until(ExpectedConditions.invisibilityOfElementLocated(toastLocator));
	        // Closing the driver
	        //driver.quit();
	     

	       
	}

}
