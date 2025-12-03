package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import automationCore.Base;
import constants.Constant;
import pages.HomePage;
import pages.LogInPage;
import utilities.ExcelUtility;


	public class LogInTest extends Base{
		HomePage home;
		@Test (priority=1,description="user is trying to login with valied credentials",groups= {"smoke"})
		public void verifyUserLoginWithValidCredentials() throws IOException
		{
			
			String usernamevalue = ExcelUtility.readStringData(0,0,"loginSheet");
			String passwordvalue = ExcelUtility.readStringData(0,1,"loginSheet");
			LogInPage loginpage = new LogInPage(driver);
			loginpage.enterUsernameField(usernamevalue).enterPasswordField(passwordvalue);
			home=loginpage.clickSignInButton();
			Boolean adminUserDisplayed=loginpage.adminUserIsPresentOrNot();
			Assert.assertTrue(adminUserDisplayed,Constant.VALIEDCREDENTIALERROR);
		}
		
		@Test (priority=2,description="user is trying to login with invalied username and valied password",retryAnalyzer=retry.Retry.class)
		public void verifyUserLoginWithInValidUsernameValiedPaaword() throws IOException
		{
			String usernamevalue = ExcelUtility.readStringData(1, 0,"loginSheet");
			String passwordvalue = ExcelUtility.readStringData(1, 1,"loginSheet");
			LogInPage loginpage = new LogInPage(driver);
			loginpage.enterUsernameField(usernamevalue).enterPasswordField(passwordvalue).clickSignInButton();
			String expected="7rmart supermarket";
			String actual=loginpage.isTitleDisplayed();
			Assert.assertEquals(actual,expected,Constant.INVALIEDUSERNAMEERROR);
			
			
		}
		@Test (priority=3,description="user is trying to login with invalied password and valied username")
		public void verifyUserLoginWithInValidPasswordValiedUsername() throws IOException
		{
			String usernamevalue = ExcelUtility.readStringData(2, 0, "loginSheet");
			String passwordvalue = ExcelUtility.readStringData(2, 1, "loginSheet") ;
			LogInPage loginpage = new LogInPage(driver);
			loginpage.enterUsernameField(usernamevalue).enterPasswordField(passwordvalue).clickSignInButton();
			Boolean signInButtonDisplayed=loginpage.signInButtonPresentOrNot();
			Assert.assertTrue(signInButtonDisplayed,Constant.INVALIEDPASSWORDERROR);
				
			
			
			
		}
		@Test (priority=4,description="user is trying to login with invalied credentials",groups= {"smoke"},dataProvider="loginProvider")
		public void verifyUserLoginWithInValidUsernameInvaliedPassword(String usernamevalue,String passwordvalue) throws IOException
		{
			//String usernamevalue = ExcelUtility.readStringData(3, 0, "loginSheet");
			//String passwordvalue = ExcelUtility.readStringData(3, 1, "loginSheet") ;
			LogInPage loginpage = new LogInPage(driver);
			loginpage.enterUsernameField(usernamevalue).enterPasswordField(passwordvalue).clickSignInButton();
			String actualtxt=loginpage.isMessageDisplayed();
			String expectedtxt="Sign in to start your session";
			Assert.assertEquals(actualtxt,expectedtxt,Constant.INVALIEDCREDENTIALERROR);
			
			
		}
		@DataProvider(name = "loginProvider")
		public Object[][] getDataFromDataProvider() throws IOException {

		return new Object[][] { new Object[] { "admin", "admin22" }, new Object[] { "admin123", "123" },
		// new Object[] {ExcelUtility.getStringData(3,
		// 0,"Login"),ExcelUtility.getStringData(3,1 ,"Login")}
		};
		}
	}



