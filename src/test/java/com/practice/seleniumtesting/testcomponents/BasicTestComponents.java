package com.practice.seleniumtesting.testcomponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.practice.seleniumtesting.functionaltesting.login.LoginPage;

public class BasicTestComponents {

	WebDriver driver;
	
	public LoginPage loginPage;
	
	public WebDriver driverInitialzing() {
		
		if(System.getProperty("browser").equalsIgnoreCase("chrome")) {
			
			driver = new ChromeDriver();
		}
		
		else if(System.getProperty("browser").equalsIgnoreCase("edge")) {
			
			driver = new EdgeDriver();
		}
		
		else if(System.getProperty("browser").equalsIgnoreCase("firefox")) {
			
			driver = new FirefoxDriver();
		}
		
		return driver;
	}
	
	public Properties getProperties() throws IOException {
		
		Properties properties = new Properties();
		
		FileInputStream fileInputStream = new FileInputStream(
				new File(System.getProperty("user.dir") + 
						"/src/main/java/com/practice/seleniumtesting/globalproperties"
						+ "/GlobalData.properties"));
		
		properties.load(fileInputStream);
		
		return properties;
	}
	
	//returns a list of hashmaps from 6
	public List<HashMap<String, String>> getJsonData() throws IOException {
		
		String path = System.getProperty("user.dir") + "/src/test/java/com/practice/seleniumtesting/testdata/testdata.json";
		
		String jsonFileString = FileUtils.readFileToString(new File(path), StandardCharsets.UTF_8);
		
		ObjectMapper mapper = new ObjectMapper();
		
		List<HashMap<String, String>> listOfhashMaps = mapper.readValue(jsonFileString, 
				new TypeReference<List<HashMap<String,String>>>(){});
		
		return listOfhashMaps;
	}
	
	@BeforeMethod(alwaysRun = true)
	public void launchApplication() throws IOException {
		
		driver = driverInitialzing();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
		
		driver.manage().window().maximize();
		
		Properties properties = getProperties();
		
		String url = properties.getProperty("Link");
		
		driver.get(url);
		
		loginPage = new LoginPage(driver);
	}
	
	@AfterMethod(alwaysRun = false)
	public void closeApplication() throws InterruptedException {
		
		Thread.sleep(5000);
		
		driver.quit();
	}
	 
	
	
	
}
