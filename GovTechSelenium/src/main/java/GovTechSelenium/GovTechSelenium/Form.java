package GovTechSelenium.GovTechSelenium;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Key;
import org.sikuli.script.Screen;
import org.testng.Assert;
import org.testng.annotations.Test;
import static GovTechSelenium.GovTechSelenium.BGPRunner.*;
import static GovTechSelenium.GovTechSelenium.Constants.*;
import static GovTechSelenium.GovTechSelenium.BGPLogin.*;
import static GovTechSelenium.GovTechSelenium.Proposal.*;

public class Form {
	
	@Test(priority = 1)
	public static void grant() throws InterruptedException, FindFailed {
		// TODO Auto-generated method stub
		// BGPRunner app= new BGPRunner();
		WebDriverWait wait = new WebDriverWait(driver, EXPLICIT_WAIT_TIME);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("item")));
		List<WebElement> options = driver.findElements(By.className("itemname"));

		for (WebElement opt : options) {
			String sectorName = opt.getText();

			if (sectorName.equals("Building & Construction")) {
				opt.click();

				WebElement buldConst = driver.findElement(By
						.xpath("//*[@id='grant-wizard']/div[1]/div/div[3]/div[1]/div/div/ul/li[1]/div/label/div/div"));
				buldConst.click();
				break;
			}

		}

		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@id='grant-wizard']/div[1]/div/div/div[2]/div/label/div/div")));

		WebElement selectGrant = driver
				.findElement(By.xpath("//*[@id='grant-wizard']/div[1]/div/div/div[2]/div/label/div/div"));

		selectGrant.click();
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS); // wait for 1 secs
		List<WebElement> items = driver.findElements(By.className("itemname"));

		for (WebElement item : items) {
			String itemName = item.getText();
			if (itemName.equals("Pre-scoped Productivity Solutions")) {

				item.click();
				break;
			}

		}

		Thread.sleep(2000);

		WebElement applyButton = driver.findElement(By.id("go-to-grant"));
		applyButton.click();

		Thread.sleep(2000);

		WebElement proceedButton = driver.findElement(By.id("keyPage-form-button"));

		proceedButton.click();

