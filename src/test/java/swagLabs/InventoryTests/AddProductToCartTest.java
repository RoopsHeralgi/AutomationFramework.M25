package swagLabs.InventoryTests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import swagLabs.GenericUtility.BaseClass;
import swagLabs.GenericUtility.ExcelFileUtility;
import swagLabs.GenericUtility.PropertyFileUtility;
import swagLabs.GenericUtility.SeleniumUtility;
import swagLabs.ObjectReposiitory.CartPage;
import swagLabs.ObjectReposiitory.InventoryPage;
import swagLabs.ObjectReposiitory.LoginPage;
import swagLabs.ObjectReposiitory.ProductPage;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

@Listeners(swagLabs.GenericUtility.ListnersImplementation.class)
public class AddProductToCartTest extends BaseClass
{

	@Test(groups = "SmokeSuite")
	
	public void tc_001_AddProductToCartTest() throws IOException
	{

		
//		Read Test Data From Excel File
		String PRODUCTNAME = eUtil.readDataFromExcel("Inventory", 1, 2);
		System.out.println(PRODUCTNAME);
		
		
//		Step 3: Click on Product- Product Name from excel
		InventoryPage ip = new InventoryPage(driver);
		String productAdded = ip.clickOnProductName(driver, PRODUCTNAME);
		
//		Step 4: Click on add To cart button
		ProductPage pp = new ProductPage(driver);
		pp.clickOnAddToCartBtn();
		
//		Step 5: Navigate to Cart y
		ip.clickOnCartContainer();
		
//		Assert.fail();
		
//		Step 6: Validate the product in Cart
		CartPage cp = new CartPage(driver);
		String productInCart = cp.getProductInfo();
		
		AssertJUnit.assertEquals(productInCart, productAdded);
		
		AssertJUnit.assertTrue(productInCart.equals(productAdded));
		
		System.out.println(productInCart);
		
		
	}
//	@Test(/*retryAnalyzer = swagLabs.GenericUtility.RetryAnalyserImplementation.class*/)
//	public void sampleTest()
//	{
//		Assert.fail();
//		System.out.println("sample");
//	}

}
