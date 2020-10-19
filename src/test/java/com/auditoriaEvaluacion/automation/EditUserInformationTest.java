package com.auditoriaEvaluacion.automation;

import org.testng.annotations.Test;

import com.auditoriaEvaluacion.pages.EditUserProfilePage;
import com.auditoriaEvaluacion.pages.HomePage;
import com.auditoriaEvaluacion.pages.IndexPage;
import com.auditoriaEvaluacion.pages.LoginPage;
import com.auditoriaEvaluacion.pages.UserProfilePage;
import com.auditoriaEvaluacionData.Data;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterTest;

public class EditUserInformationTest {
  @Test
  public void EdituserInformationTest() throws InterruptedException {
	  
	  boolean isEditProfile = false;
	  
	  data = Data.getDataInstance();
	  
	  index.clickLogin();
	  
	  login = new LoginPage(driver);
	  
	  if (login.isOpen()) {
		  
		  login.fillData(data.getEmailUser(), data.getPasswordUser());
		  
		  login.submit();
		  
		  home = new HomePage(driver);
		  
		  if(home.isOpen()) {
			  
			  home.clickUser();
			  
			  profile = new UserProfilePage(driver);
			  
			  if(profile.isOpen()) {
				  
				  profile.clickEditProfile();
				  
				  edit = new EditUserProfilePage(driver);
				  
				  if(edit.isOpen()) {
					  
					  edit.fillData(data.getNameUser()+" Edit", data.getEmailUser());
					  
					  edit.submit();
					  
					  if(profile.getName().equalsIgnoreCase(data.getNameUser()+" Edit")) {
						  
						  isEditProfile = true;
						  
					  }
					  
				  }
				  
			  }
		  
		  }
		  
	  }
	  
	  AssertJUnit.assertTrue(isEditProfile);
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
  
  private UserProfilePage profile;
  
  private EditUserProfilePage edit;

}
