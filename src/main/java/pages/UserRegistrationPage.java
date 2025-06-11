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


    public void registerUser(){
        WebElement signin_login=wait.until(ExpectedConditions.elementToBeClickable(Createacclink_loc));
        signin_login.click();
    }
}
