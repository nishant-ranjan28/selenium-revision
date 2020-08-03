package com.test.selenium;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleWindow {

	public static void main(String[] args) throws InterruptedException {
		browserURL();
		Window();
	}

	static WebDriver driver = null;

	public static void browserURL() throws InterruptedException {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		System.out.println("Browser Successfully launched");

		// PageScreenshot.TakeFullScreenshot(driver);
	}

	public static void Window() throws InterruptedException {
		String url = "https://demoqa.com/browser-windows";
		driver.get(url);
		// Get Window Details
		String parentWindowHandle = driver.getWindowHandle();
		System.out.println("Parent window's handle -> " + parentWindowHandle);
		System.out.println("URL detected");

//		// Scroll the page
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("window.scrollBy(0,250)");

		WebElement clickElement = driver.findElement(By.id("windowButton"));

		for (int i = 0; i < 3; i++) {
			clickElement.click();
			Thread.sleep(3000);
		}

		// Get All open window details
		Set<String> allWindowHandles = driver.getWindowHandles();
		String lastWindowHandle = "";

		//Open Multiple Window with loop. (Same Link)
		/*
		 *
		 * for(String handle : allWindowHandles) {
		 * System.out.println("Window handle - > " + handle); }
		 */

		for (String handle : allWindowHandles) {
			System.out.println("Switching to window - > " + handle);
			System.out.println("Navigating to google.com");
			driver.switchTo().window(handle); // Switch to the desired window first and then execute commands using
												// driver
			driver.get("http://google.com");
			lastWindowHandle = handle;
		}
		
		//Switch to parent window
		driver.switchTo().window(parentWindowHandle);
		driver.close();
		//No focused window, explicitly switching back.
		driver.switchTo().window(lastWindowHandle);
		driver.get(url);
		System.out.println("Back to base");
	}
}