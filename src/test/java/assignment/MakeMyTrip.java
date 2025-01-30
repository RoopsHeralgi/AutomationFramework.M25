package assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class MakeMyTrip 
{

	public static void main(String[] args) throws InterruptedException 
	{
//		Task Statement:
//			Write a selenium script to book the flight for feb 5th 2025 on makemytrip.com
//
		WebDriver driver;
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		
//			Steps:
//			1. Navigate to Makemytrip.com
		
		driver.get("https://www.makemytrip.com/");
		Thread.sleep(4000);
		driver.findElement(By.xpath("//div[@id=\"root\"]//span[@class=\"commonModal__close\"]")).click();
		System.out.println(driver.getCurrentUrl());
		
//			2. Select from as banglor'e
		driver.findElement(By.id("fromCity")).click();
		Thread.sleep(1000);
		WebElement FromCity = driver.findElement(By.xpath("//div[@id=\"react-autowhatever-1\"]//ul/li//p[contains(text(),\"Bengaluru\")]"));
		FromCity.click();
		
//		WebElement FromCity = driver.findElement(By.xpath("//div[@id=\"react-autowhatever-1\"]//ul/li//p[@class=\"font14 appendBottom5 blackText\"]"));
//		Select sl = new Select(FromCity);
//		sl.selectByVisibleText("Bengaluru,India");
		
//			3. Select to as Chennai
		driver.findElement(By.xpath("//div[@id=\"react-autowhatever-1\"]//ul/li//p[contains(text(),\"Chennai\")]")).click();
		
//			4. select departure date as 5th Feb 2025


	}

}
