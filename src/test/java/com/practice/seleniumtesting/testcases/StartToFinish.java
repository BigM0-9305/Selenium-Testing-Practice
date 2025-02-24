package com.practice.seleniumtesting.testcases;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.practice.seleniumtesting.functionaltesting.cart.CartPage;
import com.practice.seleniumtesting.functionaltesting.checkout.CheckingOutPage;
import com.practice.seleniumtesting.functionaltesting.overview.FinalOverviewPage;
import com.practice.seleniumtesting.functionaltesting.products.ProductsPage;
import com.practice.seleniumtesting.functionaltesting.thankyou.ThankYouPage;
import com.practice.seleniumtesting.testcomponents.BasicTestComponents;

public class StartToFinish extends BasicTestComponents{
	
	
	@Test
	public void startToFinish() throws IOException {
		
		List<String> productToBeOrdered = new ArrayList<String>(Arrays.asList(
				"Sauce Labs Backpack", 
				"Sauce Labs Bike Light", 
				"Sauce Labs Onesie"));
		
		ProductsPage productsPage = loginPage.loginAction();
		
		productsPage.addingToCart(productToBeOrdered);
		
		CartPage cartPage = productsPage.goingToCart();
		
		CheckingOutPage checkingOutPage = cartPage.checkOutAction();
		
		FinalOverviewPage overviewPage = checkingOutPage.fillingUpDeliveryDetails();
		
		ThankYouPage thankYouPage = overviewPage.finalizingOrder();
		
		thankYouPage.verifyingThankYouMessage();
	}
	

}
