package practice;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionsPractice 
{
	@Test
	public void sample()
	{
		System.out.println("Step1");
		System.out.println("Step2");
		System.out.println("Step3");
		
		AssertJUnit.assertEquals(0, 1);
		
		System.out.println("Step4");
		System.out.println("Step5");
	}
	
	@Test
	public void sampleSoft()
	{
		SoftAssert sa = new SoftAssert();
		
		System.out.println("Step 1");
		System.out.println("Step 2");
		System.out.println("Step 3");
		
		AssertJUnit.assertEquals(0, 1);
		
		System.out.println("Step 4");
		
		AssertJUnit.assertEquals("c","d");
		
		System.out.println("Step 5");
		
		sa.assertAll();
	}
	
}
