package RahulShettyAcademy.TestComponents;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import RahulShettyAcademy.pageobjects.LandingPage;

public class BaseTest {


	public WebDriver driver;
	public LandingPage landingPage;
	public WebDriver IntializeDriver() throws IOException {

		Properties prop=new Properties();
		//FileInputStream Fis= new FileInputStream("C:\\Users\\laxma\\eclipse-workspace\\SeleniumFrameworkDesign\\src\\main\\java\\RahulShettyAcademy\\Resources");
		FileInputStream Fis= new  FileInputStream(System.getProperty("user.dir")+"/src/main/java/RahulShettyAcademy/Resources/GlobalData.properties");
		prop.load(Fis);
		String browserName=	prop.getProperty("browser");

		if(browserName.contains("chrome"))
		{
			driver= new ChromeDriver();

		}
		else if(browserName.contains("firefox"))
		{
			driver= new FirefoxDriver();

		}
		else if(browserName.equalsIgnoreCase("Edge"))
		{
			driver= new EdgeDriver();

		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;

	}
   @BeforeMethod(alwaysRun=true)
	public LandingPage LaunchApplication() throws IOException 

	{
		driver=IntializeDriver();
		landingPage=new LandingPage(driver);
		landingPage.GoTo();
		return landingPage;
	}
   @AfterMethod(alwaysRun=true)
	public void TearDown() 

	{
		driver.close();
		
	}
}
