package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.PageUtility;

public class AdminUserPage {
	public WebDriver driver;
	PageUtility page=new PageUtility();
	public AdminUserPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
		
		@FindBy(xpath="//a[@class='btn btn-rounded btn-danger' and text()=' New']") WebElement newbutton;
		@FindBy(xpath="//input[@type='text' and @id='username']") WebElement usernametext;
		@FindBy(xpath="//input[@type='password' and @id='password']") WebElement passwordtext;
		@FindBy(xpath="//select[@id='user_type']") WebElement usertype;
		@FindBy(xpath="//button[@type='submit' and @name='Create']") WebElement savebutton;
		@FindBy(xpath="//a[@class='btn btn-rounded btn-primary' and text()=' Search']") WebElement searchbutton;
		@FindBy(xpath="//input[@type='text' and @id='un']") WebElement searchuser;
		@FindBy(xpath="//select[@class='form-control' and @id='ut']") WebElement searchtype;
		@FindBy(xpath="//button[@class='btn btn-block-sm btn-danger' and @value='sr']") WebElement finalsearchbutton;
		@FindBy(xpath="//a[@class='btn btn-rounded btn-warning' and text()=' Reset']") WebElement resetbutton;
		public  AdminUserPage clickNewButton() {
			newbutton.click();
			return this;
		}
		public AdminUserPage typeUserName(String usertext) {
			usernametext.sendKeys(usertext);
			return this;
			
		}
		public AdminUserPage typePassWord(String passtext) {
			passwordtext.sendKeys(passtext);
			return this;
		}
		public AdminUserPage selectUserType()
		{
			page.selectDragDropWithVisibleText(usertype, "Admin");
			Select selecttype=new Select(usertype);
			selecttype.selectByVisibleText("Admin");
			return this;
			
		}
		public AdminUserPage clickSaveButton() {
			savebutton.click();
			return this;
		}
		public AdminUserPage clickSearchButton() {
			searchbutton.click();
			return this;
		}
		public AdminUserPage typeUserNameToSearch(String texttosearch) {
			searchuser.sendKeys(texttosearch);
			return this;
		}
		public AdminUserPage selectSearchUserType() {
			page.selectDragDropWithVisibleText(searchtype, "Admin");;
			Select selectsearchtype=new Select(searchtype);
			selectsearchtype.selectByVisibleText("Admin");
			return this;
		}
		public AdminUserPage clickFinalSearchButton() {
			finalsearchbutton.click();
			return this;
		}
		public AdminUserPage clickResetButton() {
			resetbutton.click();
			return this;
		}
		public boolean saveButtonIsEnabledOrNot() {
			return savebutton.isEnabled();
		}
		
		
		public boolean resetButtonIsDisplayedOrNot() {
			return resetbutton.isDisplayed();
		}
			
	
		
		

}

