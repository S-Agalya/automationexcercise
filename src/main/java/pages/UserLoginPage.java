package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class UserLoginPage {
    WebDriver driver;
    WebDriverWait wait;

    //constructor
    public UserLoginPage(WebDriver driver){
        this.driver=driver;
        this.wait=new WebDriverWait(driver, Duration.ofSeconds(10));

    }

    //locators
    By Createacclink_loc=By.xpath("//a[normalize-space()='Signup / Login']");
    By login_email_loc=By.xpath("//input[contains(@data-qa,'login-email')]");
    By login_pass_loc=By.xpath("//input[contains(@data-qa,'login-password')]");
    By login_btn_loc=By.xpath("//button[contains(@data-qa,'login-button')]");

    public void userLogin(String email,String password){
        WebElement signin_login=wait.until(ExpectedConditions.elementToBeClickable(Createacclink_loc));
        signin_login.click();
        WebElement email_field=wait.until(ExpectedConditions.elementToBeClickable(login_email_loc));
        email_field.sendKeys(email);
        WebElement pass_field=wait.until(ExpectedConditions.elementToBeClickable(login_pass_loc));
        pass_field.sendKeys(password);
        WebElement login=wait.until(ExpectedConditions.elementToBeClickable(login_btn_loc));
        login.click();

    }

    public boolean isLoginErrorDisplayed() {
        try {
            WebElement errorMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//p[text()='Your email or password is incorrect!']")));
            return errorMsg.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    // Check if login was successful (e.g., Logout button is visible)
    public boolean isLoginSuccessful() {
        try {
            WebElement logoutBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//a[text()=' Logout']")));
            return logoutBtn.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

}
