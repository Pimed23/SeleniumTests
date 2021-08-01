package views;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class HomePage {
	
	WebDriver driver = null;
	
	By logo_btn = By.xpath("/html/body/header/nav/a/img[1]");
	By home_btn = By.xpath("//*[@id=\"navbarCollapse\"]/ul/li[1]/a");
	By login_btn = By.xpath("//*[@id=\"navbarCollapse\"]/ul/li[2]/a");
	By book_flight_btn = By.xpath("//*[@id=\"navbarCollapse\"]/ul/li[3]/a");
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickLogoBtn() {
		driver.findElement(logo_btn).sendKeys(Keys.RETURN);
	}
	
	public void clickHomeBtn() {
		driver.findElement(home_btn).sendKeys(Keys.RETURN);
	}
	
	public void clickLoginBtn() {
		driver.findElement(login_btn).sendKeys(Keys.RETURN);
	}
	
	public void clickBookFlightBtn() {
		driver.findElement(book_flight_btn).sendKeys(Keys.RETURN);
	}
	
}
