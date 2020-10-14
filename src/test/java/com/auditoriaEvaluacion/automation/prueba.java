package com.auditoriaEvaluacion.automation;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class prueba {
	
	private WebDriver driver;
	
	@BeforeMethod
	@BeforeTest
	public void setUp() {
		
		if(System.getProperty("os.name").equals("Linux")) {
			
			System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/linux/chromedriver");
			
		}else {
			
			System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
			
		}
		
		driver = new ChromeDriver();
	
		driver.manage().window().maximize();
		
		driver.get("https://www.google.com/");
	}
	
	@Test
	public void testGooglePage() {
		
		WebElement searchbox = driver.findElement(By.name("q"));
		
		searchbox.clear();
		
		searchbox.sendKeys("quality-stream Introducción a la Automatización de Pruebas de Software");
		
		searchbox.submit();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		System.out.println(driver.getTitle());
		AssertJUnit.assertEquals("quality-stream Introducción a la Automatización de Pruebas de Software - Buscar con Google",driver.getTitle());
		
	}
	
	@AfterMethod
	@AfterTest
	public void tearDown() {
		
		driver.quit();
		
	}
	
	
}
