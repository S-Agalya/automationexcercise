import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import pages.SearchProduct;
import pages.UserLoginPage;
import pages.UserRegistrationPage;

public class BaseTest {
    UserRegistrationPage userRegistrationPage;
    UserLoginPage userLoginPage;
    SearchProduct searchProduct;
    WebDriver driver;

    @BeforeClass
    public void setUp(){

        driver=new ChromeDriver();
        driver.get("https://automationexercise.com/");

        userRegistrationPage= new UserRegistrationPage(driver);
        userLoginPage=new UserLoginPage(driver);
        searchProduct=new SearchProduct(driver);
    }
}
