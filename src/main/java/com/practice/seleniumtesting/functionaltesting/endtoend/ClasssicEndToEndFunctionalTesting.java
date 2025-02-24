package com.practice.seleniumtesting.functionaltesting.endtoend;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ClasssicEndToEndFunctionalTesting {

	public static void main(String[] args) throws Exception {
		
		Properties properties = new Properties();
		
		FileInputStream fileInputStream = new FileInputStream(
				new File(System.getProperty("user.dir")+"/src/main/java/com/practice/seleniumtesting/globalproperties/GlobalData.properties"));
		
		properties.load(fileInputStream);
		
		String username1 = properties.getProperty("username1");
		
		String password = properties.getProperty("password");
		
		String url = properties.getProperty("Link");
		
		String[] name = username1.split("_");
		
		String firstName = name[0];
		
		String lastnName = name[1];
		
		List<String> productsToBeOrdered = new ArrayList<String>(Arrays.asList(
				"Sauce Labs Backpack",
				"Sauce Labs Bike Light",
				"Test.allTheThings() T-Shirt (Red)"));
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
		
		driver.manage().window().maximize();
		
		driver.get(url);
		
		driver.findElement(By.id("user-name")).sendKeys(username1);
		
		driver.findElement(By.id("password")).sendKeys(password);
		
		driver.findElement(By.id("login-button")).click();
		
		List<WebElement> products = driver.findElements(By.xpath("//div[@class='inventory_item'] //div[@class='inventory_item_name']"));
		
		List<WebElement> addToCartButtons = driver.findElements(By.xpath("//div[@class='inventory_item']/div[@class='pricebar']/button"));
		
		for(int i = 0; i < productsToBeOrdered.size(); i++) {
			
			String productNeeded = productsToBeOrdered.get(i);
			
			for(int j = 0; j < products.size(); j++) {
				
				WebElement product = products.get(j);
				
				if(product.getText().equalsIgnoreCase(productNeeded)) {
					
					addToCartButtons.get(j).click();
				}
			}
		}
		
		driver.findElement(By.cssSelector("a.shopping_cart_link")).click();
		
		Thread.sleep(3000);

		driver.findElement(By.cssSelector("a.btn_action.checkout_button")).click();
		
		driver.findElement(By.id("first-name")).sendKeys(firstName);
		
		driver.findElement(By.id("last-name")).sendKeys(lastnName);
		
		driver.findElement(By.id("postal-code")).sendKeys("123455678");
		
		driver.findElement(By.xpath("//input[@value='CONTINUE']")).click();
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//a[@href='./checkout-complete.html']")).click();
		
		Thread.sleep(3000);
		
		driver.quit();
		
		
		
	}
}
