package AppiumDriverutility_appium;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class AndroidDriverclass {
	public AndroidDriver driver;

	public void waitForPageToLoad(AndroidDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	public void waitForElementPresent(AndroidDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public int switchbetweenContext(AndroidDriver driver, String text) throws InterruptedException {
		Set<String> allcontext = driver.getContextHandles();
		int count = allcontext.size();
		Thread.sleep(3000);
		for (String win : allcontext) {
			if (win.contains(text)) {
				driver.context(text);
			}
		}
		return count;

	}

	public void scrollText(String text) {
		driver.findElement(
				AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+text+"\"));"))
				.click();

	}
	
	public void swipeleft(WebElement ele)
	{
		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of("elementId", ((RemoteWebElement) ele).getId(),"direction", "left", "percent", 1));

	}
	public void swipeRight(WebElement ele)
	{
		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of("elementId", ((RemoteWebElement) ele).getId(),"direction", "right", "percent", 1));

	}

}
