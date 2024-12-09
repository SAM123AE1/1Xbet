package A_Package1;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class GeneralStore_ {
	@Test
	public void Task_Of_HandM1() throws MalformedURLException, URISyntaxException, InterruptedException {

		DesiredCapabilities desire = new DesiredCapabilities();
		desire.setCapability("platformName", "android");
		desire.setCapability("automationName", "uiautomator2");
		desire.setCapability("deviceName", "Redmi 10");
		desire.setCapability("appPackage", "com.androidsample.generalstore");
		desire.setCapability("appActivity", "com.androidsample.generalstore.MainActivity");
		desire.setCapability("UDID", "62e976b5");
		
		
		
		
		URL url = new URI("http://localhost:4723").toURL();
		AndroidDriver driver = new AndroidDriver(url, desire);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		// click on dd
		driver.findElement(AppiumBy.id("android:id/text1")).click();
		driver.findElement(
				AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"India\"));"))
				.click();
		driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/nameField")).sendKeys("Yash");
		driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnLetsShop")).click();

		// select pro and click on add to cart
		driver.findElement(AppiumBy.xpath(
				"//android.widget.TextView[@text='Air Jordan 1 Mid SE']/..//(//android.widget.TextView[@resource-id=\"com.androidsample.generalstore:id/productAddCart\"])[2]\r\n"
						+ ""))
				.click();
		// click on cart icon
		driver.findElement(AppiumBy.xpath(
				"//android.widget.ImageButton[@resource-id=\"com.androidsample.generalstore:id/appbar_btn_cart\"]"))
				.click();
		Thread.sleep(3000);

		driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnProceed")).click();
Thread.sleep(3000);
		Set<String> googlepage = driver.getContextHandles();
		int count = googlepage.size();
		System.out.println(count);
		Thread.sleep(2000);
		for (String s : googlepage) {
			System.out.println(s);
			if (s.contains("WEBVIEW_")) {
				Thread.sleep(2000);
				driver.context(s);
				System.out.println("++++++++'''''''''"+s);
			}
		}
		Thread.sleep(2000);

		System.out.println("===========" + driver.getTitle());
		driver.findElement(By.name("q")).sendKeys("selenium and appium diff");
		Thread.sleep(2000);

		driver.terminateApp("com.androidsample.generalstore");

	}
}
