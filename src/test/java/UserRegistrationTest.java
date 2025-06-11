import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.UserRegistrationPage;

public class UserRegistrationTest {
    UserRegistrationPage userRegistrationPage;
    WebDriver driver;
    @BeforeClass
    public void setUp(){

        driver=new ChromeDriver();
        driver.get("https://automationexercise.com/");

        userRegistrationPage= new UserRegistrationPage(driver);
    }
    @Test(priority = 1)
    public void registerTest(){
        userRegistrationPage.registerUser();
    }
}
