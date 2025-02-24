package com.practice.seleniumtesting.functionaltesting.cart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.practice.seleniumtesting.functionaltesting.basicaction.BasicCommandClass;
import com.practice.seleniumtesting.functionaltesting.checkout.CheckingOutPage;

public class CartPage extends BasicCommandClass{

	WebDriver driver;

	public CartPage(WebDriver driver) {
		super(driver);
		
		this.driver = driver;
	}
	
	public CheckingOutPage checkOutAction() {
		
		driver.findElement(By.cssSelector("a.btn_action.checkout_button")).click();
		
		CheckingOutPage checkingOutPage = new CheckingOutPage(driver);
		
		return checkingOutPage;
	}
	
}
