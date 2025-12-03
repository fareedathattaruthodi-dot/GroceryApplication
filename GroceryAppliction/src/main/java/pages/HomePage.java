package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	public WebDriver driver;
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(xpath="//img[@class='img-circle']") WebElement adminbutton;
	@FindBy(xpath="//a[contains(@href,'com/admin/logout')and @class='dropdown-item']") WebElement logoutbutton;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin' and @class='small-box-footer']") WebElement moreinfoAdminUser;
	@FindBy(xpath="//a[@class='small-box-footer' and @href='https://groceryapp.uniqassosiates.com/admin/list-news']") WebElement moreinfoManageNews;
	@FindBy(xpath="//a[text()='Home']") WebElement homeicon;
     public HomePage adminIconClick() {
	adminbutton.click();
	return this;
	
       }
         public LogInPage logoutButtonClick() {
	     logoutbutton.click();
	     return new LogInPage(driver);
}
        
         public AdminUserPage clickMoreInfoAdminUser() {
        	 moreinfoAdminUser.click();
        	 return new AdminUserPage(driver);
         }
         public ManageNewsPage clickMoreInfoManageNews() {
        	 moreinfoManageNews.click();
        	 return new ManageNewsPage(driver);
         }
         public String isHomeIconDisplayed() {
        	 return homeicon.getText();
         }
	

}

