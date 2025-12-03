package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageNewsPage {
	public WebDriver driver;
	public ManageNewsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger' and @onclick='click_button(1)']") WebElement newButtonOfManageNews;
	@FindBy(xpath="//textarea[@id='news']") WebElement newstextArea;
	@FindBy(xpath="//button[@name='create']") WebElement saveNews;
	@FindBy(xpath="//a[@onclick='click_button(2)']") WebElement searchNews;
	@FindBy(xpath="//input[@placeholder='Title']") WebElement newsToSearchArea;
	@FindBy(xpath="//button[@name='Search']") WebElement finalSearchButton;
	public ManageNewsPage clickNewManageNewsButton() {
		newButtonOfManageNews.click();
		return this;
	}
	public  ManageNewsPage enterNews(String news) {
		newstextArea.sendKeys(news);
		return this;
	}
	public ManageNewsPage clickSaveNewsButton() {
		saveNews.click();
		return this;
	}
	public ManageNewsPage clickSearchNewsButton() {
		searchNews.click();
		return this;
	}
	public ManageNewsPage enterNewsToSearch(String titleToSearch) {
		newsToSearchArea.sendKeys(titleToSearch);
		return this;
	}
	public ManageNewsPage clickFinalSearchButton() {
		finalSearchButton.click();
		return this;
	}
	public boolean textAreaDisplayedOrNot() {
		return newstextArea.isDisplayed();
		
	}
	public boolean finalSearchButtonEnabledOrNot() {
		return finalSearchButton.isEnabled();
	}

}
