package com.ninjas.qa.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.ninjas.qa.base.BaseClass;
import com.ninjas.qa.pages.SearchPage;

public class TestSearchPage extends BaseClass{

	SearchPage sp;
	
	@BeforeMethod
	public void OpenApp()
	{
	openBrowser();
	sp = new SearchPage(driver);
		
	}
	
	@Parameters({"product"})
	@Test(testName="productentry", priority='1')
	public void test_searchProduct(String product)
	{
		sp.SearchProduct(product);
	}
	
}
