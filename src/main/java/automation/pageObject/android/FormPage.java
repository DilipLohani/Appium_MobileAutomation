package automation.pageObject.android;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import automation.Utils.AndroidActions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;



public class FormPage extends AndroidActions {
	
	AndroidDriver driver;
	
	public FormPage(AndroidDriver driver)
	
	{	
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		//PageFactory.initElements(driver, this);

	}
	
	//locators
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/nameField")
	private WebElement nameField;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/radioFemale")
	private WebElement FemaleOption;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/radioMale")
	private WebElement MaleOption;
	
	@AndroidFindBy(id="android:id/text1")
	private WebElement CountrySelection;
	
	@AndroidFindBy(id = "com.androidsample.generalstore:id/btnLetsShop")
	private WebElement ShopButton;
	
	
	//Actions
	
	public void SetNameField(String name)
	{
		nameField.sendKeys(name);
		driver.hideKeyboard();
	}
	
	public void SetGender(String gender)
	{
		if(gender.contains("female"))
			FemaleOption.click();
		else
			MaleOption.click();
	}
	
	public String getToastMessage()
	{
	    return driver.findElement(By.xpath("(//android.widget.Toast)[1]")).getText();
	}
	
	public void SetCountrySelection(String CountryName)
	{
		CountrySelection.click();
		scrollToText(CountryName);
		driver.findElement(By.xpath("//android.widget.TextView[@text='"+CountryName+"']")).click();
		
	}
	
	public void SubmitForm()
	{
		ShopButton.click();
	}
	
}
