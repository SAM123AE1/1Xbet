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

public class Double_click_gesture {
	@Test
	public void doubleclick() throws MalformedURLException, URISyntaxException {
		DesiredCapabilities desire = new DesiredCapabilities();
		desire.setCapability("platformName", "android");
		desire.setCapability("automationName", "uiautomator2");
		desire.setCapability("deviceName", "Redmi 10");
		desire.setCapability("appPackage", "com.example.payment_gateway");
		desire.setCapability("appActivity", "com.example.payment_gateway.MainActivity");
		desire.setCapability("UDID", "62e976b5");
		URL url = new URI("http://localhost:4723").toURL();
		AndroidDriver driver = new AndroidDriver(url, desire);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		((JavascriptExecutor) driver).executeScript("mobile: clickGesture", ImmutableMap.of("x", 151, "y", 600));

		WebElement ele1 = driver.findElement(AppiumBy.xpath("//android.widget.ImageView"));
		((JavascriptExecutor) driver).executeScript("mobile: doubleClickGesture",
				ImmutableMap.of("elementId", ((RemoteWebElement) ele1).getId(), "duration", 2000));
		driver.quit();

	}

}
