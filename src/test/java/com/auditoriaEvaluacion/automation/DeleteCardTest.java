package com.auditoriaEvaluacion.automation;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;


import com.auditoriaEvaluacion.pages.HomePage;
import com.auditoriaEvaluacion.pages.IndexPage;
import com.auditoriaEvaluacion.pages.LoginPage;
import com.auditoriaEvaluacionData.Card;
import com.auditoriaEvaluacionData.Data;


import java.util.ArrayList;

import org.openqa.selenium.WebDriver;


public class DeleteCardTest {
  @Test
  public void deleteCardTest() throws InterruptedException {
	  
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
			  
			  if(!home.existTask(listCard.get(i).getTitle())){
				  
				  isDeletedTask = true;
				  
			  }
		  }
	  }
	  
	  AssertJUnit.assertTrue(isDeletedTask);
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
