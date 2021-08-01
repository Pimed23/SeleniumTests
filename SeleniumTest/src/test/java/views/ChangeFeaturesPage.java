package views;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class ChangeFeaturesPage {
	
	WebDriver driver = null;
	
	By logOut_btn = By.xpath("//*[@id=\"list-tab\"]/a[3]");
	
	
	public ChangeFeaturesPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickLogOutBtn() {
		driver.findElement(logOut_btn).sendKeys(Keys.RETURN);
	}
}
