package com.practice.seleniumtesting.functionaltesting.endtoend;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.practice.seleniumtesting.functionaltesting.basicaction.BasicCommandClass;
import com.practice.seleniumtesting.functionaltesting.cart.CartPage;
import com.practice.seleniumtesting.functionaltesting.checkout.CheckingOutPage;
import com.practice.seleniumtesting.functionaltesting.login.LoginPage;
import com.practice.seleniumtesting.functionaltesting.overview.FinalOverviewPage;
import com.practice.seleniumtesting.functionaltesting.products.ProductsPage;
import com.practice.seleniumtesting.functionaltesting.thankyou.ThankYouPage;

public class EndToEndFunctionalTest {

	public static void main(String[] args) throws IOException {
		
		List<String> productToBeOrdered = new ArrayList<String>(Arrays.asList(
				"Sauce Labs Backpack", 
				"Sauce Labs Bike Light", 
				"Sauce Labs Onesie"));
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
		
		driver.manage().window().maximize();
		
		BasicCommandClass commandClass = new BasicCommandClass(driver);
		
		LoginPage loginPage = commandClass.pageLauncher();
		
		ProductsPage productsPage = loginPage.loginAction();
		
		productsPage.addingToCart(productToBeOrdered);
		
		CartPage cartPage = commandClass.goingToCart();
		
		CheckingOutPage checkingOutPage = cartPage.checkOutAction();
		
		FinalOverviewPage overviewPage = checkingOutPage.fillingUpDeliveryDetails();
		
		ThankYouPage thankYouPage = overviewPage.finalizingOrder();
		
		thankYouPage.verifyingThankYouMessage();
	}

}
