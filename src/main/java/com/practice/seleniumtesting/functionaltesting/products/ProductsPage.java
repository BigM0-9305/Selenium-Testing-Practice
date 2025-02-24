package com.practice.seleniumtesting.functionaltesting.products;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.practice.seleniumtesting.functionaltesting.basicaction.BasicCommandClass;

public class ProductsPage extends BasicCommandClass{

	WebDriver driver;

	public ProductsPage(WebDriver driver) {
		super(driver);
		
		this.driver = driver;
	}
	
	public void addingToCart(List<String> productsToBeOrdered) {
		
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
	}
	
	public List<WebElement> getProductsList(){
		
		return driver.findElements(By.xpath("//div[@class='inventory_item'] //div[@class='inventory_item_name']"));
	}
	
	
}
