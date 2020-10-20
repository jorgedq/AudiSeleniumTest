package com.auditoriaEvaluacion.automation;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;

import com.auditoriaEvaluacion.pages.HomePage;
import com.auditoriaEvaluacion.pages.IndexPage;
import com.auditoriaEvaluacion.pages.LoginPage;
import com.auditoriaEvaluacionData.Data;

import org.openqa.selenium.WebDriver;

public class LoginTest {
  @Test(groups = { "two" }, dependsOnGroups = { "one" } )
  public void loginTestUser() throws InterruptedException {
	  
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
  @BeforeClass
  public void beforeClass() {
	  
	  index = new IndexPage(driver);
	  
	  driver = index.getChromeDriverConnection();
		
	  index.visit("http://auditareas.000webhostapp.com/");
  }

  @AfterClass
  public void afterClass() {
	  
	  driver.close();
	  
  }
  
  private static Data data;
  
  private WebDriver driver;
	
  private IndexPage index; 
  
  private HomePage home;
  
  private LoginPage login;
  
}
