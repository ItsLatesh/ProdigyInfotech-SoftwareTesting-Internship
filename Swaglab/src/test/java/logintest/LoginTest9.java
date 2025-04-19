package logintest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest9 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
    	WebDriver driver = new ChromeDriver();
    	 try {
             
             driver.get("https://www.saucedemo.com/");
             driver.manage().window().maximize();

             
             driver.findElement(By.id("user-name")).sendKeys("standard_user");
             driver.findElement(By.id("password")).sendKeys("secret_sauce");
             driver.findElement(By.id("login-button")).click();

             
             WebElement inventoryList = driver.findElement(By.className("inventory_list"));
             if (inventoryList.isDisplayed()) {
                 System.out.println("Login Successful: User is on the inventory page.");
             } else {
                 System.out.println("Login Failed: Unable to find inventory page.");
                 return; 
             }

            
             driver.findElement(By.id("react-burger-menu-btn")).click();

             
             Thread.sleep(2000); // A small delay to wait for the menu to open

             
             driver.findElement(By.id("logout_sidebar_link")).click();

             
             WebElement loginButton = driver.findElement(By.id("login-button"));
             if (loginButton.isDisplayed()) {
                 System.out.println("Logout Successful: User is back on the login page.");
             } else {
                 System.out.println("Logout Failed: Login button not found.");
             }
         } catch (InterruptedException e) {
             e.printStackTrace();
         } finally {
             
             driver.quit();
	}

	}


	}