//		eligibility();

	} // end grant

	@Test(priority = 2)
	public static void eligibility() throws InterruptedException, FindFailed {
		// TODO Auto-generated method stub
		boolean clicked = true;
		// Proposal prop = new Proposal();
		// Form form = new Form();
		// BGPRunner app= new BGPRunner();
		Thread.sleep(2000);

		WebDriverWait wait = new WebDriverWait(driver, EXPLICIT_WAIT_TIME);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='radio'][value='false']")));
		WebElement noRadioButton = driver.findElement(By.cssSelector("input[type='radio'][value='false']"));
		noRadioButton.click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='https://smeportal.sg/content/smeportal/en/moneymatters.html#saText']")));
		if (noRadioButton.isSelected()) {
			WebElement adv = driver.findElement(By.xpath("//a[@href='https://smeportal.sg/content/smeportal/en/moneymatters.html#saText']"));
			adv.click();

			Thread.sleep(2000);

			Set<String> allWindows = driver.getWindowHandles();

			List<String> stringsList = new ArrayList(allWindows);
			driver.switchTo().window(stringsList.get(1));
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

//			driver.switchTo().window(stringsList.get(1)).close();
			
//			if (driver.getTitle().equalsIgnoreCase("Untitled")) {
//
//				driver.switchTo().window(stringsList.get(0));
//			}
			
			String url = driver.getCurrentUrl();

			driver.switchTo().window(stringsList.get(0));

			// Assert.assertNotEquals(url,
			// "https://www.smeportal.sg/content/smeportal/en/moneymatters.html");

			// test here

			if (clicked == true) {

				WebElement saveButton = driver.findElement(By.id("save-btn"));
				saveButton.click();

				Thread.sleep(2000);

				goBackToHome(clicked);

				WebElement proceedButton = driver.findElement(By.xpath("//*[@id='keyPage-form-button']"));
				proceedButton.click();

				Thread.sleep(5000);

				wait.until(ExpectedConditions
						.visibilityOfElementLocated(By.cssSelector("input[type='radio'][value='true']")));
				WebElement yesRadioButton = driver.findElement(By.cssSelector("input[type='radio'][value='true']"));

				Thread.sleep(1000);
				yesRadioButton.click();

				if (yesRadioButton.isSelected()) {

					WebElement nextButton = driver.findElement(By.id("next-btn"));
					nextButton.click();
					WebElement spinner = driver.findElement(By.xpath("//*[@id=\"js-app\"]"));
					loadingWait(spinner);
//					Form.form();

				}

			} // end else

		}

	}
	@Test(priority = 3)
	public static void form() throws InterruptedException, FindFailed {
		// TODO Auto-generated method stub
		// Proposal prop = new Proposal();
		// BGPRunner app= new BGPRunner();

		boolean clicked = true;
		System.out.println("the boolean value now is" + clicked);
		WebDriverWait wait = new WebDriverWait(driver, EXPLICIT_WAIT_TIME);

		WebElement name = driver.findElement(By.id("react-contact_info-name"));
		wait.until(ExpectedConditions.visibilityOf(name));
		name.clear();
		name.sendKeys("Jermayne Chong");

		WebElement jobTitle = driver.findElement(By.id("react-contact_info-designation"));
		jobTitle.clear();
		jobTitle.sendKeys("Developer");

		WebElement contactNo = driver.findElement(By.id("react-contact_info-phone"));
		contactNo.clear();
		contactNo.sendKeys("123456789");

		WebElement email = driver.findElement(By.id("react-contact_info-primary_email"));
		email.clear();
		email.sendKeys("jermayne_chong@hotmail.com");

		WebElement altEmail = driver.findElement(By.id("react-contact_info-secondary_email"));
		altEmail.clear();
		altEmail.sendKeys("jer_chong@gmail.com");

		WebElement postalCode = driver.findElement(By.id("react-contact_info-correspondence_address-postal"));
		postalCode.sendKeys("734683");
		Thread.sleep(1000);

		WebElement level = driver.findElement(By.id("react-contact_info-correspondence_address-level"));
		level.sendKeys("1");

		WebElement unit = driver.findElement(By.id("react-contact_info-correspondence_address-unit"));
		unit.sendKeys("01-12");

		WebElement buildingName = driver.findElement(By.id("react-contact_info-correspondence_address-building_name"));
		buildingName.sendKeys("Woodlands");

		WebElement checkbox = driver.findElement(By.id("react-contact_info-copied"));
		checkbox.click();

		WebElement nextButton = driver.findElement(By.id("next-btn"));
		nextButton.click();

		WebElement spinner = driver.findElement(By.xpath("//*[@id=\"js-app\"]"));

		// wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/div[2]/div[3]")));

		loadingWait(spinner);
		//proposal();
	}
	
	
	@Test(priority = 4)
	public static void proposal() throws InterruptedException, FindFailed {
		Thread.sleep(2000);
		// TODO Auto-generated method stub
		// BGPRunner app= new BGPRunner();

		WebDriverWait wait = new WebDriverWait(driver, EXPLICIT_WAIT_TIME);

		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.id("react-project-psg_category_id-ekZJg2e7dT1YBT8LtbjL42RS")));
		WebElement equipmentRadio = driver.findElement(By.id("react-project-psg_category_id-ekZJg2e7dT1YBT8LtbjL42RS"));

		WebElement itRadio = driver.findElement(By.id("react-project-psg_category_id-HJfTcAoAFJW2B9A6oqe297Ls"));

		equipmentRadio.click();

		if (equipmentRadio.isSelected()) {

			WebElement searchBox = driver
					.findElement(By.xpath("//*[@id='react-select-project-psg_solution_id--value']/div[1]"));

			Actions action = new Actions(driver);
			searchBox.click();

			// action.click(searchBox);
			driver.switchTo().activeElement().sendKeys("Wire Saw" + Keys.RETURN);

			WebElement noUnits = driver.findElement(By.id("react-project-no_of_units"));
			noUnits.sendKeys("3");

			commonFields();

			WebElement projRefNo = driver.findElement(By.id("react-project-locations-0-project_ref_num"));
			projRefNo.sendKeys("A1234-000001-2011");

			WebElement projAddr = driver.findElement(By.id("react-project-locations-0-text_address"));
			projAddr.sendKeys("12345ref address");

			WebElement cost = driver.findElement(By.id("react-project-locations-0-estimated_cost"));
			cost.sendKeys("100");
			WebElement contractorYes = driver
					.findElement(By.id("react-project-locations-0-main_contractor_check-true"));
			contractorYes.click();

			WebElement nextButton = driver.findElement(By.id("next-btn"));
			nextButton.click();

			WebElement spinner = driver.findElement(By.xpath("//*[@id=\"js-app\"]"));
			loadingWait(spinner);

	//		cost();

		}
	}// end proposal

	public static void commonFields() throws FindFailed, InterruptedException {
		// TODO Auto-generated method stub
		WebElement datePicker = driver.findElement(By.id("react-project-start_date"));

		String pattern = "dd MMM yyyy";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

		String date = simpleDateFormat.format(new Date());
		
		datePicker.sendKeys(date);

		WebElement eqYes = driver.findElement(By.id("react-project-engaged_status-true"));
		eqYes.click();

		WebElement eqNo = driver.findElement(By.id("react-project-engaged_status-false"));
		eqNo.click();

		String reason = "e.g. To reduce the number of workers that are needed to do the job";
		WebElement reasonTextArea = driver.findElement(By.id("react-project-reason_for_engagement"));
		reasonTextArea.sendKeys(reason);

		WebElement singRadio = driver.findElement(By.id("react-project-vendors-0-local_vendor-true"));
		singRadio.click();
		WebElement vendor = driver.findElement(By.id("react-project-vendors-0-name"));
		vendor.sendKeys("associate");
		vendor.sendKeys(Keys.ENTER);

		WebDriverWait wait = new WebDriverWait(driver, EXPLICIT_WAIT_TIME);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='vendor-row-sub']")));
		WebElement vendorName = driver.findElement(By.xpath("//*[@id='vendor-row-sub']"));
		vendorName.click();

		WebElement vendorTextArea = driver.findElement(By.id("react-project-vendors-0-vendor_reason"));
		vendorTextArea.sendKeys("whatever reason");

		WebElement vendorEquip = driver.findElement(By.id("react-project-vendors-0-vendor_products"));
		vendorEquip.sendKeys("whatever eq desc");

		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS); // wait for 3 secs
		// handle upload
		WebElement uploadButton = driver.findElement(By.id("react-project-vendors-0-attachments-btn"));
		uploadButton.click();

		Thread.sleep(2000);
		Screen s = new Screen();
		s.type(null, "C:\\Users\\642124\\Documents\\testExcel.xlsx", 0);

		s.type(Key.ENTER);
		Thread.sleep(5000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@id='react-select-project-vendors-0-attachments-0-document_type-types--value']/div[1]")));
		WebElement tagDoc = driver.findElement(
				By.xpath("//*[@id='react-select-project-vendors-0-attachments-0-document_type-types--value']/div[1]"));

		tagDoc.click();

		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*/div[contains(text(),'Other supporting documents')]")));

		WebElement tagDocText = driver.findElement(By.xpath("//*/div[contains(text(),'Other supporting documents')]"));

		tagDocText.click();

		Actions action = new Actions(driver);
		WebElement tagLabel = driver
				.findElement(By.xpath("//*[@id='react-project-vendors-0-attachments-0-document_type-types-label']"));
		action.moveToElement(tagLabel).click();

		Thread.sleep(2000);
		WebElement remarks = driver.findElement(By.id("react-project-vendors-0-quote_remarks"));
		remarks.sendKeys("any remarks");

		Thread.sleep(5000);
		// handle upload
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("react-project-locations-0-attachments-btn")));
		WebElement locUploadButton = driver.findElement(By.id("react-project-locations-0-attachments-btn"));
		locUploadButton.click();

		Thread.sleep(2000);
		s.type(null, "C:\\Users\\642124\\Documents\\testExcel.xlsx", 0);
		s.type(Key.ENTER);
		Thread.sleep(2000);

		// 2nd tag doc

		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath("//*[@id='react-select-project-locations-0-attachments-0-document_type-types--value']/div[1]")));
		WebElement tagDoc2 = driver.findElement(By
				.xpath("//*[@id='react-select-project-locations-0-attachments-0-document_type-types--value']/div[1]"));

		tagDoc2.click();

		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//*/div[contains(text(),'Letter of Award')]")));

		WebElement tagDoc2Text = driver.findElement(By.xpath("//*/div[contains(text(),'Letter of Award')]"));
		tagDoc2Text.click();

		WebElement tagLabel2 = driver
				.findElement(By.xpath("//*[@id='react-project-locations-0-attachments-0-document_type-types-label']"));
		action.moveToElement(tagLabel2).click();

	}// end commonField

	@Test(priority = 5)
	private static void cost() throws InterruptedException {
		// TODO Auto-generated method stub
//		BGPRunner app = new BGPRunner();

		Thread.sleep(15000);
		WebDriverWait wait = new WebDriverWait(driver, EXPLICIT_WAIT_TIME);
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@id='react-select-project_cost-psg_payment_mode_id--value']/div[1]")));
		WebElement purchaseBox = driver
				.findElement(By.xpath("//*[@id='react-select-project_cost-psg_payment_mode_id--value']/div[1]"));

		Actions action = new Actions(driver);

		purchaseBox.click();

		WebElement purchaseBoxText = driver.findElement(By.xpath("//*/div[contains(text(),'Direct')]"));

		purchaseBoxText.click();

		WebElement costBillCurr = driver.findElement(By.id("react-project_cost-cost_in_billing_currency"));
		costBillCurr.sendKeys("200");

		WebElement costOTBillCurr = driver.findElement(By.id("react-project_cost-ot_cost_in_billing_currency"));
		costOTBillCurr.sendKeys("300");

		WebElement nextButton = driver.findElement(By.id("next-btn"));
		nextButton.click();

		WebElement spinner = driver.findElement(By.xpath("//*[@id=\"js-app\"]"));

		loadingWait(spinner);

