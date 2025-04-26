package crossbrowsertesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

public class CrossBrowserTestWithGrid {
    public static final String GRID_URL = "http://localhost:4444/wd/hub"; 
    public static final String DEMO_SITE = "https://www.saucedemo.com/";

    // Define browser capabilities
    public static Object[][] BROWSERS = {
        {"Chrome"},
        {"Firefox"},
        {"Edge"}
    };

    public static void main(String[] args) {
        for (Object[] browser : BROWSERS) {
            String browserName = (String) browser[0];
            testLogin(browserName);
        }
    }

    public static void testLogin(String browserName) {
        WebDriver driver = null;
        try {
            // Set up capabilities
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setBrowserName(browserName);

            // Initialize WebDriver
            driver = new RemoteWebDriver(new URL(GRID_URL), caps);

            // Navigate to the demo site
            driver.get(DEMO_SITE);

            // Perform login test
            driver.findElement(By.id("user-name")).sendKeys("standard_user");
            driver.findElement(By.id("password")).sendKeys("secret_sauce");
            driver.findElement(By.id("login-button")).click();

            // Check if the login was successful
            if (driver.getCurrentUrl().contains("inventory.html")) {
                System.out.println("Login test passed on " + browserName);
            } else {
                System.out.println("Login test failed on " + browserName);
            }
        } catch (Exception e) {
            System.out.println("Error testing on " + browserName + ": " + e.getMessage());
        } finally {
            if (driver != null) {
                driver.quit();
            }
        }
    }
}