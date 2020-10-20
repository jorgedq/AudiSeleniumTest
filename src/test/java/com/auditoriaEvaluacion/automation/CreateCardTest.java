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

import org.openqa.selenium.WebDriver;


import java.util.ArrayList;

public class CreateCardTest {
  @Test
  public void createCardTest() throws InterruptedException {
	  
	  boolean finishCreateCards = false;
	  
	  data = Data.getDataInstance();
	  
	  index.clickLogin();
	  
	  login = new LoginPage(driver);
	  
	  if(login.isOpen()) {
		  
		  login.fillData(data.getEmailUser(), data.getPasswordUser());
		  
		  login.submit();
		  
		  home = new HomePage(driver);
		  
		  if(home.isOpen()) {
			  
			  ArrayList<Card> listCard = data.getCardsList();

		  	  home.clickFormTask();
		  	  
			  //int i = (int) Math.floor(Math.random() * 3 + 1);
			  
		  	  int i = 0;// 0-3
		  	  
			  home.createTask(listCard.get(i).getType(), listCard.get(i).getTitle(), listCard.get(i).getDescription());
			  
			  home.submitTask();
			  
			  Thread.sleep(1000);
			  
			  if(home.existTask(listCard.get(i).getTitle())){
				  
				  finishCreateCards = true;
				  
			  }
			  
		  }
	  }
	  
	  AssertJUnit.assertTrue(finishCreateCards);
	  
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
