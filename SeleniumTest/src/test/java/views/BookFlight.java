package views;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class BookFlight {
	WebDriver driver = null;
	
	By currentBooking_btn = By.xpath("//*[@id=\"navbarCollapse\"]/ul/li[1]/a");
	By bookFlights_btn = By.xpath("//*[@id=\"navbarCollapse\"]/ul/li[2]/a");
	By logout_btn = By.xpath("//*[@id=\"navbarCollapse\"]/ul/li[3]/a");
	By from_txt = By.id("osearch");
	By to_txt = By.id("dsearch");
	By departure_date = By.id("form-depart");
	By class_txt = By.id("form-class");
	By n_people_txt = By.id("form-adults");
	By search_btn = By.xpath("/html/body/div[1]/div/div/div/div/div/div[2]/form/div[3]/button");
	
	public BookFlight(WebDriver driver) {
		this.driver = driver;
	}
	
	public void fillFromText(String from) {
		driver.findElement(from_txt).sendKeys(from);
	}
	
	public void fillToText(String to) {
		driver.findElement(to_txt).sendKeys(to);
	}	
	
	public void fillDepartureDateText(String date) {
		driver.findElement(departure_date).sendKeys(date);
	}
	
	public void fillClassText(String classTxt) {
		Select classForm = new Select(driver.findElement(class_txt));
		classForm.selectByValue(classTxt);
	}
	
	public void fillNPeople(String nPeople) {
		driver.findElement(n_people_txt).sendKeys(nPeople);
	}
	
	public void clickSearchBtn() {
		driver.findElement(search_btn).sendKeys(Keys.RETURN);
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
	
	public String getErrorMessage() {
		String message = driver.findElement(from_txt).getAttribute("validationMessage");
		return message;
	}
	
}
