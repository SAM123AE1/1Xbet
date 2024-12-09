package ObjectRepo_appium;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Xbet_LoginPage {
	AndroidDriver driver;

	public Xbet_LoginPage(AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);

	}

	@AndroidFindBy(xpath = "//android.widget.ScrollView/android.view.View[1]/android.widget.CheckBox")
	private WebElement PhoneTab;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Phone number\"]")
	private WebElement Phntextfield;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Password\"]")
	private WebElement Pwdtextfield;
	@AndroidFindBy(xpath = "//android.widget.ScrollView/android.view.View[6]/android.widget.Button")
	private WebElement loginBtn;

	public WebElement getPhoneTab() {
		return PhoneTab;
	}
	public WebElement getPhntextfield() {
		return Phntextfield;
	}
	public WebElement getPwdtextfield() {
		return Pwdtextfield;
	}
	public WebElement getLoginBtn() {
		return loginBtn;
	}
	public void Logintoapp(String phno,String pwd) throws InterruptedException
	{
		Thread.sleep(3000);
		PhoneTab.click();
		Thread.sleep(3000);
		Phntextfield.sendKeys(phno);
		
		Pwdtextfield.sendKeys(pwd);
		loginBtn.click();
		
		
	}

}
