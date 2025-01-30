package swagLabs.GenericUtility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import swagLabs.ObjectReposiitory.InventoryPage;
import swagLabs.ObjectReposiitory.LoginPage;

public class BaseClass 
{
	public ExcelFileUtility eUtil = new ExcelFileUtility();
	public PropertyFileUtility pUtil = new PropertyFileUtility();
	public SeleniumUtility sUtil = new SeleniumUtility();
	
	public WebDriver driver;
	
//	For Listeners
	public static WebDriver sdriver;
	
	@BeforeSuite(groups = {"SmokeSuite","RegressionSuite"})
	public void bsConfig()
	{
		System.out.println("=======Database Connection Successful=======");	
		
	}
	
//	@Parameters("browser")
//	@BeforeTest
	@BeforeClass(alwaysRun = true)
	public void bcConfig(/*String parameterValue*/) throws IOException
	{
		String URL = pUtil.readDataFromPropertyFile("url");
//		/*Launch browser based on parameter value of cross browser execution*/
//		
//		if(parameterValue.equals("chrome"))
//		{
//			driver = new ChromeDriver();
//		}
//		else if(parameterValue.equals("safari"))
//		{
//			driver =  new SafariDriver(); 
//		}
//		else
//		{
//			driver = new ChromeDriver();
//		}
		
		driver = new ChromeDriver();
		sUtil.maximizeWindow(driver);
		sUtil.addimplicitlyWait(driver);
		driver.get(URL);
		System.out.println("=======Browser Launch Successfully=======");
		
//		For Listeners
		sdriver = driver;
		
	}
	@BeforeMethod(alwaysRun = true)
	public void bmConfig() throws IOException
	{
		String USRENAME = pUtil.readDataFromPropertyFile("username");
		String PASSWORD = pUtil.readDataFromPropertyFile("password");
		
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(USRENAME, PASSWORD);
		
		System.out.println("==========Login To App successfull==========");
	}
	@AfterMethod(alwaysRun = true)
	public void amConfig()
	{
		InventoryPage ip = new InventoryPage(driver);
		ip.logOutOfApp();
		
		System.out.println("=========Logout of App successfull==========");
	}
	@AfterClass(alwaysRun = true)
	public void acConfig()
	{
		driver.quit();
		System.out.println("===========Browser closure successfull=============");
	}
	@AfterSuite(alwaysRun = true)
	public void asConfig()
	{
		System.out.println("============Database Connection closure successfull=============");
	}

}
