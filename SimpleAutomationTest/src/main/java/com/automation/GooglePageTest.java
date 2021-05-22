package com.automation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GooglePageTest {
	
	public final String USER_DIR = System.getProperty("user.dir");
	public final String FILE_SEPARATOR = System.getProperty("file.separator");
	public final String PATH_TO_DRIVERS =  USER_DIR + FILE_SEPARATOR + "drivers" + FILE_SEPARATOR;
	public WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		System.out.println("OPENING THE BROWSER");
		System.setProperty("webdriver.chrome.driver", PATH_TO_DRIVERS + "chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	
	@Test
	public void checkThePageTitle() {
		driver.get("https://www.google.com");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		String actualPageTitle = driver.getTitle();
		Assert.assertEquals(actualPageTitle, "Google", "Page Title is Incorrect");
		System.out.println("PAGE TITLE IS "+actualPageTitle);
	}
	
	@AfterMethod
	public void teardown() {
		System.out.println("CLOSING THE BROWSER");
		driver.quit();
	}

}
