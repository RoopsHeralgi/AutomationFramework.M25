package practice;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNGPractice {
	
//	priority
//	invocation count
//	dependsOnmethods
//	enabled
//	dataprovider
	
	@Test(priority=0)
	public void sampleTest()
	{
		System.out.println("Sample");
	}
	
	@Test(enabled=false)		//disable test script
	public void sampleTest1()		
	{
		System.out.println("Sample1");
	}

	@Test(invocationCount = 3)
	public void sampleTest2()
	{
		System.out.println("Sample2");
	}

	@Test
	public void sampleTest3()
	{
		System.out.println("Sample3");
	}
	
	@Test(dataProvider = "getData")
	public void addproductTocart(String name, int qty)
	{
		System.out.println("Phone info is - "+name+ "and Qty is - "+qty);	//PASS	
	}
	
	@DataProvider
	public Object[][] getData()			//3 Rows 2 Columns
	{
		Object[][] data = new Object[3][2];
		
		data[0][0] = "Samsung";
		data[0][1] = 20;
		
		data[1][0] = "Iphone";
		data[1][1]= 10;
		
		data[2][0] = "OnePlus";
		data[2][1] = 25;
		
		return data;
	}


}
