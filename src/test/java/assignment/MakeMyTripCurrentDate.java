package assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MakeMyTripCurrentDate 
{

	public static void main(String[] args) throws InterruptedException 
	{
//		Task Statement:
//			Write a selenium script to book the flight for Current Date on makemytrip.com
//
		WebDriver driver;
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
//			Steps:
//			1. Navigate to Makemytrip.com
		driver.get("https://www.makemytrip.com/");
		Thread.sleep(6000);
		driver.findElement(By.xpath("//span[@class=\"commonModal__close\"]")).click();
		System.out.println(driver.getCurrentUrl());
		
		
//			2. Select from as banglore
		driver.findElement(By.xpath("//input[@id=\"fromCity\"]")).click();
		driver.findElement(By.xpath("/div[@id=\"react-autowhatever-1\"]//ul//li//p[text()=\"Bengaluru, India\"]")).click();
		Thread.sleep(2000);
		
//			3. Select to as Chennai
		driver.findElement(By.xpath("//input[@id=\"toCity\"]")).click();
		driver.findElement(By.xpath("//div[@id=\"react-autowhatever-1\"]//ul//li//p[text()=\"Chennai, India\"]")).click();
		Thread.sleep(2000);
		
//			4. select departure date as current Date


	}

}
