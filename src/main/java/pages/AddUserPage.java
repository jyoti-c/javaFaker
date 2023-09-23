package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author jyoti.chabria
 */
public class AddUserPage {
    WebDriver driver;

    public AddUserPage(WebDriver driver){
        this.driver=driver;
    }

    /**
     * Set first name
     * @param firstName String first name
     */
    public void setFirstName(String firstName) {
        System.out.println("Setting first name as "+firstName);
        driver.findElement(By.id("firstName")).sendKeys(firstName);
    }

    /**
     * Set last name
     * @param lastName String last name
     */
    public void setLastName(String lastName) {
        System.out.println("Setting last name as "+lastName);
        driver.findElement(By.id("lastName")).sendKeys(lastName);
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
     * Submit add user form
     */
    public void submitForm() {
        driver.findElement(By.id("submit")).click();
    }


}
