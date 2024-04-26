package com.capstone.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.capstone.qa.util.TestUtil;



public class TestBase {
	public static WebDriver driver;
	public static Properties prop;

	public TestBase() {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					"C:\\Users\\Sam\\eclipse-workspace\\CapstoneProject\\src\\main"
					+ "\\java\\com\\capstone\\qa\\config\\config.properties"); // loc of config prop file
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("deprecation")
	public static void initialization() {
		// WebDriver driver= new HtmlUnitDriver();//used for headless browser exe need
		// to add htmlunit driver jar files
		String browserName = prop.getProperty("browser");

		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Sam\\Downloads\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications"); // to disable all popups and alerts

			/*
			 * options.addArguments("window-size=1400,800");//headless browser
			 * options.addArguments("headless");//headless browser
			 */
			driver = new ChromeDriver(options);

		} else if (browserName.equalsIgnoreCase("FF")) {
			System.setProperty("webdriver.gecko.driver", "C:\\browserdrivers\\chromedriver.exe");
			//driver = new FirefoxDriver();
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

		driver.get(prop.getProperty("url"));
		// Execute JavaScript to set the zoom level to 73%
	    

		/*
		 * try { TestUtil.takeScreenshotAtEndOfTest(); } catch (IOException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 */
	}

	public static void takeScreenshotOfFailedTest(String testMethodName) throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(scrFile,
				new File(currentDir + "/screenshots/" + System.currentTimeMillis() + testMethodName + ".png"));
	}

}
