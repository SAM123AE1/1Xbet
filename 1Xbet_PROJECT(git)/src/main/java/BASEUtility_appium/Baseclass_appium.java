package BASEUtility_appium;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import AppiumDriverutility_appium.AndroidDriverclass;
import Genericutility_appium.PropertyFiledata_class;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class Baseclass_appium {

	public PropertyFiledata_class pobj = new PropertyFiledata_class();
	public DesiredCapabilities desire;
	public AndroidDriver driver;
	public AppiumDriverLocalService service;
	 public AndroidDriverclass dlib=new AndroidDriverclass();

	@BeforeSuite
	public void BeforeSuite() throws IOException, URISyntaxException {

		File f = new File("C:\\Users\\kmyas\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js");

		service = new AppiumServiceBuilder().withAppiumJS(f).withIPAddress("127.0.0.1").usingPort(4723)
				.withTimeout(Duration.ofMinutes(5)).build();
		service.start();
		

	}

	@BeforeClass
	public void BeforeClass() throws URISyntaxException, IOException {

		desire = new DesiredCapabilities();
		desire.setCapability("platformName", pobj.getdatafromPF("platformName"));
		desire.setCapability("automationName", pobj.getdatafromPF("automationName"));
		desire.setCapability("deviceName", pobj.getdatafromPF("deviceName"));
//		desire.setCapability("appPackage", pobj.getdatafromPF("appPackage"));
//		desire.setCapability("appActivity", pobj.getdatafromPF("appActivity"));
		desire.setCapability("UDID", pobj.getdatafromPF("UDID"));
//		desire.setCapability("autoGrantPermission", pobj.getdatafromPF("autoGrantPermission"));
//		desire.setCapability("noReset", pobj.getdatafromPF("noReset"));
		// desire.setCapability("appinstall", pobj.getdatafromPF("appinstall"));

		driver = new AndroidDriver(new URI("http://localhost:4723").toURL(), desire);
		driver.activateApp(pobj.getdatafromPF("appPackage"));

	}
	@AfterClass
	public void afterClass()
	{
		
	}
	
	@AfterSuite
	public void afterSuite()
	{
		service.stop();
	}

	

}
