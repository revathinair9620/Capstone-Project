package com.capstone.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.capstone.qa.base.TestBase;

public class TestUtil extends TestBase {

	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 20;

	public static String TESTDATA_SHEET_PATH = "C:\\Users\\Sam\\eclipse-workspace\\AdactinHotelwebsite\\src\\main\\java\\com\\adactinhotel"
			+ "\\qa\\testdata\\adactinhotelTestData.xlsx";

	static Workbook book;
	static Sheet sheet;

	public static Object[][] getTestData(String sheetName) {
		FileInputStream file = null;
		try {
			file = new FileInputStream(TESTDATA_SHEET_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		// System.out.println(sheet.getLastRowNum() + "--------" +
		// sheet.getRow(0).getLastCellNum());
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
				// System.out.println(data[i][k]);
			}
		}
		return data;
	}
	// Get the current date
	// SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
	// Date date = new Date();
	// String currentDate = dateFormat.format(date);

	// Get the current date
	public static String getCurrentDate() {
        LocalDate currentDate = LocalDate.now();
        return String.valueOf(currentDate.getDayOfMonth());
    }
	
	LocalDate currentDate = LocalDate.now();
	LocalDate currentDatePlus2Days = currentDate.minusDays(2);
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	protected String formattedDate = currentDate.format(formatter);
	protected String formattedCurrentDatePlus2Days = currentDatePlus2Days.format(formatter);

	public static void drawBorder(WebElement element, WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.border='3px solid red'", element);

	}

	public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
	}

	public static void waitUntilElementClickable(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public static void waitUntilPageLoad() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.urlToBe("https://adactin.capstonesystemdev.com.au/dashboard"));
	}

	public static void waitUntilElementVisible(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(500));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	// function create an alert message when error is there
	public static void generateAlert(WebDriver driver, String message) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("alert('" + message + "')");
	}

	// function to read the entire page text
	public static String getPageInnerText(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String pageText = js.executeScript("return document.documentElement.innerText;").toString();
		return pageText;
	}

	// function to scroll
	public static void scrollPageDown(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");

	}

	public static void scrollVertically(WebDriver driver, int pixels) {
		try {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(arguments[0],0)", pixels);}
		catch(Exception e){
			System.out.println("Vertical scroll is not working" +e.getMessage());
			
		}
	}

	public static void waitUntilPageRefresh() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2000));
		// Execute JavaScript to monitor the page state
		JavascriptExecutor js = (JavascriptExecutor) driver;
		boolean isPageLoaded = (boolean) js.executeScript("return document.readyState").equals("complete");

		// If the page is not yet loaded, wait until it's complete
		if (!isPageLoaded) {
			wait.until(webDriver -> js.executeScript("return document.readyState").equals("complete"));
		}

	}

	// function to scrollIntoView
	public static void scrollIntoView(WebElement element, WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);

	}

	// Create FluentWait instance with timeout of 30 seconds and polling interval of
// 2 seconds
	public static WebElement waitForElement(WebElement element, Duration timeout, Duration pollingInterval) {
		Wait<WebDriver> wait = new FluentWait<>(driver).withTimeout(timeout).pollingEvery(pollingInterval);

		return wait.until(ExpectedConditions.elementToBeClickable(element));
	}

//	public static void ClickOn(WebDriver driver, WebElement locator, Duration timeout) {
//	new WebDriverWait(driver, timeout).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(locator));
//	locator.click();
//
//}

}
