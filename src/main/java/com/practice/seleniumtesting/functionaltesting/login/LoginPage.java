package com.practice.seleniumtesting.functionaltesting.login;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.practice.seleniumtesting.functionaltesting.basicaction.BasicCommandClass;
import com.practice.seleniumtesting.functionaltesting.products.ProductsPage;

public class LoginPage extends BasicCommandClass{
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//h3[@data-test='error']")
	WebElement errorMessage;

	public ProductsPage loginAction() throws IOException {
		
		driver.findElement(By.id("user-name")).sendKeys(getUsername());
		
		driver.findElement(By.id("password")).sendKeys(getPassword());
		
		driver.findElement(By.id("login-button")).click();
		
		ProductsPage productsPage = new ProductsPage(driver);
		
		return productsPage;
		
	}
	
	public ProductsPage loginActionUsingHashMap(String username, String password) throws IOException {
		
		driver.findElement(By.id("user-name")).sendKeys(username);
		
		driver.findElement(By.id("password")).sendKeys(password);
		
		driver.findElement(By.id("login-button")).click();
		
		ProductsPage productsPage = new ProductsPage(driver);
		
		return productsPage;
		
	}
	
	public String getErrorMessage() {
		
		return errorMessage.getText();
	}
}
