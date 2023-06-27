package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
public class LoginTest extends BaseTest {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {  //can write anywhere but always execute first
        openBrowser(baseUrl); //open browser method inherited from baseclass
    }

    @Test
    public void UserShouldNavigateToLoginPageSuccessfully() {
        //Find login link and click on login link
        WebElement loginLink = driver.findElement(By.linkText("Log in"));
        loginLink.click();
        //Now validation part / given in requirement
        String expectedMessage = "Welcome, Please Sign In!"; //this is expected requirement
        WebElement actualTextElement = driver.findElement(By.xpath("//h1[contains(text(), 'Welcome, Please Sign In!')]"));
        String actualMessage = actualTextElement.getText(); //because get text method return string so saved in string
        Assert.assertEquals("Not matching text", expectedMessage, actualMessage); //if testcase fails then assertEquals get orange doted underlined
        System.out.println("Page title : " +driver.getTitle());
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        //Find login link and click on login link
        WebElement loginLink = driver.findElement(By.linkText("Log in"));
        loginLink.click();
        //Find the Email Field Element
        WebElement emailField = driver.findElement(By.id("Email"));
        // Type the Email address to email field element
        emailField.sendKeys("admin1@yourstore.com"); //another admin@yourstore.com
        //Find the Password Field Element and send password on password field
        driver.findElement(By.name("Password")).sendKeys("Pass1234");  //admin12
        //Find the Login btn Element and click
        WebElement loginBtn = driver.findElement(By.xpath("//button[contains(text(),'Log in')]"));
        loginBtn.click();
        //verify 'Log out' text is displayed
        String expectedText = "Log out";
        WebElement actualTextElement = driver.findElement(By.className("ico-logout"));
        String actualText = actualTextElement.getText();
        Assert.assertEquals("Not at login page" ,expectedText,actualText);
        System.out.println(driver.getTitle());

    }

    @Test
    public void verifyErrorMessageWithInvalidCredentials() {
        //Find login link and click on login link
        WebElement loginLink = driver.findElement(By.linkText("Log in"));
        loginLink.click();
        //Find the Email Field Element
        WebElement emailField = driver.findElement(By.id("Email"));
        // Type the Email address to email field element
        emailField.sendKeys("prime123@gmail.com");
        //Find the Password Field Element and send password on password field
        driver.findElement(By.name("Password")).sendKeys("Prime123");
        //Find the Login btn Element and click
        WebElement loginBtn = driver.findElement(By.xpath("//button[contains(text(),'Log in')]"));
        loginBtn.click();
        String expectedMessage = "Login was unsuccessful. Please correct the errors and try again.\n" +
                "No customer account found";
        WebElement actualTextElement = driver.findElement(By.xpath("//div[@class='message-error validation-summary-errors']"));
        String actualMessage = actualTextElement.getText();
        Assert.assertEquals("Error message not displayed", expectedMessage, actualMessage);
    }
    @After
    public void tearDown(){
        closeBrowser();
    }

}