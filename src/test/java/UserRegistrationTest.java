import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.UserRegistrationPage;
import utils.DataProviders;

public class UserRegistrationTest extends BaseTest {

    @Test(priority = 1, dataProvider = "registrationData", dataProviderClass = DataProviders.class)
    public void registerTest(String username, String email, String password,
                             String firstname, String lastname, String company,
                             String address, String state, String city, String zipcode, String phone){

        userRegistrationPage.registerUser(username,email);
        if (userRegistrationPage.isEmailAlreadyExistsDisplayed()) {
            System.out.println("Email already exists. Cannot register again.");
        } else {
            userRegistrationPage.registerFormFill(password, firstname, lastname, company, address, state, city, zipcode, phone);

            if (userRegistrationPage.isAccountCreatedDisplayed()) {
                System.out.println("Account created successfully.");
            } else {
                System.out.println("Account creation failed.");
            }
        }

    }
}
