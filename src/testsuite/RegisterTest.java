package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RegisterTest extends BaseTest {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {  //always execute first

        openBrowser(baseUrl); //open browser method inherited from baseclass
    }

    @Test
    public void UserShouldNavigateToRegisterPageSuccessfully() {
        //Find Register tab and click on Register
        WebElement loginLink = driver.findElement(By.linkText("Register"));
        loginLink.click();
        //Now validation part given in requirement
        String expectedMessage = "Register"; //this is expected requirement
        WebElement actualTextElement = driver.findElement(By.xpath("//h1[contains(text(), 'Register')]"));
        String actualMessage = actualTextElement.getText(); //because get text method return string so saved in string
        Assert.assertEquals("Not matching text", expectedMessage, actualMessage); //if testcase fails then assertEquals get orange doted underlined
        System.out.println("Page title : " + driver.getTitle());
    }

    @Test
    public void UserShouldRegisterAccountSuccessfully() {  //we have to give new email and password every time
        //Find Register tab and click on Register
        WebElement loginLink = driver.findElement(By.linkText("Register"));
        loginLink.click();
        WebElement genderBtnMale = driver.findElement(By.id("gender-male"));
        genderBtnMale.click();
//        WebElement genderBtnFemale = driver.findElement(By.id("gender-female"));
//        genderBtnFemale.click();
        WebElement firstNameField = driver.findElement(By.id("FirstName"));
        firstNameField.sendKeys("Admin");
        driver.findElement(By.id("LastName")).sendKeys("Bhai");
        //User's date of birth is 1/January/1950
//       WebElement dayBtn = driver.findElement(By.xpath("//select[@name='DateOfBirthDay']"));
//       dayBtn.click();
        WebElement dayOpt = driver.findElement(By.xpath("//select[@name='DateOfBirthDay']/option[text()='1']"));
        dayOpt.click();
        WebElement monthOpt = driver.findElement(By.xpath("//select[@name='DateOfBirthMonth']/option[text()='January']"));
        monthOpt.click();
        WebElement yearOpt = driver.findElement(By.xpath("//select[@name='DateOfBirthYear']/option[text()='1950']"));
        yearOpt.click();
        WebElement emailField = driver.findElement(By.id("Email"));
        // Type the Email address to email field element
        emailField.sendKeys("admin11@yourstore.com");
        //Find the Password Field Element and send password on password field
        driver.findElement(By.name("Password")).sendKeys("Pass123");
        //Find the Confirmation password Field Element and send password on Confirm password field
        driver.findElement(By.name("ConfirmPassword")).sendKeys("Pass123");
        //Find the Register btn Element and click
        driver.findElement(By.id("register-button")).click();
        //verify 'Your registration completed' text is displayed
        String expectedText = "Your registration completed";
        WebElement actualTextElement = driver.findElement(By.xpath("//div[@class='result']"));
        String actualText = actualTextElement.getText();
        Assert.assertEquals("Can not registered", expectedText, actualText);
        System.out.println(driver.getTitle());
    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}