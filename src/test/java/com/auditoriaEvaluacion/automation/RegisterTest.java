package com.auditoriaEvaluacion.automation;

import org.testng.annotations.Test;

import com.auditoriaEvaluacion.pages.HomePage;
import com.auditoriaEvaluacion.pages.IndexPage;
import com.auditoriaEvaluacion.pages.RegisterPage;
import com.auditoriaEvaluacionData.Data;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterTest;

public class RegisterTest {
 @BeforeTest
  public void beforeTest() {
	  
	  index = new IndexPage(driver);
	  
	  driver = index.getChromeDriverConnection();
		
	  index.visit("http://auditareas.000webhostapp.com/");
	  
  }
  @Test
  public void RegisterUser() throws InterruptedException {
	  
	  boolean createUserResponse = false;
	  
	  data = Data.getDataInstance();
	  
	  index.clickRegister();
	  
	  register = new RegisterPage(driver);
	  
	  if(register.isOpen()) {
		 
		  register.fillForm(data.getNameUser(), data.getEmailUser(), data.getPasswordUser(), data.getPasswordUser());
		  
		  Thread.sleep(2000);
		  
		  register.submit();
		  
		  home = new HomePage(driver);
		  
		  Thread.sleep(3000);
		  
		  createUserResponse = home.isOpen();
		  
	  }
	  
	  AssertJUnit.assertEquals(createUserResponse, true);
	  
  }

  @AfterTest
  public void afterTest() {
	  
	  driver.close();
	  
  }
  
  private static Data data;
  
  private WebDriver driver;
	
  private IndexPage index; 
  
  private RegisterPage register;
  
  private HomePage home;
  
}
