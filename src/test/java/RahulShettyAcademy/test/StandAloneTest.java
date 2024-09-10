package RahulShettyAcademy.test;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import RahulShettyAcademy.pageobjects.LandingPage;

public class StandAloneTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver= new ChromeDriver();
		String item="ZARA COAT 3";
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5)); 
		driver.get("https://rahulshettyacademy.com/client");
		LandingPage landingPage=new LandingPage(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
		String userName=driver.findElement(By.id("userEmail")).getText();
		String userPassword =driver.findElement(By.id("userPassword")).getText();
		
		if(userName!=null && userPassword!=null)
		{
		driver.findElement(By.id("userEmail")).clear();
		driver.findElement(By.id("userPassword")).clear();
		
		driver.findElement(By.id("userEmail")).sendKeys("laxman2089@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Lucky@123");
		driver.findElement(By.id("login")).click();
		}
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
		List<WebElement> products =driver.findElements(By.cssSelector(".mb-3"));
		WebElement selproduct=products.stream().filter(s->s.findElement(By.cssSelector("b"))
				.getText().equals(item)).findFirst().orElse(null);
		selproduct.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		w.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		WebElement Submit = driver.findElement(By.cssSelector("[routerlink*='cart']"));

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].click();", Submit);
		//driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
		List<WebElement> cartItems =driver.findElements(By.cssSelector(".cartSection h3"));
		Boolean itemPresent=cartItems.stream().anyMatch(cartItem->cartItem
				.getText().equalsIgnoreCase(item));
		Assert.assertTrue(itemPresent);
		
		driver.findElement(By.cssSelector(".totalRow button")).click();
		
		//driver.findElement(By.xpath("//input[@placeholder='Select Country']")).sendKeys("ind");
		//List<WebElement> options =driver.findElements(By.cssSelector("i[class$='fa fa-search']"));
		
		Actions a =new Actions(driver);
		a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")), "India").build().perform();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
		driver.findElement(By.xpath("(//button[contains(@class,'ta-item')])[2]")).click();
		driver.findElement(By.xpath("//a[.='Place Order ']")).click();
		//w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[aria-label='Order Placed Successfully']")));
	   String orderConfirmMsg=driver.findElement(By.cssSelector(".hero-primary")).getText();
		Assert.assertTrue(orderConfirmMsg.equalsIgnoreCase("THANKYOU FOR THE ORDER"));
		driver.close();
		
		
	}
		
		
	}


