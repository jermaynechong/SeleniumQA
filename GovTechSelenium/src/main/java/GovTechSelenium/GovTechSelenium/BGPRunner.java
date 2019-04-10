package GovTechSelenium.GovTechSelenium;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.FindFailed;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;


public class BGPRunner {
	public static WebDriver driver;

	@BeforeSuite
	public static void setUp() {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\642124\\eclipse-workspace\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://public:Let$BeC001@bgp-qa.gds-gov.tech");

	}

	@AfterSuite
	public static void tearDown() {
		//driver.close();
	}

	// public static void main(String[] args) throws InterruptedException,
	// FindFailed {
	// MainApp app= new MainApp();
	// app.launch();
	// app.login();
	//
	//
	// }

}
