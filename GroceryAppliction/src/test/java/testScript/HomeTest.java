package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
import constants.Constant;
import pages.HomePage;
import pages.LogInPage;
import utilities.ExcelUtility;


public class HomeTest extends Base {
	HomePage homepage;

	@Test (description="user is able to logout after login with credentials")
	
	public void verifyWhetherUserIsAbleToSuccessfullyLoggedOut() throws IOException
	{
		String groceryusernamevalue = ExcelUtility.readStringData(0, 0, "loginSheet");
		String grocerypasswordvalue = ExcelUtility.readStringData(0, 1, "loginSheet");
		LogInPage loginpage = new LogInPage(driver);
		loginpage.enterUsernameField(groceryusernamevalue).enterPasswordField(grocerypasswordvalue);
		homepage=loginpage.clickSignInButton();
		
		homepage.adminIconClick();
		loginpage=homepage.logoutButtonClick();
		String expected="7rmart supermarket";
		String actual=loginpage.isTitleDisplayed();
		Assert.assertEquals(actual,expected,Constant.LOGOUTERROR);
		
		
		
	}
	
}
