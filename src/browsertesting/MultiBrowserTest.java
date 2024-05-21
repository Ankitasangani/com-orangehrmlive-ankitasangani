package browsertesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

/**
 * Project-2 - ProjectName : com-orangehrmlive
 * BaseUrl = https://opensource-demo.orangehrmlive.com/
 * 1. Setup Chrome browser.
 * 2. Open URL.
 * 3. Print the title of the page.
 * 4. Print the current url.
 * 5. Print the page source.
 * 6. Click on ‘Forgot your password?’ link.
 * 7. Print the current url.
 * 8. Navigate back to the login page.
 * 9. Refresh the page.
 * 10. Enter the email to email field.
 * 11. Enter the password to password field.
 * 12. Click on Login Button.
 * 13. Close the browser.
 */

public class MultiBrowserTest {

    // static variables
    static String browser = "Chrome";
    static String baseUrl = "https://opensource-demo.orangehrmlive.com/";
    static WebDriver driver;

    public static void main(String[] args) {
        // Nested if else to launch the browser
        if (browser.equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("FireFox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver();
        } else {
            System.out.println("Wrong browser name");
        }

        //Open baseUrl
        driver.get(baseUrl);

        // Maximise the browser window
        driver.manage().window().maximize();

        System.out.println("The title of the page: " + driver.getTitle());  // get the title of the page
        System.out.println("The current URL:  " + driver.getCurrentUrl());  //get the current Url of the page
        System.out.println("The page source: " + driver.getPageSource());  // get page source

        // We give Implicit wait to driver
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
        driver.findElement(By.className("orangehrm-login-forgot")).click(); // Click on ‘Forgot your password?’ link

        System.out.println("Get current URl:" + driver.getCurrentUrl());  //get the current Url of the page
        driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");  //Navigate back to the login page
        driver.navigate().refresh(); // refresh the page
        driver.findElement(By.name("username")).sendKeys("Admin"); // Enter the email to email field

        driver.findElement(By.name("password")).sendKeys("admin123"); // Enter the password to password field
        driver.findElement(By.tagName("button")).click(); // Click on Login Button

        driver.close();  // close the current window where Selenium automation is running
    }
}
