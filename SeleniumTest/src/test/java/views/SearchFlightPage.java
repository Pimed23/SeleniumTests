package views;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class SearchFlightPage {
	
	WebDriver driver = null;
	
	By currentBooking_btn = By.xpath("//*[@id=\"navbarCollapse\"]/ul/li[1]/a");
	By bookFlights_btn = By.xpath("//*[@id=\"navbarCollapse\"]/ul/li[2]/a");
	By logout_btn = By.xpath("//*[@id=\"navbarCollapse\"]/ul/li[3]/a");
	By select_btn = By.xpath("/html/body/div/section/table/tbody/tr/td[7]/input");
	
	public SearchFlightPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickCurrentBookingBtn() {
		driver.findElement(currentBooking_btn).sendKeys(Keys.RETURN);
	}
	
	public void clickBookFlightsBtn() {
		driver.findElement(bookFlights_btn).sendKeys(Keys.RETURN);
	}
	
	public void clickLogOutBtn() {
		driver.findElement(logout_btn).sendKeys(Keys.RETURN);
	}
	
	public void clickSelectBtn() {
		driver.findElement(select_btn).sendKeys(Keys.RETURN);
	}

}
