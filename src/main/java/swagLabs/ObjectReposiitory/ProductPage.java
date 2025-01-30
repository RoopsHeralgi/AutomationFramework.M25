package swagLabs.ObjectReposiitory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage 
{

	@FindBy(id="add-to-cart")
	private WebElement addToCart;
	
	public ProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getAddToCart() {
		return addToCart;
	}
	
	//BUSINESS LIBRARY
//	This method will click on add to cart button
	
	public void clickOnAddToCartBtn()
	{
		addToCart.click();
	}
	
}
