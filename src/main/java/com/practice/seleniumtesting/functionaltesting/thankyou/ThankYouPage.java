package com.practice.seleniumtesting.functionaltesting.thankyou;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.practice.seleniumtesting.functionaltesting.basicaction.BasicCommandClass;

public class ThankYouPage extends BasicCommandClass{

	WebDriver driver;

	public ThankYouPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	
	public void verifyingThankYouMessage() {
		
		String thankYouMessageShown = driver.findElement(By.cssSelector("div#checkout_complete_container h2.complete-header")).getText();
		
		Assert.assertEquals(thankyouMessage, thankYouMessageShown);
	}
	
	
}
