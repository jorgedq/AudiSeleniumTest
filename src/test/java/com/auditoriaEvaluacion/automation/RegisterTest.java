package com.auditoriaEvaluacion.automation;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;

import com.auditoriaEvaluacion.pages.HomePage;
import com.auditoriaEvaluacion.pages.IndexPage;
import com.auditoriaEvaluacion.pages.RegisterPage;
import com.auditoriaEvaluacionData.Data;

import org.openqa.selenium.WebDriver;

public class RegisterTest {
 @BeforeClass
  public void beforeClass() {
	  
	  index = new IndexPage(driver);
	  
	  driver = index.getChromeDriverConnection();
		
	  index.visit("http://auditareas.000webhostapp.com/");
	  
  }
  @Test(priority=1)
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

  @AfterClass
  public void afterClass() {
	  
	  driver.close();
	  
  }
  
  private static Data data;
  
  private WebDriver driver;
	
  private IndexPage index; 
  
  private RegisterPage register;
  
  private HomePage home;
  
}
