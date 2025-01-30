package swagLabs.ObjectReposiitory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
	
//	Declaration
	@FindBy(className="inventory_item_name")
	private WebElement itemName;
	
	
//	Initialization
	public CartPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}

//	Utilization	
	public WebElement getItemName() {
		return itemName;
	}
	
	
//	BUSINESS LIBRARY
//	This method will capture the product info in cart and return to Caller
//	return
	public String getProductInfo()
	{
		return itemName.getText();
	}
	
}
