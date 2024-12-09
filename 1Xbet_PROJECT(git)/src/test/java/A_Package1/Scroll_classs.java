package A_Package1;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class Scroll_classs {
	@Test
	public void Zoomin() throws MalformedURLException, URISyntaxException {


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
		WebElement ele = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"Views\"]"));
		ele.click();
		
		/*
		 * boolean canScrollMore = (Boolean) ((JavascriptExecutor)
		 * driver).executeScript("mobile: scrollGesture", ImmutableMap.of( "left", 100,
		 * "top", 100, "width", 100, "height", 1200, "direction", "down", "percent",
		 * 1,"speed",500)); if(canScrollMore) { System.out.println(canScrollMore); }
		 */
		//scroll upto Tabs and click
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Tabs\"));")).click();
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"3. Content By Intent\"]")).click();
		//driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(""))"))
	}
}
