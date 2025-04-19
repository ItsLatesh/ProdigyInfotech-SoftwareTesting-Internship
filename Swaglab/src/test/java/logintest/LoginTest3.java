package logintest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest3 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
    	WebDriver driver = new ChromeDriver();
    	try {
            
            driver.get("https://www.saucedemo.com/");
            driver.manage().window().maximize();

            
            driver.findElement(By.id("user-name")).sendKeys("standard_user");

            
            driver.findElement(By.id("login-button")).click();

            
            WebElement errorMessage = driver.findElement(By.cssSelector(".error-message-container"));
            if (errorMessage.getText().contains("Password is required")) {
                System.out.println("Test Passed: Login with Empty Password");
            } else {
                System.out.println("Test Failed: Login with Empty Password");
            }
        } finally {
            
            driver.quit();
	}

	}


	}


