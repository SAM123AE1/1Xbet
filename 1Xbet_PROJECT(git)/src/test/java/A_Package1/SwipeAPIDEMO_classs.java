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

public class SwipeAPIDEMO_classs {
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
		WebElement gallery = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"Gallery\"]"));
		gallery.click();
		WebElement photos = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"1. Photos\"]"));
		photos.click();
		
		WebElement ele2 = driver.findElement(AppiumBy.xpath("//android.widget.Gallery[@resource-id=\"io.appium.android.apis:id/gallery\"]/android.widget.ImageView[2]"));
		
		
	
		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of("elementId", ((RemoteWebElement) ele2).getId(),"direction", "left", "percent", 0.5));
		WebElement elelast = driver.findElement(AppiumBy.xpath("//android.widget.Gallery[@resource-id=\"io.appium.android.apis:id/gallery\"]/android.widget.ImageView[3]"));

		
		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of("elementId", ((RemoteWebElement) elelast).getId(),"direction", "right", "percent", 0.5));
		
	}
}
