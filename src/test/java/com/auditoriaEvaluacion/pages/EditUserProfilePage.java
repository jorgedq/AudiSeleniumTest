package com.auditoriaEvaluacion.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.auditoriaEvaluacion.Interface.HomeMethods;
import com.auditoriaEvaluacion.basicPage.BasicPage;

public class EditUserProfilePage extends BasicPage implements HomeMethods{

	public EditUserProfilePage(WebDriver driver) {

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
	
	public String getNameUser() {
		
		return getAttr("value", findElement(name));
	
	}
	
	public String getEmail() {
		
		return getAttr("value", findElement(email));
		
	}
	
	public void fillData(String name, String email) {
		
		type(name, this.name);
		
		type(email,this.email);
	
	}
	
	public void fillPasswordData(String password, String confirm) {
		
		type(password, this.password);
		
		type(confirm, this.confirm);
		
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
	
	By title = By.xpath(".//h1");
	
	By name = By.name("name");
	
	By email = By.name("email");
	
	By password = By.name("password");
	
	By confirm = By.name("password_confirmation");
	
	By cancel = By.className("button-edit-back");
	
	By submit = By.xpath(".//input[@type='submit']");
}
