package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * @author jyoti.chabria
 */
public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver=driver;
    }

    /**
     * Set email
     * @param email String email
     */
    public void setEmail(String email) {
        System.out.println("Setting email as "+email);
        driver.findElement(By.id("email")).sendKeys(email);
    }

    /**
     * Set password
     * @param password String password
     */

    public void setPassword(String password) {
        System.out.println("Setting password as "+password);
        driver.findElement(By.id("password")).sendKeys(password);
    }

    /**
     * Click on Login
     */
    public void login() {
        driver.findElement(By.id("submit")).click();
    }

}
