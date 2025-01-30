package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddToCartUsingDDT {

	public static void main(String[] args) throws IOException {
		
		//Read Common Data From Property File
		FileInputStream fis = new FileInputStream("src/test/resources/CommonData.properties");
		Properties p = new Properties();
		p.load(fis);
		String URL = p.getProperty("url");
		String USERNAME = p.getProperty("username");
		String PASSWORD = p.getProperty("password");
		
//		Read Test Data from Excel file
//		FileInputStream fise = new FileInputStream("src/test/resources/TestData.xlsx");
		FileInputStream fise = new FileInputStream("src/test/resources/TestData.xlsx");
		Workbook workbook = WorkbookFactory.create(fise);
		Sheet sh = workbook.getSheet("Inventory");
//		Sheet sh = wb.getSheet("Inventory");
		Row rw = sh.getRow(1);
		Cell cl = rw.getCell(2);
		String PRODUCTNAME = cl.getStringCellValue();
		System.out.println(PRODUCTNAME);
		
//		Step1: Launch the Browser
		WebDriver driver;
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
//		Step2: Enter the URL
		driver.get(URL);
		
//		Step3: Login to Application
		driver.findElement(By.id("user-name")).sendKeys(USERNAME);
		driver.findElement(By.id("password")).sendKeys(PASSWORD);
		driver.findElement(By.id("login-button")).click();
		
//		Step4: Click on Product
//		String productToBeAdded = driver.findElement(By.xpath("//div[.=\"Sauce Labs Bike Light\"]")).getText();
//		driver.findElement(By.xpath("//div[.=\"Sauce Labs Bike Light\"]")).click();
//		
		
//		Step4: Click on Product- Dynamic Xpath
		String productToBeAdded = driver.findElement(By.xpath("//div[.='"+PRODUCTNAME+"']")).getText();
		driver.findElement(By.xpath("//div[.='"+PRODUCTNAME+"']")).click();
		
//		Step5: Click on Add to Cart button
		driver.findElement(By.id("add-to-cart")).click();
		
//		Step6: Navigate to Cart
		driver.findElement(By.id("shopping_cart_container")).click();
		
//		Step7: Validate the Product in Cart
		String ProductInCart = driver.findElement(By.className("inventory_item_name")).getText();
		if(ProductInCart.equals(productToBeAdded))
		{
			System.out.println("PASS");
			System.out.println(ProductInCart);
		}
		else
		{
			System.out.println("FAIL");
		}
		
		
//		Step8: Logout of Application
		driver.findElement(By.id("react-burger-menu-btn")).click();
		driver.findElement(By.linkText("Logout")).click();
		System.out.println("Logout Successful");
				
	}

}
