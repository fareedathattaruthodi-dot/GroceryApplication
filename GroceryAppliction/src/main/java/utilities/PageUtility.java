package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {
	public void selectDragDropWithValue(WebElement element, String value) {
		Select object=new Select(element);
		object.selectByValue(value);
	}
	public void selectDragDropWithVisibleText(WebElement element,String value) {
		Select object1=new Select(element);
		object1.selectByContainsVisibleText(value);
	}
	public void selectDragDropWithIndex(WebElement element,int value) {
		Select object2=new Select(element);
		object2.selectByIndex(value);
		}
	public void selectCheckBox(WebElement element) {
		element.click();
		System.out.println(element.isSelected());
	}
	public void selectRadioButton(WebElement element) {
		element.click();
		System.out.println(element.isSelected());
		
	}
	public void scrollDown(WebElement element) {
		WebDriver driver=new ChromeDriver();
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,350)", "");
	}
	

}
