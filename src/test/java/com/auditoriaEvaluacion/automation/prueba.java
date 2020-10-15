package com.auditoriaEvaluacion.automation;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.auditoriaEvaluacion.pages.IndexPage;

public class prueba {
	
	private WebDriver driver;
	
	private IndexPage index; 
	
	@BeforeTest
	public void setUp() {
		
		index = new IndexPage(driver);
		
		driver = index.getChromeDriverConnection();
		
		index.visit("http://auditareas.000webhostapp.com/");
		
		
	}
	
	@Test
	public void testGooglePage() throws InterruptedException {
		
		index.clickLogin();
		
		Thread.sleep(5000);
		
	}
	
	@AfterTest
	public void tearDown() {
		
		driver.quit();
		
	}
	
	
}
