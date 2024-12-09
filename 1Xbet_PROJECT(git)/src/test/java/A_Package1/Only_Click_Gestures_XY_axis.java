package A_Package1;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;

public class Only_Click_Gestures_XY_axis {
	@Test
	public void LongclickGesture() throws MalformedURLException, URISyntaxException {
		DesiredCapabilities desire = new DesiredCapabilities();
		desire.setCapability("platformName", "android");
		desire.setCapability("automationName", "uiautomator2");
		desire.setCapability("deviceName", "Redmi 10");
		desire.setCapability("appPackage", "io.appium.android.apis");
		desire.setCapability("appActivity", "io.appium.android.apis.ApiDemos");
		desire.setCapability("UDID", "62e976b5");
//		desire.setCapability("app", "D:\\AppiumRecordings\\ApiDemos-debug.apk");
		URL url = new URI("http://localhost:4723").toURL();
		AndroidDriver driver = new AndroidDriver(url, desire);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// WebElement ele =
		// driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"Views\"]"));
//		String acttext = ele.getText();

		((JavascriptExecutor) driver).executeScript("mobile: clickGesture", ImmutableMap.of("x", 100, "y", 1281));

		//driver.quit();
	}

}
