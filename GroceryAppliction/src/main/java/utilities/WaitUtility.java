package utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtility {
	public static int EXPLICITWAIT=5;
	public void waitUntilElementToBeClickable(WebDriver driver, WebElement element) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICITWAIT));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	public void waitUntillAlertIsPresent(WebDriver driver,WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICITWAIT));
		wait.until(ExpectedConditions.alertIsPresent());
		
	}
	public void waitUntillElementToBeSelected(WebDriver driver,WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICITWAIT));
		wait.until(ExpectedConditions.elementToBeSelected(element));
		}
	public void waitUntillNoOfElementsToBeTwo(WebDriver driver,String element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICITWAIT));
		wait.until(ExpectedConditions.numberOfElementsToBe(By.id(element), 2));
		
	}
	public void waitUntillUrlToBe(WebDriver driver, String url) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICITWAIT));
		wait.until(ExpectedConditions.urlToBe(url));
		
	}
	public void waitUntillVisibilityOfElementLocated(WebDriver driver,String id) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICITWAIT));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(" idname")));
		
	}

}
