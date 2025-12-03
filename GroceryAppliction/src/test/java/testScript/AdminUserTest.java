package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
import constants.Constant;
import pages.AdminUserPage;
import pages.HomePage;
import pages.LogInPage;
import utilities.ExcelUtility;
import utilities.RandomDataUtility;

public class AdminUserTest extends Base{
	HomePage homepage;
	AdminUserPage adminuserpage;
	@Test (description="user is able to be added by providing credentials")
	public void verifyUserIsAbleToAddNewAdminUser() throws IOException {
		String usernamevalue = ExcelUtility.readStringData(0,0,"loginSheet");
		String passwordvalue = ExcelUtility.readStringData(0,1,"loginSheet");
		
		LogInPage loginpage = new LogInPage(driver);
		loginpage.enterUsernameField(usernamevalue).enterPasswordField(passwordvalue);
		homepage=loginpage.clickSignInButton();
		adminuserpage=homepage.clickMoreInfoAdminUser();
		RandomDataUtility randomdatautility=new RandomDataUtility();
		String usertext=randomdatautility.randomUserName();
		String passtext=randomdatautility.randomPassWord();
		adminuserpage.clickNewButton().typeUserName(usertext).typePassWord(passtext).selectUserType().clickSaveButton();
		
		Boolean saveEnabled=adminuserpage.saveButtonIsEnabledOrNot();
		Assert.assertTrue(saveEnabled,Constant.DISABLEDSAVEBUTTONERROR);
	}
	@Test (description="user can search the newly added user details")
 public void verifyWhetherUserIsAbleToSearchNewlyAddedUser() throws IOException {
		
	 String usernamevalue = ExcelUtility.readStringData(0,0,"loginSheet");
		String passwordvalue = ExcelUtility.readStringData(0,1,"loginSheet");
		
		LogInPage loginpage = new LogInPage(driver);
		loginpage.enterUsernameField(usernamevalue).enterPasswordField(passwordvalue);
		homepage=loginpage.clickSignInButton();
		adminuserpage=homepage.clickMoreInfoAdminUser();
		String texttosearch=ExcelUtility.readStringData(0, 0,"adminuserSheet");
		adminuserpage.clickSearchButton().typeUserNameToSearch(texttosearch).selectSearchUserType().clickFinalSearchButton();
		Boolean resetButtonDisplayed=adminuserpage.resetButtonIsDisplayedOrNot();
		Assert.assertTrue(resetButtonDisplayed,Constant.RESETBUTTONNOTFOUNDERROR);
		
	}
	@Test (description="user is able to reset the users list")
	public void verifyWetherUserIsAbleToResetTheUsersList() throws IOException {
		 String usernamevalue = ExcelUtility.readStringData(0,0,"loginSheet");
			String passwordvalue = ExcelUtility.readStringData(0,1,"loginSheet");
			LogInPage loginpage = new LogInPage(driver);
			loginpage.enterUsernameField(usernamevalue).enterPasswordField(passwordvalue);
			homepage=loginpage.clickSignInButton();
			adminuserpage=homepage.clickMoreInfoAdminUser();
			adminuserpage.clickResetButton();
			Boolean resetButtonDisplayed=adminuserpage.resetButtonIsDisplayedOrNot();
			Assert.assertTrue(resetButtonDisplayed,Constant.RESETBUTTONNOTFOUNDERROR);
		
	}
		
		
	 
 

}
