package ObjectRepo_appium;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Xbet_WelcomePage {
	AndroidDriver driver;
	public Xbet_WelcomePage(AndroidDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver),this);
		
	}
	
	@AndroidFindBy(xpath="//v0.t0/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View[8]/android.view.View[1]/android.widget.Button")
	private WebElement Loginbtn;

	@AndroidFindBy(xpath="//v0.t0/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View[8]/android.view.View[2]/android.widget.Button")
	private WebElement RegistrationBtn;
	public WebElement getLoginbtn() {
		return Loginbtn;
	}

	public WebElement getRegistrationBtn() {
		return RegistrationBtn;
	}
	public void click_on_Loginbtn()
	{
		Loginbtn.click();
		RegistrationBtn.click();
	}
		
}
