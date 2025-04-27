package automation.pageObject.android;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import automation.Utils.AndroidActions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ProductCatalog extends AndroidActions {
	
	
	AndroidDriver driver;
	
	public ProductCatalog(AndroidDriver driver)
	
	{	
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		//PageFactory.initElements(driver, this);

	}
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text = 'ADD TO CART']")
	private List<WebElement> AddToCart;
	
	
	@AndroidFindBy(id = "com.androidsample.generalstore:id/appbar_btn_cart")
	private WebElement Cart;
	
	
	
	public void AddItemToCartByIndex(int index)
	{
		
		AddToCart.get(index).click();
	}
	
	public void GoToCartPage() throws InterruptedException
	{
		Cart.click();
		Thread.sleep(3000);
	}
	

}
