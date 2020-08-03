package com.test.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.assertthat.selenium_shutterbug.utils.web.Browser;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * Unit test for simple App.
 */

public class AppTest {

	static WebDriver driver = null;

	public static void main(String[] args) throws InterruptedException {

		browserURL();
		//radioButton();
		//selectText();
		//dropDown();
		//countiFrame();
		switchFrame();

	}

	public static void browserURL() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("Browser Successfully launched");

		String url = "https://www.rahulshettyacademy.com/AutomationPractice";
		driver.get(url);
		System.out.println("URL detected");
	}

	public static void radioButton() throws InterruptedException {

		driver.findElement(By.xpath("//div[@id='radio-btn-example']//label[1]//input[1]")).isDisplayed();
		System.out.println("Radio button1 is present");
		driver.findElement(By.xpath("//div[@id='radio-btn-example']//label[1]//input[1]")).click();


		driver.findElement(By.xpath("//div[@id='radio-btn-example']//label[2]//input[1]")).isDisplayed();
		System.out.println("Radio button2 is present");
		driver.findElement(By.xpath("//div[@id='radio-btn-example']//label[2]//input[1]")).click();

		//driver.close();
	}

	public static void selectText() throws InterruptedException {
		driver.findElement(By.xpath("//input[@id='autocomplete']")).click();
		driver.findElement(By.xpath("//input[@id='autocomplete']")).sendKeys("NY");
		System.out.println("value entered");

		driver.findElement(By.xpath("//input[@id='autocomplete']")).sendKeys(Keys.ARROW_DOWN);
		driver.findElement(By.xpath("//input[@id='autocomplete']")).sendKeys(Keys.ENTER);
		System.out.println("value selected");

		//driver.close();
	}

	public static void dropDown() throws InterruptedException {
		driver.findElement(By.xpath("//select[@id='dropdown-class-example']")).click();
		Browser.wait(500);
		driver.findElement(By.xpath("//option[contains(text(),'Option1')]")).click();
		System.out.println("dropdown entered");

		//driver.close();
	}

	public static void countiFrame() throws InterruptedException {
		//by executing find all
//		List<WebElement> iframeElements = driver.findElements(By.tagName("iframe"));
//		System.out.println("The total number of iframes are " + iframeElements.size());
		
		//by running javascript executor
		JavascriptExecutor exe = (JavascriptExecutor) driver;
		Integer numberOfFrames = Integer.parseInt(exe.executeScript("return window.length").toString());
		System.out.println("Number of iframes on the page are " + numberOfFrames);

		driver.close();
	}
	
	public static void switchFrame() throws InterruptedException{
		driver.switchTo().frame(driver.findElement(By.id("courses-iframe")));
		System.out.println("frame switched");
		driver.findElement(By.xpath("//a[contains(text(),'Register')]")).isEnabled();
		System.out.println("element found");
		driver.close();
	}
}
