package com.fitness.mavenproject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RubixCube {
	WebDriver driver;

	@BeforeTest
	public void Launch_Browser() throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(co);
		driver.manage().window().maximize();
		driver.get("https://www.selenium.dev/downloads/");
		Thread.sleep(2000);
	}

	@Test
	public void Page_Scroll() throws InterruptedException {
		WebElement ch = driver.findElement(By.linkText("Chrome"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView()", ch);
		System.out.println(ch.getText());
		Thread.sleep(2000);
		
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		Thread.sleep(2000);
		
		js.executeScript("window.scrollTo(0,-document.body.scrollHeight)");
		Thread.sleep(2000);
	}
}
