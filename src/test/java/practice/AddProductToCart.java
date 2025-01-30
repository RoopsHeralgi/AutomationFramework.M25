package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddProductToCart 
{

	public static void main(String[] args) throws InterruptedException 
	{
//		Step1: Launch the Browser
		WebDriver driver = new ChromeDriver();
			
//		Step2: Enter the URL
		driver.get("https://www.saucedemo.com/");
		
//		Step3: Login to Application
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		
//		Step4: Click on Product
		String ProductToBeAdded = driver.findElement(By.xpath("//div[.=\"Sauce Labs Bike Light\"]")).getText();
		System.out.println(ProductToBeAdded);
		driver.findElement(By.xpath("//div[.=\"Sauce Labs Bike Light\"]")).click();
		
//		Step5: Click on Add to Cart button
		driver.findElement(By.id("add-to-cart")).click();
		
//		Step6: Navigate to Cart
		driver.findElement(By.id("shopping_cart_container")).click();
		
//		Step7: Validate the Product in Cart
		String ProductInCart = driver.findElement(By.className("inventory_item_name")).getText();
		if(ProductInCart.equals(ProductToBeAdded))
		{
			System.out.println("PASS");
			System.out.println(ProductInCart);
		}
		else {
			System.out.println("FAIL");
		}
		
//		Step8: Logout of Application
		Thread.sleep(2000);
		driver.findElement(By.id("react-burger-menu-btn")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Logout")).click();
		System.out.println("Successfully Log out");

	}

}
