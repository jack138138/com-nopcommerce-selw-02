package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TopMenuTest extends BaseTest {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {  //can write anywhere but always execute first
        openBrowser(baseUrl); //open browser method inherited from baseclass
    }
    @Test
    public void UserShouldNavigateToComputerPageSuccessfully() {
        //Find computer button and click on it
        WebElement computerLink = driver.findElement(By.linkText("Computers"));
        computerLink.click();
        //Now validation part / given in requirement
        String expectedMessage = "Computers"; //this is expected requirement
        WebElement actualTextElement = driver.findElement(By.xpath("//a[contains(text(),'Computers ')]"));
        String actualMessage = actualTextElement.getText(); //because get text method return string so saved in string
        Assert.assertEquals("Not matching text", expectedMessage, actualMessage); //if testcase fails then assertEquals get orange doted underlined
        System.out.println("Page title : " + driver.getTitle());
    }
    @Test
    public void UserShouldNavigateToElectronicsPageSuccessfully() {
        //Find electronics button and click on it
        WebElement computerLink = driver.findElement(By.linkText("Electronics"));
        computerLink.click();
        //Now validation part / given in requirement
        String expectedMessage = "Electronics"; //this is expected requirement
        WebElement actualTextElement = driver.findElement(By.xpath("//a[contains(text(),'Electronics ')]"));
        String actualMessage = actualTextElement.getText(); //because get text method return string so saved in string
        Assert.assertEquals("Not matching text", expectedMessage, actualMessage); //if testcase fails then assertEquals get orange doted underlined
        System.out.println("Page title : " + driver.getTitle());
    }
    @Test
    public void UserShouldNavigateToApparelPageSuccessfully() {
        //Find electronics button and click on it
        WebElement computerLink = driver.findElement(By.linkText("Apparel"));
        computerLink.click();
        //Now validation part / given in requirement
        String expectedMessage = "Apparel"; //this is expected requirement
        WebElement actualTextElement = driver.findElement(By.xpath("//a[contains(text(),'Apparel ')]"));
        String actualMessage = actualTextElement.getText(); //because get text method return string so saved in string
        Assert.assertEquals("Not matching text", expectedMessage, actualMessage); //if testcase fails then assertEquals get orange doted underlined
        System.out.println("Page title : " + driver.getTitle());
    }
    @Test
    public void UserShouldNavigateToDigitalDownloadsPageSuccessfully() {
        //Find electronics button and click on it
        WebElement computerLink = driver.findElement(By.linkText("Digital downloads"));
        computerLink.click();
        //Now validation part / given in requirement
        String expectedMessage = "Digital downloads"; //this is expected requirement
        WebElement actualTextElement = driver.findElement(By.xpath("//a[contains(text(),'Digital downloads ')]"));
        String actualMessage = actualTextElement.getText(); //because get text method return string so saved in string
        Assert.assertEquals("Not matching text", expectedMessage, actualMessage); //if testcase fails then assertEquals get orange doted underlined
        System.out.println("Page title : " + driver.getTitle());
    }



    @After
    public void tearDown() {
        closeBrowser();
    }
}