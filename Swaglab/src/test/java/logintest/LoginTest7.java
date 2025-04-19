package logintest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest7 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
    	WebDriver driver = new ChromeDriver();
    	 try {
             
    		 
    	            driver.get("https://www.saucedemo.com/");
    	            driver.manage().window().maximize();

    	            
    	            driver.findElement(By.id("user-name")).sendKeys("' OR '1'='1");
    	            driver.findElement(By.id("password")).sendKeys("' OR '1'='1");

    	            
    	            driver.findElement(By.id("login-button")).click();

    	            
    	            WebElement errorMessage = driver.findElement(By.cssSelector(".error-message-container"));
    	            if (errorMessage.getText().contains("Username and password do not match any user in this service")) {
    	                System.out.println("Test Passed: SQL Injection Attempt Detected");
    	            } else {
    	                System.out.println("Test Failed: SQL Injection Attempt Bypassed");
    	            }
    	        } finally {
    	            
    	            driver.quit();
	}

	}


	}



