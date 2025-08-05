package automation.eCommerce;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import automation.TestUtils.BaseTest;
import automation.pageObject.android.CartPage;
import automation.pageObject.android.FormPage;
import automation.pageObject.android.ProductCatalog;

public class eCommerce_TC3 extends BaseTest
{
	
	
	@Test(dataProvider = "getData")
	public void E2Etest(HashMap<String, String> input) throws InterruptedException 
	{
		

		FormPage formPage = new FormPage(driver);
		formPage.SetNameField(input.get("name"));
		formPage.SetGender(input.get("gender"));
		formPage.SetCountrySelection(input.get("country"));
		formPage.SubmitForm();
						
		ProductCatalog productCatalog = new ProductCatalog(driver);
		productCatalog.AddItemToCartByIndex(0);
		productCatalog.AddItemToCartByIndex(0);
		productCatalog.GoToCartPage();
		
		CartPage cartPage = new CartPage(driver);
		double totalSum = cartPage.getProductsSum();
		double displayFormattedSum = cartPage.getTotalAmountDisplayed();
		Assert.assertEquals(totalSum,displayFormattedSum);
		cartPage.acceptTermsConditions();
	    cartPage.submitOrder();
	
	}
	
	@DataProvider
	public Object[][] getData() throws IOException
	{
		List<HashMap<String, String>>	data =getJsonData(System.getProperty("user.dir")+"//src//test//java//testData//eCommerce.json");
		return new Object[][] { {data.get(0)} };
	}
		
	
}

