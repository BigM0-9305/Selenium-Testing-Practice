package com.practice.seleniumtesting.testcases;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.practice.seleniumtesting.functionaltesting.products.ProductsPage;
import com.practice.seleniumtesting.testcomponents.BasicTestComponents;

public class UserLogin extends BasicTestComponents{

	@Test(dataProvider = "getData")
	public void loginTest(HashMap<String, String> input) throws IOException {
		
		ProductsPage productsPage = loginPage.loginActionUsingHashMap(input.get("username"), input.get("password"));
		
		Assert.assertFalse(productsPage.getProductsList().isEmpty());
	}
	
	@Test
	public void lockedOutLogin() throws IOException {
		
		String lockedUsername = getProperties().getProperty("username2");
		
		String password = getProperties().getProperty("password");
		
		ProductsPage productsPage = loginPage.loginActionUsingHashMap(lockedUsername, password);
		
		String errorMessageRecived = loginPage.getErrorMessage();
		
		String errorMessage = "Epic sadface: Sorry, this user has been locked out.";
		
		Assert.assertEquals(errorMessageRecived, errorMessage);
		
		
	}
	
	@DataProvider
	public Object[][] getData() throws IOException {
		
		List<HashMap<String, String>> listOfHashMaps = getJsonData();
		
		return new Object[][]{
			{listOfHashMaps.get(0)},
			{listOfHashMaps.get(1)},
			{listOfHashMaps.get(2)}};
		
	}
}
