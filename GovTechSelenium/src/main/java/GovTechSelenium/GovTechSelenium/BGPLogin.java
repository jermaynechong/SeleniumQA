package GovTechSelenium.GovTechSelenium;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.FindFailed;
import org.testng.annotations.Test;
import static GovTechSelenium.GovTechSelenium.BGPRunner.*;
import static GovTechSelenium.GovTechSelenium.Constants.*;

public class BGPLogin {
	@Test(priority = 1)
	public static void login() throws InterruptedException, FindFailed {
		// TODO Auto-generated method stub

		WebElement blueLogin = driver.findElement(By.xpath("//*[@id='login-button']"));
		blueLogin.click();
		

		WebDriverWait wait = new WebDriverWait(driver, EXPLICIT_WAIT_TIME);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/form[1]/select")));

		Select loginDropdown = new Select(driver.findElement(By.xpath("/html/body/div[2]/form[1]/select")));

		loginDropdown.selectByVisibleText("S9111111A - 197702066M");

		WebElement login = driver.findElement(By.xpath("/html/body/div[2]/form[1]/button"));
		login.click();

		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*[@id='grants']/div[2]/div/a[2]/section/div")));
		WebElement newGrant = driver.findElement(By.xpath("//*[@id='grants']/div[2]/div/a[2]/section/div"));
		newGrant.click();

//		grant();

	}

	

	public static void loadingWait(WebElement spinner) {
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, 5000L);
		wait.until(ExpectedConditions.visibilityOf(spinner)); // wait for loader to appear

		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS); // wait for 3 secs
	}

	public static void goBackToHome(boolean clicked) throws FindFailed, InterruptedException {
		// TODO Auto-generated method stub

		WebDriverWait wait = new WebDriverWait(driver, EXPLICIT_WAIT_TIME);
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='bgp-navbar-collapse']/ul/li[1]/a")));
		WebElement myGrants = driver.findElement(By.xpath("//*[@id='bgp-navbar-collapse']/ul/li[1]/a"));

		Actions actions = new Actions(driver);
		actions.click(myGrants).build().perform();

		Thread.sleep(2000);

		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*[@id='grants']/div[3]/section[1]/ul/li[2]/a")));

		WebElement drafts = driver.findElement(By.xpath("//*[@id='grants']/div[3]/section[1]/ul/li[2]/a"));
		drafts.click();

		// table

		WebElement table = driver.findElement(By.xpath("//*[@id='db-apps-drafts']/tbody"));// *[@id="db-apps-drafts"]/tbody
		// To locate rows of table.
		List<WebElement> rows_table = table.findElements(By.tagName("tr"));
		// To calculate no of rows In table.
		int rows_count = rows_table.size();
		// Loop will execute till the last row of table.
		for (int row = 0; row < rows_count; row++) {
			// To locate columns(cells) of that specific row.
			List<WebElement> Columns_row = rows_table.get(row).findElements(By.tagName("td"));
			// To calculate no of columns (cells). In that specific row.
			int columns_count = Columns_row.size();

			// Loop will execute till the last cell of that specific row.
			for (int column = 0; column < columns_count; column++) {
				// To retrieve text from that specific cell.
				String celtext = Columns_row.get(column).getText();

				if (row == 0 && column == 1 && celtext.equalsIgnoreCase("untitled")) {

					WebElement found = driver.findElement(By
							.xpath("//*[@id='db-apps-drafts']/tbody/tr[" + (row + 1) + "]/td[" + (column + 1) + "]/a"));
					found.click();

					return;

				} // end if

			} // end for

		} // end for

	}

}
