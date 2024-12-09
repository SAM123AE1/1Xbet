package A_Package1;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class A_class1 {
	@Test
	public void CalculatorTest() throws MalformedURLException, URISyntaxException {
		DesiredCapabilities desire = new DesiredCapabilities();
		desire.setCapability("platformName", "android");
		desire.setCapability("automationName", "uiautomator2");
		desire.setCapability("deviceName", "Redmi 10");
		desire.setCapability("UDID", "62e976b5");
		// if in device if it is asking for any permissions
//		desire.setCapability("noReset","true");
//		desire.setCapability("ignoreHiddenapiPolicyError","true");
//		desire.setCapability("autoGrantPermission","true");
       //bcz url is deprecated so we are getting to URI converting
		//adb shell dumpsys window | find "mCurrentFocus"
		desire.setCapability("appPackage", "com.xiaomi.calendar");
		desire.setCapability("appActivity", "com.android.calendar.homepage.AllInOneActivity");
		URL url = new URI("http://localhost:4723").toURL();
		AndroidDriver driver=new AndroidDriver(url,desire);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
	//  driver.findElement(AppiumBy.xpath("com.miui.calculator:id/ic_float_btn")).click();
		driver.findElement(AppiumBy.xpath("//android.view.View[@content-desc=\"20 November 2024 ( according to lunar calendar).Wednesday\"]")).click();
//		driver.findElement(AppiumBy.xpath("//android.widget.ImageView[@content-desc=\"plus\"]")).click();
//		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.miui.calculator:id/btn_2_s\"]")).click();
//		driver.findElement(AppiumBy.xpath("//android.widget.ImageView[@content-desc=\"equals\"]")).click();

	}

}
