package com.practice.seleniumtesting.functionaltesting.basicaction;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.practice.seleniumtesting.functionaltesting.cart.CartPage;
import com.practice.seleniumtesting.functionaltesting.login.LoginPage;

public class BasicCommandClass {
	
	WebDriver driver;

	public BasicCommandClass(WebDriver driver) {
		
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "a.shopping_cart_link")
	WebElement cartButton;
	
	public String thankyouMessage = "THANK YOU FOR YOUR ORDER";
	
	public Properties getProperties() throws IOException {
		
		Properties properties = new Properties();
		
		FileInputStream fileInputStream = new FileInputStream(
				new File(System.getProperty("user.dir")+"/src/main/java/com/practice/seleniumtesting/globalproperties/GlobalData.properties"));
		
		properties.load(fileInputStream);
		
		return properties;
	}
	
	
	public String getUsername() throws IOException {
		
		return getProperties().getProperty("username1");
	}
	
	public String getPassword() throws IOException {
		
		return getProperties().getProperty("password");
	}
	
	public String getUrl() throws IOException {
		
		return getProperties().getProperty("Link");
	}
	
	public String[] getName() throws IOException {
		
		String [] name = getUsername().split("_");
		
		return name;
	}
	
	public LoginPage pageLauncher() throws IOException {
		
		driver.get(getUrl());
		
		LoginPage loginPage = new LoginPage(driver);
		
		return loginPage;
	}
	
	public CartPage goingToCart() {
		
		cartButton.click();
		
		CartPage cartPage = new CartPage(driver);
		
		return cartPage;
	}
	
	
	
}
