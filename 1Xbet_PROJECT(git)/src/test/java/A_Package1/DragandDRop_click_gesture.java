package A_Package1;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class DragandDRop_click_gesture {
	@Test
	public void doubleclick() throws MalformedURLException, URISyntaxException {
		DesiredCapabilities desire = new DesiredCapabilities();
		desire.setCapability("platformName", "android");
		desire.setCapability("automationName", "uiautomator2");
		desire.setCapability("deviceName", "Redmi 10");
		desire.setCapability("appPackage", "io.appium.android.apis");
		desire.setCapability("appActivity", "io.appium.android.apis.ApiDemos");
		desire.setCapability("UDID", "62e976b5");
		URL url = new URI("http://localhost:4723").toURL();
		AndroidDriver driver = new AndroidDriver(url, desire);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebElement ele = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"Views\"]"));

		((JavascriptExecutor) driver).executeScript("mobile: clickGesture",
				ImmutableMap.of("elementId", ((RemoteWebElement) ele)));

		WebElement dd = driver
				.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"Drag and Drop\"]"));
		((JavascriptExecutor) driver).executeScript("mobile: clickGesture",
				ImmutableMap.of("elementId", ((RemoteWebElement) dd)));

		WebElement src = driver.findElement(
				AppiumBy.xpath("//android.view.View[@resource-id=\"io.appium.android.apis:id/drag_dot_1\"]"));

		((JavascriptExecutor) driver).executeScript("mobile: dragGesture",
				ImmutableMap.of("elementId", ((RemoteWebElement) src), "endX", 500, "endY", 800, "speed", 500));

		WebElement res = driver.findElement(
				By.xpath("//android.widget.TextView[@resource-id=\"io.appium.android.apis:id/drag_result_text\"]"));

		assertEquals(res.getText(), "Dropped!");
		System.out.println(res.getText());

	}

}
