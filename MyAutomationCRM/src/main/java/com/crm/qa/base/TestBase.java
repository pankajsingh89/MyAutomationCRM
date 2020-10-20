package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.qa.util.Util;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;

	public TestBase() {

		prop = new Properties();

		try {

			FileInputStream io = new FileInputStream(
					"E:\\MavenWork\\MyAutomationCRM\\src\\main\\" + "java\\com\\crm\\qa\\config\\config.properties");
			prop.load(io);

		} catch (FileNotFoundException e) {
			e.printStackTrace();

		} catch (IOException e) {
			e.printStackTrace(); // this is updated
		}
	}

	public static void intialization() {

		String browserName = prop.getProperty("browser");

		if (browserName.equals("firefox")) {

			System.setProperty("webdriver.gecko.driver", "E:\\drivers\\geckodriver.exe");
			driver = new FirefoxDriver();

		} else if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "E:\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();

		}

		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Util.LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Util.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();

		driver.get(prop.getProperty("url"));
	}

}
