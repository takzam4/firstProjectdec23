package com.codefios.ebilling.smoke;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddAccountTest {

	static WebDriver driver;

	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\zaman\\Desktop\\Selenium\\EBilling\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.codefios.com/ebilling/login");

	}

	private static void login() throws InterruptedException {

		driver.findElement(By.id("user_name")).sendKeys("demo@codefios.com");
		driver.findElement(By.id("password")).sendKeys("abc123");
		driver.findElement(By.id("login_submit")).click();
		Thread.sleep(1000);

	}

	@After
	public void teradown() throws InterruptedException { 
		
		driver.close();
		Thread.sleep(1000);
	}
	
	@Test
	public void addAccount() throws InterruptedException { 
		
		login();
		
		driver.findElement(By.xpath("//span[.='List Accounts']")).click();
		driver.findElement(By.cssSelector(".btn-primary")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("account_name")).sendKeys("Test Account");
		driver.findElement(By.id("description")).sendKeys("EBilling");
		driver.findElement(By.id("balance")).sendKeys("1500.00");
		driver.findElement(By.id("account_number")).sendKeys("763423455");
		driver.findElement(By.id("contact_person")).sendKeys("Techfios");
		driver.findElement(By.id("accountSave")).click();
		Thread.sleep(1000);
	}
	
	
	
}
