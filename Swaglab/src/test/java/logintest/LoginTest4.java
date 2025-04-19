package logintest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest4 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
    	WebDriver driver = new ChromeDriver();
    	try {
            
            driver.get("https://www.saucedemo.com/");
            driver.manage().window().maximize();

           
            driver.findElement(By.id("login-button")).click();

            
            WebElement errorMessage = driver.findElement(By.cssSelector(".error-message-container"));
            if (errorMessage.getText().contains("Username is required")) {
                System.out.println("Test Passed: Login with Both Fields Empty");
            } else {
                System.out.println("Test Failed: Login with Both Fields Empty");
            }
        } finally {
            
            driver.quit();
	}

	}


	}


