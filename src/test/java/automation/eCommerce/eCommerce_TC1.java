package automation.eCommerce;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import automation.TestUtils.BaseTest;
import automation.pageObject.android.FormPage;

public class eCommerce_TC1 extends BaseTest
{
	
	@Test(dataProvider = "getData",groups="Smoke")
	public void FillForm(HashMap<String, String> input) throws InterruptedException 
	{
			FormPage formPage = new FormPage(driver);
			formPage.SetNameField(input.get("name"));
			formPage.SetGender(input.get("gender"));
			formPage.SetCountrySelection(input.get("country"));
			formPage.SubmitForm();
			
		
	}
	
	@DataProvider
	public Object[][] getData() throws IOException
	{
		List<HashMap<String, String>>	data =getJsonData(System.getProperty("user.dir")+"//src//test//java//testData//eCommerce.json");
		return new Object[][] { {data.get(0)} };
	}

}
