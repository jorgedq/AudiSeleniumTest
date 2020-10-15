package com.auditoriaEvaluacion.basicPage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class BasicPage {
	
	private WebDriver driver;
	//constructor
	public BasicPage(WebDriver driver) {
		
		this.driver = driver;
	
	}
	//return driver connection
	public WebDriver getChromeDriverConnection() {
		
		if(System.getProperty("os.name").equals("Linux")) {
			
			System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/linux/chromedriver");
			
		}else {
			
			System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/Windows/chromedriver.exe");
			
		}
		
		driver = new ChromeDriver();
		
		return driver;
	
	}
	//find one element
	public WebElement findElement(By location) {
		
		return driver.findElement(location);
		
	} 
	//find list elements
	public List<WebElement> findElements(By location){
		
		return driver.findElements(location);
		
	}
	//return webelement text
	public String getText(WebElement element) {
		
		return element.getText();
	
	}
	//return text by location
	public String getText(By location) {
		
		return driver.findElement(location).getText();
		
	}
	//select option of the select field
	public void selectOption(String option, By selectInputLocation) {
		
		Select dropdown = new Select(driver.findElement(selectInputLocation));
		
		dropdown.selectByVisibleText(option);
		
	}
	//select option of the select field with value
	public void selectOptionWithValue(String value, By selectInputLocation){
		
		Select dropdown = new Select(driver.findElement(selectInputLocation));
		
		dropdown.selectByValue(value);
		
	}
	//type text in the inputs fields
	public void type(String inputText, By location) {
		
		WebElement inputField = driver.findElement(location);
		
		inputField.clear();
		
		inputField.sendKeys(inputText);
		
	}
	//click element
	public void click(By location) {
		
		driver.findElement(location).click();
		
	}
	//verify the render element
	public boolean isDisplayed(By location) {
		
		try {
			
			return driver.findElement(location).isDisplayed();
		
		}catch(org.openqa.selenium.NoSuchElementException error) {
			
			return false;
			
		}
		
	}
	public boolean isDisplayed(WebElement element) {
		
		try {
			
			return element.isDisplayed();
		
		}catch(org.openqa.selenium.NoSuchElementException error) {
			
			return false;
			
		}
		
	}
	//open the url of the page
	public void visit(String url) {
		
		driver.get(url);
		
	}
	//close connection
	public void closeConnection() {
		
		driver.quit();
		
	}
	
}
