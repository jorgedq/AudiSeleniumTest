package com.auditoriaEvaluacion.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.auditoriaEvaluacion.Interface.HomeMethods;
import com.auditoriaEvaluacion.basicPage.BasicPage;

public class EditTaskPage extends BasicPage implements HomeMethods{
	
	public EditTaskPage(WebDriver driver) {

		super(driver);

	}
	
	public void changeDarkMode() {
		
		click(switchButton);
		
	}

	public boolean isOpen() {
		
		return isDisplayed(title);
		
	}

	public void clickHome() {
		
		click(home);
		
	}

	public void clickRecicleBin() {
		
		click(recicleBin);
		
	}

	public void clickUser() {
		
		click(profile);
		
	}

	public void clickLogout() {
		
		click(logout);
		
	}
	public String getOptionSelected() {
		
		return getText(findElement(optionSelected));
		
	}
	public String getTitleTask() {
		
		return getAttr("value", findElement(changeTitle));
		
	}
	
	public String getDescriptionTask() {
		
		return getText(findElement(changeDescription));
		
	}
	
	public void fillData(String option, String newTitle, String newDescription) {
		
		selectOption(option, changeType);
		
		type(newTitle, changeTitle);
		
		type(newDescription, changeDescription);
		
	}
	
	public void submit() {
		
		click(submit);
		
	}
	//elements of the page
	By switchButton = By.className("switch__slider");
	
	By profile = By.xpath(".//a[@href='/profile']");
	
	By logout = By.linkText("Cerrar Sesión");
	
	By home = By.linkText("Inicio");
	
	By recicleBin = By.linkText("Papelera De Reciclaje");
	
	By title = By.xpath(".//h1[@class='edit-form__title']");
	
	By changeType = By.name("type_id");
	
	By changeTitle = By.name("tittle");
	
	By changeDescription = By.name("description");
	
	By cancel = By.className("button-edit-back");
	
	By submit = By.xpath(".//input[@type='submit']");
	
	By optionSelected = By.xpath(".//option[@selected='selected']");

}
