package com.auditoriaEvaluacion.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.auditoriaEvaluacion.Interface.HomeMethods;
import com.auditoriaEvaluacion.basicPage.BasicPage;

public class HomePage extends BasicPage implements HomeMethods{

	public HomePage(WebDriver driver) {
	
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
	
	public void clickFormTask() {
		
		click(activeFormCards);

	}
	
	public void createTask(String selectText, String title, String description) {
		
		selectOption(selectText, selectType);
		
		type(title,formTitle);
		
		type(description, formDescription);
		
	}
	
	public void submitTask() {
		
		click(formSubmit);
		
	}
	
	public boolean emptyTasks() {
		
		return isDisplayed(emptyCardsMessage);
		
	}
	
	public boolean existTask(String titleTask, String description) {
		
		boolean response = false;
		
		List<WebElement> listTitle = findElements(cardTitle);
		
		int cardPosition = find(titleTask,listTitle);
		
		return cardPosition >=0 ? true : false;
	}
	
	public void editTask(String title) {
		
		List<WebElement> list = findElements(cardTitle);
		
		List<WebElement> EditButtonsList = findElements(cardEdit);
		
		int taskPosition = find(title, list);
		
		click(EditButtonsList.get(taskPosition));
		
	}
	
	public void deleteTask(String title) {
		
		List<WebElement> list = findElements(cardTitle);
		
		List<WebElement> deleteButtonsList = findElements(cardDelete);
		
		int taskPosition = find(title, list);
		
		click(deleteButtonsList.get(taskPosition));
		
	}
	
	private int find(String text, List<WebElement> list) {
		
		int response = -1;
		
		for(int element = 0; element < list.size(); element++) {
			
			if((list.get(element).getText()).equals(text)) {
				response = 1;
				break;
			}
			
		}
		return response;
	
	}
	//elements of the page
	By switchButton = By.className("switch__slider");
	
	By profile = By.xpath(".//a[@href='/profile']");
	
	By logout = By.linkText("Cerrar Sesión");
	
	By home = By.linkText("Inicio");
	
	By recicleBin = By.linkText("Papelera De Reciclaje");
	
	By selectType = By.name("type_id");
	
	By formTitle = By.name("titulo");
	
	By formDescription = By.name("descripcion");
	
	By formSubmit = By.xpath(".//input[@type='submit']");
	
	By title = By.className("body-tittle");
	//cards elements
	By activeFormCards = By.className("btn-add");
	
	By emptyCardsMessage = By.className("empty-recicle-message");
	
	By card = By.className("card");
	
	By cardTitle = By.className("card__tittle");
	
	By cardBody = By.className("card__description");
	
	By cardDelete = By.className("card__actions--delete");
	
	By cardEdit = By.className("card__actions--edit");
	
	By typeNone = By.className("card--none");
	
	By typeNormal = By.className("card--normal");
	
	By typeImportant = By.className("card--warning");
	
	By typeAlert = By.className("card--danger");

}