//		businessImpact();
	}

	@Test(priority = 6)
	public static void businessImpact() throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverWait wait = new WebDriverWait(driver, EXPLICIT_WAIT_TIME);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("react-project_impact-impact_description")));

		WebElement impDesc = driver.findElement(By.id("react-project_impact-impact_description"));
		impDesc.sendKeys("some description");

		WebElement impTaskDesc = driver.findElement(By.id("react-project_impact-task_description"));
		impTaskDesc.sendKeys("some impact task description");

		WebElement measUnit = driver.findElement(By.id("react-project_impact-task_unit"));
		measUnit.sendKeys("km");
		WebElement unitDoneNow = driver.findElement(By.id("react-project_impact-task_now"));
		unitDoneNow.sendKeys("10");

		WebElement unitDoneEq = driver.findElement(By.id("react-project_impact-task_after"));
		unitDoneEq.sendKeys("20");

		WebElement workersNow = driver.findElement(By.id("react-project_impact-task_no_workers_now"));
		workersNow.sendKeys("5");

		WebElement workersAfter = driver.findElement(By.id("react-project_impact-task_no_workers_after"));
		workersAfter.sendKeys("7");

		WebElement manDaysNow = driver.findElement(By.id("react-project_impact-task_no_man_days_now"));
		manDaysNow.sendKeys("5");

		WebElement manDaysAfter = driver.findElement(By.id("react-project_impact-task_no_man_days_after"));
		manDaysAfter.sendKeys("7");

		WebElement nextButton = driver.findElement(By.id("next-btn"));
		nextButton.click();

