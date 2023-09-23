
import io.github.bonigarcia.wdm.WebDriverManager;
import net.datafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.AddUserPage;
import pages.LoginPage;
import pages.UserPage;

/**
 * @author jyoti.chabria
 */
public class SeleniumTest {
    WebDriver webDriver;
    String firstName;
    String lastName;
    String emailAddress;
    String password;
    AddUserPage addUserPage;
    LoginPage loginPage;
    UserPage userPage;

    @BeforeTest(alwaysRun = true)
    public void setUpDriver(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver(options);
    }

    @BeforeTest(dependsOnMethods ={"setUpDriver"} )
    public void setUpPages() {
        addUserPage = new AddUserPage(webDriver);
        loginPage = new LoginPage(webDriver);
        userPage = new UserPage(webDriver);
    }
    @BeforeTest(alwaysRun = true)
    public void setUpFakerData() {
        Faker faker = new Faker();
        firstName=faker.name().firstName();
        lastName=faker.name().lastName();
        emailAddress=faker.internet().safeEmailAddress(firstName+lastName);
        password=faker.internet().password(8,10,true);
    }

    @Test
    public void test001AddUser() {
        webDriver.get("https://thinking-tester-contact-list.herokuapp.com/addUser");
        addUserPage.setEmail(emailAddress);
        addUserPage.setLastName(lastName);
        addUserPage.setFirstName(firstName);
        addUserPage.setPassword(password);
        addUserPage.submitForm();
        Assert.assertTrue(userPage.isLogOutButtonPresent());
        userPage.logOut();
    }

    @Test(dependsOnMethods = {"test001AddUser"})
    public void test002Login() {
        loginPage.setEmail(emailAddress);
        loginPage.setPassword(password);
        loginPage.login();
        Assert.assertTrue(userPage.isLogOutButtonPresent());
        userPage.logOut();
    }
    @AfterClass(alwaysRun = true)
    public void tearDown() {
        webDriver.quit();
    }
}
