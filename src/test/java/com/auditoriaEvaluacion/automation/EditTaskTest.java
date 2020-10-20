package com.auditoriaEvaluacion.automation;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;


import com.auditoriaEvaluacion.pages.EditTaskPage;
import com.auditoriaEvaluacion.pages.HomePage;
import com.auditoriaEvaluacion.pages.IndexPage;
import com.auditoriaEvaluacion.pages.LoginPage;
import com.auditoriaEvaluacionData.Card;
import com.auditoriaEvaluacionData.Data;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;


public class EditTaskTest {
  @Test
  public void editTaskTest() throws InterruptedException {
	  
	  boolean isEditTask = false;
	  
	  data = Data.getDataInstance();
	  
	  index.clickLogin();
	  
	  login = new LoginPage(driver);
	  
	  if(login.isOpen()) {
		  
		  login.fillData(data.getEmailUser(), data.getPasswordUser());
		  
		  login.submit();
		  
		  home = new HomePage(driver);
		  
		  if(home.isOpen()) {
			  
			  ArrayList<Card> listCard = data.getCardsList();
			  
			  int i = 0;
			  
			  home.editTask(listCard.get(i).getTitle());
			  
			  edit = new EditTaskPage(driver);
			  
			  if(edit.isOpen()) {
				  
				  edit.fillData(getOption((int)Math.floor(Math.random() * 3 +1)), listCard.get(i).getTitle() + "Edicion", "Edicion "+listCard.get(i).getDescription());
				  
				  edit.submit();
				  
				  if(home.existTask(listCard.get(i).getTitle() + "Edicion")) {
					  
					  isEditTask = true;
					  
				  }
				  
			  }
			  
		  }
	  }
	  
	  AssertJUnit.assertTrue(isEditTask);
  }
  private String getOption(int numero) {
	  
	  String response = "";
	  
	  switch(numero) {
		  case 0:
			  response = "Ninguno";
			  break;
		  case 1:
			  response = "Normal";
			  break;
		  case 2:
			  response = "Importante";
			  break;
		  case 3:
			  response = "Muy Importante";
			  break;
	  }
	  
	  return response;
  
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
  
  private EditTaskPage edit;
}
