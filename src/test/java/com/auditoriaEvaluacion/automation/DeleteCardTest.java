package com.auditoriaEvaluacion.automation;

import org.testng.annotations.Test;

import com.auditoriaEvaluacion.pages.HomePage;
import com.auditoriaEvaluacion.pages.IndexPage;
import com.auditoriaEvaluacion.pages.LoginPage;
import com.auditoriaEvaluacionData.Card;
import com.auditoriaEvaluacionData.Data;

import org.testng.annotations.BeforeClass;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class DeleteCardTest {
  @Test
  public void DeleteCardTest() throws InterruptedException {
	  
	  boolean isDeletedTask = false;
	  
	  data = Data.getDataInstance();
	  
	  index.clickLogin();
	  
	  login = new LoginPage(driver);
	  
	  if(login.isOpen()) {
		  
		  login.fillData(data.getEmailUser(), data.getPasswordUser());
		  
		  login.submit();
		  
		  home = new HomePage(driver);
		  
		  if(home.isOpen()) {
			  
			  ArrayList<Card> listCard = data.getCardsList();
		  	  
			  //int i = (int) Math.floor(Math.random() * 3 + 1);
			  
		  	  int i = 0;// 0-3
		  	  
			  home.deleteTask(listCard.get(i).getTitle());
			  
			  home.acceptAlert();
			  
			  Thread.sleep(1000);
			  
			  if(!home.existTask(listCard.get(i).getTitle(), listCard.get(i).getDescription())){
				  
				  isDeletedTask = true;
				  
			  }
		  }
	  }
	  
	  AssertJUnit.assertTrue(isDeletedTask);
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
