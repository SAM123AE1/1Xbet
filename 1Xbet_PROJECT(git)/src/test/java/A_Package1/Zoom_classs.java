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

public class Zoom_classs {
	@Test
	public void Zoomin() throws MalformedURLException, URISyntaxException {
		DesiredCapabilities desire = new DesiredCapabilities();
		desire.setCapability("platformName", "android");
		desire.setCapability("automationName", "uiautomator2");
		desire.setCapability("deviceName", "Redmi 10");
		desire.setCapability("appPackage", "com.davemorrissey.labs.subscaleview.sample");
		desire.setCapability("appActivity", "com.davemorrissey.labs.subscaleview.sample.MainActivity");
		desire.setCapability("UDID", "62e976b5");
		URL url = new URI("http://localhost:4723").toURL();
		AndroidDriver driver = new AndroidDriver(url, desire);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(AppiumBy
				.xpath("//android.widget.Button[@resource-id=\"com.android.permissioncontroller:id/continue_button\"]"))
				.click();
		driver.findElement(AppiumBy.xpath("//android.widget.Button[@resource-id=\"android:id/button1\"]")).click();

		driver.findElement(AppiumBy.xpath(
				"//android.widget.TextView[@resource-id=\"com.davemorrissey.labs.subscaleview.sample:id/basicFeatures\"]\r\n"
						+ ""))
				.click();

		WebElement zoomin = driver.findElement(AppiumBy.xpath(
				"		//android.view.View[@resource-id=\"com.davemorrissey.labs.subscaleview.sample:id/imageView\"]\r\n"
						+ ""));
		((JavascriptExecutor) driver).executeScript("mobile: pinchOpenGesture",
				ImmutableMap.of("elementId", ((RemoteWebElement) zoomin).getId(), "percent", 0.90,"speed",500));

		WebElement zoomout = driver.findElement(AppiumBy.xpath(
				"//android.view.View[@resource-id=\"com.davemorrissey.labs.subscaleview.sample:id/imageView\"]"));

		((JavascriptExecutor) driver).executeScript("mobile: pinchCloseGesture",
				ImmutableMap.of("elementId", ((RemoteWebElement) zoomout).getId(), "percent", 1,"speed",500));

	}
}
