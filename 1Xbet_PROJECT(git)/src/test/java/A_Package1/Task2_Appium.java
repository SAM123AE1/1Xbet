package A_Package1;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class Task2_Appium {
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
		driver.findElement(AppiumBy.xpath(
				"//android.widget.TextView[@resource-id=\"com.hm.goe:id/marketName\" and @text=\"India/English\"]"))
				.click();

		
		driver.findElement(AppiumBy.xpath("//android.widget.Button[@resource-id=\"com.hm.goe:id/btn_accept_cookies\"]"))
				.click();

		driver.findElement(AppiumBy.xpath("//android.widget.Button[@resource-id=\"android:id/button2\"]")).click();

		driver.findElement(AppiumBy.androidUIAutomator(
				"new UiScrollable(new UiSelector()).scrollIntoView(text(\"Dressed for the holidays\"));")).click();
		WebElement elewant = driver.findElement(AppiumBy
				.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"3-pack hair clips\"));"));
				elewant.click();
				String exptext = elewant.getText();

		WebElement ele1 = driver
				.findElement(AppiumBy.xpath("//android.widget.ImageView[@content-desc=\"Product Image\"]"));
		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture",
				ImmutableMap.of("elementId", ((RemoteWebElement) ele1).getId(), "direction", "left", "percent", 1));

		WebElement ele2 = driver
				.findElement(AppiumBy.xpath("//android.widget.ImageView[@content-desc=\"Product Image\"]"));
		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture",
				ImmutableMap.of("elementId", ((RemoteWebElement) ele2).getId(), "direction", "right", "percent", 1));
		driver.findElement(AppiumBy.xpath("//android.widget.FrameLayout[@content-desc=\"pdp_add_to_bag_new\"]"))
				.click();

		driver.findElement(
				AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.hm.goe:id/hm_shoppingbag_count\"]"))
				.click();
		String acttext = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"3-pack hair clips\"]"))
				.getText();
		assertEquals(exptext, acttext);
		System.out.println("Product added sucessfully");

	}
}