//		review();

	}

	@Test(priority = 7)
	public static void review() {
		// TODO Auto-generated method stub
//		BGPRunner app = new BGPRunner();
		WebDriverWait wait = new WebDriverWait(driver, EXPLICIT_WAIT_TIME);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.id("react-declaration-criminal_liability_check-false")));

		WebElement crimCheckbox = driver.findElement(By.id("react-declaration-criminal_liability_check-false"));
		crimCheckbox.click();

		WebElement suitCheckbox = driver.findElement(By.id("react-declaration-civil_proceeding_check-false"));
		suitCheckbox.click();
		WebElement insolCheckbox = driver.findElement(By.id("react-declaration-insolvency_proceeding_check-false"));
		insolCheckbox.click();

		WebElement forthCheckbox = driver.findElement(By.id("react-declaration-project_incentives_check-false"));
		forthCheckbox.click();

		WebElement fifthCheckbox = driver.findElement(By.id("react-declaration-project_commence_check-false"));
		fifthCheckbox.click();

		WebElement sixthCheckbox = driver.findElement(By.id("react-declaration-related_party_check-false"));
		sixthCheckbox.click();

		WebElement seventhCheckbox = driver.findElement(By.id("react-declaration-defray_cost_check-false"));
		seventhCheckbox.click();

		WebElement ackCheckbox = driver.findElement(By.id("react-declaration-consent_acknowledgement_check"));
		ackCheckbox.click();

		WebElement reviewButton = driver.findElement(By.id("review-btn"));
		reviewButton.click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"js-app\"]")));

		WebElement spinner = driver.findElement(By.xpath("//*[@id=\"js-app\"]"));
		loadingWait(spinner);

	}
}

	// Assert.assertEquals("true",checkbox.getAttribute("checked"));


