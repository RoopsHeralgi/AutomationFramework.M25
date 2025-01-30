package assignment;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FlipCartRedMe 
{

	public static void main(String[] args) 
	{
//		Task Statement:
//			Write a selenium script to capture all the redmi phones whose ram is 4GB
		
		WebDriver driver;
		driver = new ChromeDriver();
		driver.manage().window().maximize();
//
//			Steps:
//			1. Navigate to Flipkart.com
		driver.get("https://www.flipkart.com/");
		
//			2. Search for "redMi"
		driver.findElement(By.xpath("//input[@class=\"Pke_EE\"]")).click();
		driver.findElement(By.xpath("//input[@class=\"Pke_EE\"]")).sendKeys("redMi");
		driver.findElement(By.xpath("//input[@class=\"Pke_EE\"]")).sendKeys(Keys.ENTER);
		
//			3. Capture all the phones in the current page whose RAM is 4GB - xpath
		List<WebElement> RedMi = driver.findElements(By.xpath("//*[@id=\"container\"]//div[@class=\"cPHDOP col-12-12\"]//ul/li[1][contains(text(),\"4 GB RAM\")]"));
		
		
//			4. Print in console.
		for(int i=0; i<RedMi.size(); i++)
		{
			System.out.println(RedMi.get(i).getText());
		}
		

	}

}
