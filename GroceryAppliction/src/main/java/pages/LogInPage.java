package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitUtility;

public class LogInPage {
	public WebDriver driver;
	WaitUtility wait=new WaitUtility();
	public LogInPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
		
	}
	@FindBy(name="username") WebElement user;
	@FindBy(name="password") WebElement pass;
	@FindBy(tagName="button") WebElement signin;
	@FindBy(xpath="//p[text()='Admin Users']") WebElement adminuser;
	@FindBy(xpath="//b[text()='7rmart supermarket']") WebElement titlelogin;
	@FindBy(xpath="//p[text()='Sign in to start your session']") WebElement textmessage;
	
	
	
	
	public LogInPage enterUsernameField(String usernamevalue)
	{
		user.sendKeys(usernamevalue);
		return this;
	}
	public LogInPage enterPasswordField(String passwordvalue)
	{
		pass.sendKeys(passwordvalue);
		return this;
	}
	public HomePage clickSignInButton()
	{
		wait.waitUntilElementToBeClickable(driver,signin);
		signin.click();
		return new HomePage(driver);
	}
	public boolean adminUserIsPresentOrNot() {
		return adminuser.isEnabled();
		
	}
	public String isTitleDisplayed() {
		return titlelogin.getText();
	}
	public boolean signInButtonPresentOrNot() {
		return signin.isDisplayed();
	}
	public String isMessageDisplayed() {
		return textmessage.getText();
	}

}
