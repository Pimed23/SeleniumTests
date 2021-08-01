package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import views.BookFlight;
import views.ChangeFeaturesPage;
import views.HomePage;
import views.LoginCustomerPage;
import views.LoginPage;
import views.SearchFlightPage;

public class LoginTests {
	
	WebDriver driver = null;
	String projectPath = System.getProperty("user.dir");
	
	String userAdmin = "haris@admin.com";
	String userManager = "haris@manager.com";
	String userCustomer = "shariq@customer.com";
	String passAdmin = "a";
	String passManager = "m";
	String passCustomer = "c";
	
	@Parameters("browserName")
	@BeforeTest
	public void setUpDriver(String browserName) {
		
		if(browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", projectPath + "\\drivers\\chrome\\chromedriver.exe");
			driver = new ChromeDriver();
		
		} else if(browserName.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver", projectPath + "\\drivers\\edge\\msedgedriver.exe");
			driver = new EdgeDriver();
		}
	}
	
	@Test(groups= {"login"})
	public void loginUserValidAndPassValid() {
		
		// Calling the view
		HomePage homePageObj = new HomePage(driver);
		LoginPage loginPageObj = new LoginPage(driver);
		ChangeFeaturesPage changeFeaturesObj = new ChangeFeaturesPage(driver);
		
		driver.get("http://localhost:8080/TurkishAirlines/");
		homePageObj.clickLoginBtn();
		loginPageObj.fillUsernameText(userAdmin);
		loginPageObj.fillPasswordText(passAdmin);
		loginPageObj.clickSignInBtn();
		Assert.assertEquals(driver.getTitle(), "Admin Portal");
		changeFeaturesObj.clickLogOutBtn();
	}
	
	@Test(groups= {"login"})
	public void loginUserValidAndPassInvalid() {
		
		// Calling the view
		HomePage homePageObj = new HomePage(driver);
		LoginPage loginPageObj = new LoginPage(driver);
		
		driver.get("http://localhost:8080/TurkishAirlines/");
		homePageObj.clickLoginBtn();
		loginPageObj.fillUsernameText(userAdmin);
		loginPageObj.fillPasswordText("InvalidPass");
		loginPageObj.clickSignInBtn();
		Assert.assertEquals(driver.getTitle(), "Error Page");
	}
	
	@Test(groups= {"login"})
	public void loginUserInvalidAndPassValid() {
		
		// Calling the view
		HomePage homePageObj = new HomePage(driver);
		LoginPage loginPageObj = new LoginPage(driver);

		driver.get("http://localhost:8080/TurkishAirlines/");
		homePageObj.clickLoginBtn();
		loginPageObj.fillUsernameText("InvalidUser@admin.com");
		loginPageObj.fillPasswordText(passAdmin);
		loginPageObj.clickSignInBtn();
		Assert.assertEquals(driver.getTitle(), "Error Page");
	}
	
	@Test(groups= {"flights"})
	public void searchNewFlight() {
		
		// Calling the view
		HomePage homePageObj = new HomePage(driver);
		LoginPage loginPageObj = new LoginPage(driver);
		LoginCustomerPage customerPageObj = new LoginCustomerPage(driver);
		BookFlight bookFlightObj = new BookFlight(driver);
		SearchFlightPage searchFlightObj = new SearchFlightPage(driver);
		
		driver.get("http://localhost:8080/TurkishAirlines/");
		homePageObj.clickLoginBtn();
		loginPageObj.fillUsernameText(userCustomer);
		loginPageObj.fillPasswordText(passCustomer);
		loginPageObj.clickSignInBtn();
		customerPageObj.clickBookFlightsBtn();
		bookFlightObj.fillFromText("London");
		
		bookFlightObj.fillToText("Peru");
		bookFlightObj.fillDepartureDateText("04/04/2021");
		bookFlightObj.fillClassText("Economy");
		bookFlightObj.fillNPeople("1");
		bookFlightObj.clickSearchBtn();
		Assert.assertEquals(driver.getTitle(), "Show Flights");
		searchFlightObj.clickLogOutBtn();
	}
	
	@Test(groups= {"flights"})
	public void fillTheBlanks() {
		
		HomePage homePageObj = new HomePage(driver);
		LoginPage loginPageObj = new LoginPage(driver);
		LoginCustomerPage customerPageObj = new LoginCustomerPage(driver);
		BookFlight bookFlightObj = new BookFlight(driver);
		
		driver.get("http://localhost:8080/TurkishAirlines/");
		homePageObj.clickLoginBtn();
		loginPageObj.fillUsernameText(userCustomer);
		loginPageObj.fillPasswordText(passCustomer);
		loginPageObj.clickSignInBtn();
		customerPageObj.clickBookFlightsBtn();
		bookFlightObj.clickSearchBtn();
		Assert.assertEquals(bookFlightObj.getErrorMessage(), "Please fill out this field.");
		bookFlightObj.clickLogOutBtn();
	}
	
	
	@AfterTest
	public void destroidTest() {
		
		driver.close();
		driver.quit();
		System.out.println("Test completed sucessfully!!!");
	}
}
