package assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FlipCart 
{

	public static void main(String[] args) 
	{
//		Task Statement:  
//			Write a selenium script to search the product and add to the cart on Flipkart.com
//
		WebDriver driver;
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
//			Steps:
//			1. Navigate to flipkart.com 
		driver.get("https://www.flipkart.com/");		
		
//			2. search for "winter heater" 
		driver.findElement(By.xpath("//input[@class=\"Pke_EE\"]")).click();
		driver.findElement(By.xpath("//input[@class=\"Pke_EE\"]")).sendKeys("winter heater");
		driver.findElement(By.xpath("//input[@class=\"Pke_EE\"]")).sendKeys(Keys.ENTER);
		
//			3. Select the first product in the search results and click
		String SelectedItem = driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[3]/div[1]/div[2]/div[2]/div/div[1]")).getText();
		System.out.println(SelectedItem);
		driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[3]/div[1]/div[2]/div[2]/div/div[1]")).click();
		
		
//			4. Product page will be displyed
//		System.out.println(driver.findElement(By.xpath("//div//h1//span[contains(text(),\"GESTOR BLAZE Neo\")]")).isDisplayed());
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		
//			5. Click on Add to cart button
		driver.findElement(By.xpath("//button[text()=\"Add to cart\"]")).click();
		
//			6. Verify the product in cart page
		String ProductInCart = driver.findElement(By.xpath("//div//h1//span[contains(text(),\"GESTOR BLAZE Neo\")]")).getText();
		if(ProductInCart.equals(SelectedItem))
		{
			System.out.println("PASS");
			System.out.println(ProductInCart);
		}
		else
		{
			System.out.println("FAIL");
		}
	}

}
