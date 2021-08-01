package views;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	WebDriver driver = null;
	
	By username_txt = By.id("form-username");
	By password_txt = By.id("form-password");
	By signIn_btn = By.xpath("/html/body/div/div/div/div/div[2]/div/div[2]/form/button");
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void fillUsernameText(String username) {
		driver.findElement(username_txt).sendKeys(username);
	}
	
	public void fillPasswordText(String password) {
		driver.findElement(password_txt).sendKeys(password);
	}
	
	public void clickSignInBtn() {
		driver.findElement(signIn_btn).sendKeys(Keys.RETURN);
	}
}
