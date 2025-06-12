package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class UserRegistrationPage {
WebDriver driver;
    WebDriverWait wait;
//constructor
    public UserRegistrationPage(WebDriver driver){
        this.driver=driver;
this.wait=new WebDriverWait(driver,Duration.ofSeconds(10));
    }

    //locators
    By Createacclink_loc=By.xpath("//a[normalize-space()='Signup / Login']");
By name_loc=By.xpath("//input[@placeholder='Name']");
By email_loc=By.xpath("//input[@data-qa='signup-email']");
By signup_btn_loc=By.xpath("//button[@data-qa='signup-button']");
By password_loc=By.xpath("//input[contains(@data-qa,'password')]");
By day_loc=By.xpath("//select[contains(@data-qa,'days')]//option[contains(text(),5)]");
By month_loc=By.xpath("//select[contains(@data-qa,'months')]//option[contains(@value,'8')]");
By year_loc=By.xpath("//select[contains(@data-qa,'years')]//option[contains(@value,'2003')]");
By checkboc1_loc=By.xpath("//input[@id='newsletter']");
By firstname_loc=By.xpath("//input[contains(@data-qa,'first_name')]");
By lastname_loc=By.xpath("//input[contains(@data-qa,'last_name')]");
By company_loc=By.xpath("//input[contains(@data-qa,'company')]");
By address_loc=By.xpath("//input[contains(@data-qa,'address')]");

By state_loc=By.xpath("//input[contains(@data-qa,'state')]");
By city_loc=By.xpath("//input[contains(@data-qa,'city')]");
By zip_code_loc=By.xpath("//input[contains(@data-qa,'zipcode')]");
By phone_loc=By.xpath("//input[contains(@data-qa,'mobile_number')]");
By create_acc_loc=By.xpath("//button[contains(@data-qa,'create-account')]");
    By accountCreatedText_loc = By.xpath("//b[text()='Account Created!']");

    By emailAlreadyExistsMsg_loc = By.xpath("//p[text()='Email Address already exist!']");


    public void registerUser(String username,String email){
        WebElement signin_login=wait.until(ExpectedConditions.elementToBeClickable(Createacclink_loc));
        signin_login.click();
        WebElement username_field=wait.until(ExpectedConditions.elementToBeClickable(name_loc));
        username_field.sendKeys(username);
        WebElement email_field=wait.until(ExpectedConditions.elementToBeClickable(email_loc));
        email_field.sendKeys(email);
        WebElement signin_btn=wait.until(ExpectedConditions.elementToBeClickable(signup_btn_loc));
        signin_btn.click();
    }

    public void registerFormFill(String password,String firstname,String lastname,String company,String address,String state,String city,String zipcode,String phone){
        WebElement pass=wait.until(ExpectedConditions.elementToBeClickable(password_loc));
        pass.sendKeys(password);
        WebElement select_day=wait.until(ExpectedConditions.elementToBeClickable(day_loc));
        select_day.click();
        WebElement select_month=wait.until(ExpectedConditions.elementToBeClickable(month_loc));
        select_month.click();
        WebElement select_year=wait.until(ExpectedConditions.elementToBeClickable(year_loc));
        select_year.click();
        WebElement select_checkbox1=wait.until(ExpectedConditions.elementToBeClickable(checkboc1_loc));
        select_checkbox1.click();

WebElement fname=wait.until(ExpectedConditions.elementToBeClickable(firstname_loc));
fname.sendKeys(firstname);
        WebElement lname=wait.until(ExpectedConditions.elementToBeClickable(lastname_loc));
        lname.sendKeys(lastname);
        WebElement company_field=wait.until(ExpectedConditions.elementToBeClickable(company_loc));
        company_field.sendKeys(company);
        WebElement address_field=wait.until(ExpectedConditions.elementToBeClickable(address_loc));
        address_field.sendKeys(address);
        WebElement state_field=wait.until(ExpectedConditions.elementToBeClickable(state_loc));
        state_field.sendKeys(state);
        WebElement city_field=wait.until(ExpectedConditions.elementToBeClickable(city_loc));
        city_field.sendKeys(city);
        WebElement zipcode_field=wait.until(ExpectedConditions.elementToBeClickable(zip_code_loc));
       zipcode_field.sendKeys(zipcode);
        WebElement phone_field=wait.until(ExpectedConditions.elementToBeClickable(phone_loc));
       phone_field.sendKeys(phone);

        WebElement submit_info=wait.until(ExpectedConditions.elementToBeClickable(create_acc_loc));
       submit_info.click();
    }

    public boolean isAccountCreatedDisplayed() {
        try {
            WebElement successMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(accountCreatedText_loc));
            return successMsg.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isEmailAlreadyExistsDisplayed() {
        try {
            WebElement errorMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(emailAlreadyExistsMsg_loc));
            return errorMsg.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }


}
