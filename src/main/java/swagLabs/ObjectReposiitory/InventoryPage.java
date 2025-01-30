package swagLabs.ObjectReposiitory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InventoryPage 
{
	@FindBy(id="react-burger-menu-btn")
	private WebElement menuBtn;
	
	@FindBy(linkText="Logout")
	private WebElement logoutLink;
	
	@FindBy(id="shopping_cart_container")
	private WebElement cartContainerBtn;
	
	@FindBy(xpath="//div[.='Sauce Labs Backpack']")
	private WebElement backPackName;
	
//	RULE 3
	public InventoryPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
//	RULE 4

	public WebElement getMenuBtn() {
		return menuBtn;
	}

	public WebElement getLogoutLink() {
		return logoutLink;
	}	
	public WebElement getCartContainerBtn() {
		return cartContainerBtn;
	}

	public WebElement getBackPackName() {
		return backPackName;
	}

//	BUSINESS LIBRARY
	public String clickOnProductName(WebDriver driver, String PRODUCTNAME)
	{
//		handle dynamic xpath
		String productInfo = driver.findElement(By.xpath("//div[.='"+PRODUCTNAME+"']")).getText();
		driver.findElement(By.xpath("//div[.='"+PRODUCTNAME+"']")).click();
		
		return productInfo;
	}
	
	public void clickOnBackPack()
	{
		backPackName.click();
	}
	public void logOutOfApp()
	{
		menuBtn.click();
		logoutLink.click();
	}
	
	public void clickOnCartContainer()
	{
		cartContainerBtn.click();
	}
	
	

	

	
	

}
