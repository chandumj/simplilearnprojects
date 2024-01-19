package eccomerceApplication;

import java.util.HashMap;
import java.util.Map;

public class ProductSearch {

	public Map<String, String> getproductdetails()
	{
		
	Map<String, String> productMap = new HashMap();
	productMap.put("SeleniumBook", "books");
	productMap.put("coach", "handbag");
	productMap.put("camlin", "pencil");
	productMap.put("mac", "laptop");
	productMap.put("samsung", "mobile");
	
	return productMap;
	
	}
	

	public String getproductType(String product) {
		
		Map<String, String> productMap = null;
		
		String producttype = null;
		
		if(product.isEmpty()){
			
			throw new NullPointerException("Exception: Product name should not be empty");
			
		}
		
		productMap = getproductdetails();
		
		if(!productMap.containsKey(product))
		{
			throw new NullPointerException("Exception: Product name is invalid. Details donot exist");
		}
		else {
		 producttype = productMap.get(product);
		}
		
		return producttype ;
	}

}
