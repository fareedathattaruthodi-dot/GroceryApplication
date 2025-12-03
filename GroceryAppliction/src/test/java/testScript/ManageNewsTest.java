package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
import constants.Constant;
import pages.HomePage;
import pages.LogInPage;
import pages.ManageNewsPage;
import utilities.ExcelUtility;

public class ManageNewsTest extends Base{
	 ManageNewsPage managenewspage;
	 HomePage homepage;
	@Test (description="user is able to add latest news")
	public void verifyUserIsAbleToAddNewNews() throws IOException {
	
	String usernamevalue = ExcelUtility.readStringData(0,0,"loginSheet");
	String passwordvalue = ExcelUtility.readStringData(0,1,"loginSheet");
	
    LogInPage loginpage = new LogInPage(driver);
	loginpage.enterUsernameField(usernamevalue).enterPasswordField(passwordvalue);
	homepage=loginpage.clickSignInButton();
	  managenewspage= homepage.clickMoreInfoManageNews();
   String news=ExcelUtility.readStringData(1,0,"newsSheet");
    managenewspage.clickNewManageNewsButton().enterNews(news).clickSaveNewsButton();
    Boolean textAreaDisplayed=managenewspage.textAreaDisplayedOrNot();
    Assert.assertTrue(textAreaDisplayed, Constant.TEXTAREANOTFOUNDERROR);
    

}
	@Test (description="user is able to search news title")
	public void verifyUserIsAbleToSearchNewsTitle() throws IOException {
		String usernamevalue = ExcelUtility.readStringData(0,0,"loginSheet");
		String passwordvalue = ExcelUtility.readStringData(0,1,"loginSheet");

		LogInPage loginpage = new LogInPage(driver);
		loginpage.enterUsernameField(usernamevalue).enterPasswordField(passwordvalue);
		homepage=loginpage.clickSignInButton();
		
	   managenewspage= homepage.clickMoreInfoManageNews();
	   String titleToSearch=ExcelUtility.readStringData(1,0,"newsSheet");
	    managenewspage.clickSearchNewsButton().enterNewsToSearch(titleToSearch).clickFinalSearchButton();
	    Boolean finalSearchButtonEnabled=managenewspage.finalSearchButtonEnabledOrNot();
	    Assert.assertTrue(finalSearchButtonEnabled, Constant.SEARCHBUTTONERROR);
		
	}
}
