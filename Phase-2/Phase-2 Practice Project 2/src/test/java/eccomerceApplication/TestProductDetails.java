package eccomerceApplication;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestProductDetails {


	@Test
	public void findProductdetails()
	{
		String product = "camlin";
		String expectedProductType = "pencil";
		
		ProductSearch ps = new ProductSearch();
		
		String actualProductType = ps.getproductType(product);
		
		System.out.println(actualProductType);
		
		Assert.assertEquals(actualProductType, expectedProductType);
		
	}
	
	@Test
	public void findproductdetailswithEmptyInput()
	{
		try {
		String product = "";
		//String expectedProductType = "";
		
ProductSearch ps = new ProductSearch();
		
		String actualProductType = ps.getproductType(product);
		
		}
		catch(NullPointerException e1)
		{
		System.out.println("product name should not be empty");
		}
	}
	
	
	@Test
	public void invalidproductdetails()
	{
		try {
		String product = "calindemo";
		String expectedProductType = "pencil";
       ProductSearch ps = new ProductSearch();
		String actualProductType = ps.getproductType(product);
		}
		catch (NullPointerException e1)
		{
			System.out.println("product details doesnot exist");
		}
		
	}
		
}
