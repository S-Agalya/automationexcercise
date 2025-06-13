import org.testng.annotations.Test;
import utils.DataProviders;
import org.testng.Assert;

public class UserLoginTest extends BaseTest{

    @Test(priority = 1, dataProvider = "loginData", dataProviderClass = DataProviders.class)
    public void userLoginTest(String email,String password){
        userLoginPage.userLogin(email,password);
        if (userLoginPage.isLoginErrorDisplayed()) {

            Assert.assertTrue(userLoginPage.isLoginErrorDisplayed(), "Expected login error message not displayed.");
            System.out.println("Login failed due to invalid credentials.");
        } else {
            Assert.assertTrue(userLoginPage.isLoginSuccessful(), "Expected successful login, but it failed.");
            System.out.println("Login successful.");
        }
    }
}
