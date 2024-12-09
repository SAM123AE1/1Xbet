package AppiumDriverutility_appium;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class From_BrowserStack {

	@Test
	public void From_Browstack() throws MalformedURLException, URISyntaxException {
			String u="http://yashawanthkm_lD2z5T:n3yF9Jk8vFj4yyDbymH8@hub-cloud.browserstack.com/wd/hub";

		DesiredCapabilities capabilities = new DesiredCapabilities();

		HashMap<String, Object> bstackOptions = new HashMap<String, Object>();
		bstackOptions.put("userName", "yashawanthkm_lD2z5T");
		bstackOptions.put("accessKey", "n3yF9Jk8vFj4yyDbymH8");
		bstackOptions.put("appiumVersion", "1.17.0");
		bstackOptions.put("projectName", "AppiumDemo");
		bstackOptions.put("buildName", "1.0.2");
		bstackOptions.put("sessionName", "Login");
		bstackOptions.put("debug", "true");
		bstackOptions.put("networkLogs", "true");
		bstackOptions.put("appProfiling", "true");
		capabilities.setCapability("platformName", "android");
		capabilities.setCapability("appium:platformVersion", "12.0");
		capabilities.setCapability("appium:deviceName", "Samsung Galaxy S22 Ultra");
		capabilities.setCapability("appium:app", "bs://e834024fc3e119c876962efda40d4904370b19e9");
		capabilities.setCapability("bstack:options", bstackOptions);
		URL url = new URI(u).toURL();

		AndroidDriver driver = new AndroidDriver(url, capabilities);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
		driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/spinnerCountry")).click();
		driver.findElement(
				AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"India\"));"))
				.click();
		driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/nameField")).sendKeys("Yash");
		driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnLetsShop")).click();

		
	}
}
