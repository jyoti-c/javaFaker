package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author jyoti.chabria
 */
public class UserPage {
    WebDriver driver;


    public UserPage(WebDriver driver){
        this.driver=driver;
    }

    /**
     * Verifies logout button is present
     * @return boolean
     */
    public boolean isLogOutButtonPresent() {
return driver.findElement(By.id("logout")).isDisplayed();
    }

    /**
     * Clicks logout button
     */
    public void logOut() {
         driver.findElement(By.id("logout")).click();
    }

}
