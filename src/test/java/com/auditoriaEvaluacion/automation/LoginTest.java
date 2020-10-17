package com.auditoriaEvaluacion.automation;

import org.testng.annotations.Test;

import com.auditoriaEvaluacion.pages.HomePage;
import com.auditoriaEvaluacion.pages.IndexPage;
import com.auditoriaEvaluacion.pages.LoginPage;
import com.auditoriaEvaluacionData.Data;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterTest;

public class LoginTest {
  @Test
  public void LoginTest() throws InterruptedException {
	  
	  boolean loginResponse = false;
	  
	  data = Data.getDataInstance();
	  
	  index = new IndexPage(driver);
	  
	  index.clickLogin();
	  
	  login = new LoginPage(driver);
	  
	  if(login.isOpen()) {
		  
		  login.fillData(data.getEmailUser(), data.getPasswordUser());
		  
		  Thread.sleep(2000);
		  
		  login.submit();
		  
		  home = new HomePage(driver);
		  
		  loginResponse = home.isOpen();
		  
		  Thread.sleep(2000);
	  }
	  
	  AssertJUnit.assertTrue(loginResponse);
	  
  }
  @BeforeTest
  public void beforeTest() {
	  
	  index = new IndexPage(driver);
	  
	  driver = index.getChromeDriverConnection();
		
	  index.visit("http://auditareas.000webhostapp.com/");
  }

  @AfterTest
  public void afterTest() {
	  
	  driver.close();
	  
  }
  
  private static Data data;
  
  private WebDriver driver;
	
  private IndexPage index; 
  
  private HomePage home;
  
  private LoginPage login;
  
}