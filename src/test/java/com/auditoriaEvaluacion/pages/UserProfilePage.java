package com.auditoriaEvaluacion.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.auditoriaEvaluacion.Interface.HomeMethods;
import com.auditoriaEvaluacion.basicPage.BasicPage;

public class UserProfilePage extends BasicPage implements HomeMethods{

	public UserProfilePage(WebDriver driver) {
		
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
	
	public String getName() {
		
		return getText(nameUser);
	
	}
	
	public String getEmail() {
		
		return getText(emailUser);
		
	}
	
	public void clickEditProfile() {
		
		click(editProfile);
		
	}
	//elements of the page
	By switchButton = By.className("switch__slider");
	
	By profile = By.xpath(".//a[@href='/profile']");
	
	By logout = By.linkText("Cerrar Sesión");
	
	By home = By.linkText("Inicio");
	
	By recicleBin = By.linkText("Papelera De Reciclaje");
	
	By title = By.xpath(".//h1");
	
	By nameUser = By.className("profile__name");
	
	By emailUser = By.className("profile__email");
	
	By editProfile = By.className("profile__actions-edit");

}
