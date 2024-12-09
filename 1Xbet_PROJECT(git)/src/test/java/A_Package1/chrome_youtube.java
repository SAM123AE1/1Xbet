package A_Package1;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
//through mob web application
public class chrome_youtube {
	@Test
	public void Task_Of_HandM1() throws MalformedURLException, URISyntaxException, InterruptedException {

		DesiredCapabilities desire = new DesiredCapabilities();
		desire.setCapability("platformName", "android");
		desire.setCapability("automationName", "uiautomator2");
		desire.setCapability("deviceName", "Redmi 10");
		desire.setCapability("browserName", "chrome");

		desire.setCapability("UDID", "62e976b5");
		URL url = new URI("http://localhost:4723").toURL();
		AndroidDriver driver = new AndroidDriver(url, desire);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		driver.get("http://www.youtube.com");
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//span[@class='search-bar-entry-point-text']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@name='search_query']")).sendKeys("pushpa2 trailer");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@title='Search YouTube']")).click();

		
		
	}
}
