package automation.eCommerce;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import automation.TestUtils.BaseTest;
import automation.pageObject.android.FormPage;

public class eCommerce_TC2 extends BaseTest
{
	
	
	@Test(dataProvider = "getData")
	public void FormError(HashMap<String, String> input) 
	{
		
		FormPage formPage = new FormPage(driver);
		formPage.SetGender(input.get("gender"));
		formPage.SetCountrySelection(input.get("country"));
		formPage.SubmitForm();
		String ToastMessage = formPage.getToastMessage();
		Assert.assertEquals(ToastMessage, "Please enter your");
		
	}
	
	@DataProvider
	public Object[][] getData() throws IOException
	{
		List<HashMap<String, String>>	data =getJsonData(System.getProperty("user.dir")+"//src//test//java//testData//eCommerce.json");
		return new Object[][] { {data.get(0)} };
	}

}
