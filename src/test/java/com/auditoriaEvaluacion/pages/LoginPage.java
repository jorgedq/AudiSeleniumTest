package com.auditoriaEvaluacion.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.auditoriaEvaluacion.Interface.LoginMethods;
import com.auditoriaEvaluacion.basicPage.BasicPage;

public class LoginPage extends BasicPage implements LoginMethods{

	public LoginPage(WebDriver driver) {

		super(driver);

	}
	
	public void fillData(String email, String password) {
		
		type(email, this.email);
		
		type(password, this.password);
		
	}
	
	public void submit() {
		
		click(submit);
		
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
	
	public boolean isOpen() {
		
		return isDisplayed(title);
		
	}
	//elemets of the page
	By loginLink = By.linkText("Iniciar Sesión");
	
	By registerLink = By.linkText("Registrarse");
	
	By switchButton = By.className("switch__slider");
	
	By alert = By.tagName("strong");
	
	By title = By.xpath(".//h1");
	
	By email = By.name("email");
	
	By password = By.name("password");
	
	By submit = By.xpath(".//input[@type='submit']");
	
	By resetPassword = By.linkText("Olvidaste tu contraseña?");	
}
