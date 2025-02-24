package com.practice.seleniumtesting.functionaltesting.overview;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.practice.seleniumtesting.functionaltesting.basicaction.BasicCommandClass;
import com.practice.seleniumtesting.functionaltesting.thankyou.ThankYouPage;

public class FinalOverviewPage extends BasicCommandClass{

	WebDriver driver;

	public FinalOverviewPage(WebDriver driver) {
		super(driver);
		
		this.driver = driver;
	}
	
	public ThankYouPage finalizingOrder() {
		
		driver.findElement(By.xpath("//a[@href='./checkout-complete.html']")).click();
		
		ThankYouPage thankYouPage = new ThankYouPage(driver);
		
		return thankYouPage;
	}
	
	
}
