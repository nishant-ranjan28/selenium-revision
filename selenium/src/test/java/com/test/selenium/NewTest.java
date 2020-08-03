package com.test.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NewTest {

	static WebDriver driver = null;

	@Test(priority=1)
	public void LaunchBrowser() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("Browser launched successfull with URL");
		String url = "https://google.com";
		driver.get(url);
		System.out.println("URL detected");
		driver.close();
	}
}
