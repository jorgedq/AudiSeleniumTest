package com.auditoriaEvaluacion.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.auditoriaEvaluacion.Interface.LoginMethods;
import com.auditoriaEvaluacion.basicPage.BasicPage;

public class IndexPage extends BasicPage implements LoginMethods{
	//constructor
	public IndexPage(WebDriver driver) {
		
		super(driver);
	
	}
	public void changeDarkMode() {
		
		click(switchButton);

	}
	public void clickRegister() {
		
		click(registerLink);
		
	}
	public void clickLogin() {
		
		click(loginLink);
		
	}

	//elemets of the page
	By loginLink = By.linkText("Iniciar Sesión");
	
	By registerLink = By.linkText("Registrarse");
	
	By switchButton = By.className("switch__slider");
	
}
