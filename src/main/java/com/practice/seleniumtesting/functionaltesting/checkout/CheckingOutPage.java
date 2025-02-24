package com.practice.seleniumtesting.functionaltesting.checkout;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.practice.seleniumtesting.functionaltesting.basicaction.BasicCommandClass;
import com.practice.seleniumtesting.functionaltesting.overview.FinalOverviewPage;

public class CheckingOutPage extends BasicCommandClass{

	WebDriver driver;

	public CheckingOutPage(WebDriver driver) {
		super(driver);
		
		this.driver = driver;
	}
	
	public FinalOverviewPage fillingUpDeliveryDetails() throws IOException {
		
		String[] name = getUsername().split("_");
		
		String firstName = name[0];
		
		String lastnName = name[1];
		
		driver.findElement(By.id("first-name")).sendKeys(firstName);
		
		driver.findElement(By.id("last-name")).sendKeys(lastnName);
		
		driver.findElement(By.id("postal-code")).sendKeys("123455678");
		
		driver.findElement(By.xpath("//input[@value='CONTINUE']")).click();
		
		FinalOverviewPage finalOverviewPage = new FinalOverviewPage(driver);
		
		return finalOverviewPage;
	}
	
	
}
