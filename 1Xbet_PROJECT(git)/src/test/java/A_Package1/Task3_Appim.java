package A_Package1;

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

public class Task3_Appim {
	
	@Test
	public void task() throws MalformedURLException, URISyntaxException
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
		driver.findElement(AppiumBy.xpath("//android.widget.ImageButton[@content-desc=\"Your Shopping Bag\"]")).click();
		//scroll
		driver.findElement(AppiumBy.androidUIAutomator(
				"new UiScrollable(new UiSelector()).scrollIntoView(text(\"Loose Fit Sweatshirt\"));"));
		
		
			WebElement ele1 = driver.findElement(AppiumBy.xpath("(//android.view.View[@resource-id=\"com.hm.goe:id/ptImage\"])[1]/android.view.View"));
			((JavascriptExecutor) driver).executeScript("mobile: doubleClickGesture",
					ImmutableMap.of("elementId", ((RemoteWebElement) ele1).getId(), "duration", 2000));
			WebElement zoomin = driver.findElement(AppiumBy.xpath(
					"//android.widget.ImageView[@content-desc=\"Product Image\"]"));

			((JavascriptExecutor) driver).executeScript("mobile: pinchOpenGesture",
					ImmutableMap.of("elementId", ((RemoteWebElement) zoomin).getId(), "percent", 1,"speed",500));
			WebElement zoomout= driver.findElement(AppiumBy.xpath(
					"//android.widget.ImageView[@content-desc=\"Product Image\"]"));

			((JavascriptExecutor) driver).executeScript("mobile: pinchCloseGesture",
					ImmutableMap.of("elementId", ((RemoteWebElement) zoomout).getId(), "percent", 1,"speed",500));

		
		}

}
