package A_Package1;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class AlTasks {
	
	@Test
	public void Task_Of_HandM2() throws MalformedURLException, URISyntaxException, InterruptedException {

		DesiredCapabilities desire = new DesiredCapabilities();
		desire.setCapability("platformName", "android");
		desire.setCapability("automationName", "uiautomator2");
		desire.setCapability("deviceName", "Redmi 10");
		desire.setCapability("appPackage", "com.hm.goe");
		desire.setCapability("appActivity", "com.hm.goe.app.home.HomeActivity");
		desire.setCapability("UDID", "62e976b5");
		desire.setCapability("unlockType", "pattern");
		desire.setCapability("unlockKey", "425863179");
		//desire.setCapability("app", "D:\\AppiumRecordings\\ApiDemos-debug.apk");
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
		Thread.sleep(4000);
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
		driver.quit();
	}

	@Test
	public void task() throws MalformedURLException, URISyntaxException {
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
		driver.findElement(AppiumBy.xpath("//android.widget.ImageButton[@content-desc=\"Your Shopping Bag\"]")).click();
		// scroll
		driver.findElement(AppiumBy.androidUIAutomator(
				"new UiScrollable(new UiSelector()).scrollIntoView(text(\"Loose Fit Sweatshirt\"));"));

		WebElement ele1 = driver.findElement(
				AppiumBy.xpath("(//android.view.View[@resource-id=\"com.hm.goe:id/ptImage\"])[1]/android.view.View"));
		((JavascriptExecutor) driver).executeScript("mobile: doubleClickGesture",
				ImmutableMap.of("elementId", ((RemoteWebElement) ele1).getId(), "duration", 2000));
		WebElement zoomin = driver
				.findElement(AppiumBy.xpath("//android.widget.ImageView[@content-desc=\"Product Image\"]"));

		((JavascriptExecutor) driver).executeScript("mobile: pinchOpenGesture",
				ImmutableMap.of("elementId", ((RemoteWebElement) zoomin).getId(), "percent", 1, "speed", 500));
		WebElement zoomout = driver
				.findElement(AppiumBy.xpath("//android.widget.ImageView[@content-desc=\"Product Image\"]"));

		((JavascriptExecutor) driver).executeScript("mobile: pinchCloseGesture",
				ImmutableMap.of("elementId", ((RemoteWebElement) zoomout).getId(), "percent", 1, "speed", 500));
		driver.quit();
	}

	@Test
	public void TC_04() throws MalformedURLException, URISyntaxException, AWTException, InterruptedException

	{
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

		/** search for a product */
		driver.findElement(AppiumBy.id("com.hm.goe:id/action_search_button")).click();

		((JavascriptExecutor) driver).executeScript("mobile: clickGesture", ImmutableMap.of("x", 239, "y", 1366));

		WebElement searchbox = driver.findElement(AppiumBy.xpath("//android.widget.EditText"));
		searchbox.sendKeys("jeans for men");

		Actions actions = new Actions(driver);

		actions.moveToElement(searchbox).sendKeys(Keys.ENTER).perform();

		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Product\"]")).click();
		/* product */
		driver.findElement(AppiumBy.xpath("(//android.widget.TextView[@text=\"Straight Regular Jeans\"])[2]")).click();
		
		Thread.sleep(2000);
		driver.findElement(AppiumBy.xpath("//android.widget.FrameLayout[@content-desc=\"pdp_add_to_bag_new\"]")).click();
		
		driver.findElement(AppiumBy.xpath("//android.view.ViewGroup[@resource-id=\"com.hm.goe:id/brokenOutSizeSelector\"]/android.view.View/android.view.View[12]")).click();
		Thread.sleep(2000);
		
		driver.findElement(AppiumBy.xpath("//android.view.ViewGroup[@resource-id=\"com.hm.goe:id/brokenOutSizeSelector\"]/android.view.View/android.view.View[17]/android.widget.Button")).click();
driver.quit();
	}
	
	@Test(enabled=false)
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
		driver.findElement(
				AppiumBy.xpath("//android.view.ViewGroup[@resource-id=\"com.hm.goe:id/merch_text_container\"]"))
				.click();
		driver.findElement(AppiumBy.xpath(
				"//android.widget.TextView[@resource-id=\"com.hm.goe:id/teaserLinkTextView\" and @text=\"Men\"]"))
				.click();
		driver.findElement(AppiumBy.xpath("(//android.view.View[@resource-id=\"com.hm.goe:id/ptImage\"])[6]")).click();

		driver.findElement(AppiumBy.accessibilityId("pdp_add_to_bag_new")).click();

		driver.findElement(AppiumBy.xpath(
				"//android.view.ViewGroup[@resource-id=\"com.hm.goe:id/brokenOutSizeSelector\"]/android.view.View/android.view.View[3]"))
				.click();

		driver.findElement(AppiumBy.xpath(
				"//android.view.ViewGroup[@resource-id=\"com.hm.goe:id/brokenOutSizeSelector\"]/android.view.View/android.view.View[8]/android.widget.Button"))
				.click();
		 driver.quit();
	}

}
