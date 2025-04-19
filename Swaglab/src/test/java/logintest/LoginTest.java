package logintest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest {

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
                 System.out.println("Test Passed");
             } else {
                 System.out.println("Test Failed");
             }
         } finally {
             
             driver.quit();
         }
    }
}