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

public class Task1_Appium {
	@Test
	public void Task_Of_HandM1() throws MalformedURLException, URISyntaxException, InterruptedException {


		DesiredCapabilities desire = new DesiredCapabilities();
		desire.setCapability("platformName", "android");
		desire.setCapability("automationName", "uiautomator2");
		desire.setCapability("deviceName", "Redmi 10");
		desire.setCapability("appPackage", "com.hm.goe");
		desire.setCapability("appActivity", "com.hm.goe.app.home.HomeActivity");
		desire.setCapability("UDID", "62e976b5");
//		desire.setCapability("app", "D:\\AppiumRecordings\\ApiDemos-debug.apk");
		URL url = new URI("http://localhost:4723").toURL();
		AndroidDriver driver = new AndroidDriver(url, desire);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	 driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.hm.goe:id/marketName\" and @text=\"India/English\"]")).click();

	 //Thread.sleep(100000);
	 driver.findElement(AppiumBy.xpath("//android.widget.Button[@resource-id=\"com.hm.goe:id/btn_accept_cookies\"]")).click();

	 driver.findElement(AppiumBy.xpath("//android.widget.Button[@resource-id=\"android:id/button2\"]")).click();
	 driver.findElement(AppiumBy.xpath("//android.view.ViewGroup[@resource-id=\"com.hm.goe:id/merch_text_container\"]")).click();
	 driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.hm.goe:id/teaserLinkTextView\" and @text=\"Men\"]")).click();
	 driver.findElement(AppiumBy.xpath("(//android.view.View[@resource-id=\"com.hm.goe:id/ptImage\"])[6]")).click();
	 driver.findElement(AppiumBy.xpath("//android.widget.FrameLayout[@content-desc=\"pdp_add_to_bag_new\"]")).click();

	 driver.findElement(AppiumBy.xpath("//android.view.ViewGroup[@resource-id=\"com.hm.goe:id/brokenOutSizeSelector\"]/android.view.View/android.view.View[3]")).click();

	 driver.findElement(AppiumBy.xpath("//android.view.ViewGroup[@resource-id=\"com.hm.goe:id/brokenOutSizeSelector\"]/android.view.View/android.view.View[8]/android.widget.Button")).click();

	
	}
}
