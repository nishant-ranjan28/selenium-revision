package com.test.selenium;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LinkTest {

	static WebDriver driver = null;

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("Browser Successfully launched");

		String url = "https://www.javatpoint.com";
		driver.get(url);

		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println(links.size());
		
		EventFiringWebDriver edriver = new EventFiringWebDriver(driver);
		File screenshot = edriver.getScreenshotAs(OutputType.FILE);
		
//		//File Utils uses copyFil method to store the screenshot
//		FileUtils.copyFile(screenshot, new File("test.png"));
		
		//File Handler uses copy method to store the screenshot
		FileHandler.copy(screenshot, new File("test.png"));
		
		Thread.sleep(5000);
		
		driver.close();
	}

}
