package swagLabs.ObjectReposiitory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.PageFactory;

import swagLabs.GenericUtility.SeleniumUtility;

public class LoginPage 
{
	//Rule 1
	
//	Rule 2	
	@FindBy(id="user-name")			//during compile time
	private WebElement usernameEdt;	//findElements()
	
	//1 -  Logical OR - Auto healing
//	@FindAll({@FindBy(name = "password"), @FindBy(xpath = "//input[@type='password']")}) //multiple locator
	@FindBy(name="password")
	private WebElement passwordEdt;
	
/*	//2 - Logical AND operator
	@FindBys({@FindBy(name = "password"), @FindBy(xpath = "//input[@type='password']")}) //multiple locator
	private WebElement passwordEdt;
*/	
	
	@FindBy(id="login-button")
	private WebElement loginBtn;
	
//	Rule 3
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
//	Rule 4
	public WebElement getUsernameEdt() {
		return usernameEdt;
	}

	public WebElement getPasswordEdt() {
		return passwordEdt;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
//	BUSINESS LIBRARY - Generic method
//	@param USERNAME
//	@param PASSWORD
	
	public void loginToApp(String USERNAME, String PASSWORD)
	{
		usernameEdt.sendKeys(USERNAME);
		passwordEdt.sendKeys(PASSWORD);
		loginBtn.click();
		
	}
	
	
	
	
}
