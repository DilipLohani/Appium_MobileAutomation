package automation.TestUtils;
import java.io.File;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import com.aventstack.extentreports.ExtentReports;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseTest
{
	ExtentReports extent;
	public AndroidDriver driver;
	public AppiumDriverLocalService service;
	
	@BeforeClass(alwaysRun = true)
	public void  configureAppium() throws URISyntaxException, IOException 
	{ 
		
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/resource/data.properties");
		prop.load(fis);  // Load the properties file

		String ipAddress = prop.getProperty("ipAddress");
		int port = Integer.parseInt(prop.getProperty("port"));
		String DeviceName = prop.getProperty("AndoridDeviceName");
	
		
		service = new AppiumServiceBuilder().withAppiumJS(new File("C://Users//dilip.lohani//AppData//Roaming//npm//node_modules//appium//build//lib//main.js"))
	    		.withIPAddress(ipAddress).usingPort(port).build();
		//service.start();
	
		
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName(DeviceName);
		//options.setApp("C://Users//LOHANI DILIP//eclipse-workspace//Appium//src//test//java//Resource//ApiDemos-debug.apk");
		options.setApp(System.getProperty("user.dir") +"//src//test//java//apkFile//General-Store.apk" );
		driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(), options);
		
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));		
	}
	
	public List<HashMap<String, String>> getJsonData(String jsonFilePath) throws IOException
	{
			String jsonContent = FileUtils.readFileToString(new File(jsonFilePath),StandardCharsets.UTF_8);

				ObjectMapper mapper = new ObjectMapper();
				List<HashMap<String, String>> data = mapper.readValue(jsonContent,
						new TypeReference<List<HashMap<String, String>>>() {
				});

				return data;

	}
	
	
	@AfterClass(alwaysRun = true)
	public void tearDown() 
	{
				//driver.quit();	
			//	service.stop();
	}
	
	

}
