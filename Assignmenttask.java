package com.assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Assignmenttask {

	WebDriver driver;
	
	String [][] data= {

			{"Student","Password123"},
			{"student","Password123"},
			{"student","password123"},
			{"Student","password123"},
	};
	@DataProvider(name = "logindata")
	public String[][] name() {
		return data;
	}
	
	@BeforeMethod
	public void openbrowser() {
System.setProperty("Webdriver.chrome.driver", "C:\\Users\\Sivam\\eclipse-workspace\\com.SamTestNg\\Driver\\chromedriver.exe");
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origin=*");
		 driver = new ChromeDriver(options);
		
		driver.get("https://practicetestautomation.com/practice-test-login/");
	}
	
	
	@Test(dataProvider = "logindata")
	
	public void logn(String username, String Password) {
		WebElement user = driver.findElement(By.id("username"));
		user.sendKeys(username);
		
		WebElement pass = driver.findElement(By.id("password"));
		pass.sendKeys(Password);
		
		WebElement click = driver.findElement(By.id("submit"));
		click.click();
		
		String title =  driver.getTitle();
		
		if (title.contains("Logged In Successfully | Practice Test Automation")) {
			System.out.println("The login details are correct");
		}else {
			System.out.println("The login details are incorrect");
		}
	}
	
	@AfterMethod
	public void close() {
		driver.close();
	}
}
