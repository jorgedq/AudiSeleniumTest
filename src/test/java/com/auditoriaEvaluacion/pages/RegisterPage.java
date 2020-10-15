package com.auditoriaEvaluacion.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.auditoriaEvaluacion.Interface.LoginMethods;
import com.auditoriaEvaluacion.basicPage.BasicPage;

public class RegisterPage extends BasicPage implements LoginMethods{

	public RegisterPage(WebDriver driver) {

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

	public boolean isOpen() {
		
		return isDisplayed(title);
	
	}
	
	public void fillForm(String name, String email, String password, String confirmPassword) {
		
		type(name, nameUser);
		
		type(email,this.email);
		
		type(password, this.password);
		
		type(confirmPassword, confirm);
		
	}
	
	public void submit() {
		
		click(submit);
		
	}
	//elemets of the page
	By loginLink = By.linkText("Iniciar Sesión");
	
	By registerLink = By.linkText("Registrarse");
	
	By switchButton = By.className("switch__slider");
	
	By title = By.xpath(".//h1");
	
	By nameUser = By.name("name");
	
	By email = By.name("email");
	
	By password = By.name("password");
	
	By confirm = By.name("password_confirmation");
	
	By submit = By.xpath(".//input[@type='submit']");
}
