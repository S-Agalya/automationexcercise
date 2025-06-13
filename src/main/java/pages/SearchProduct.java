package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SearchProduct {
    WebDriver driver;
    WebDriverWait wait;
    public SearchProduct(WebDriver driver){
        this.driver=driver;
        this.wait= new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    //locators
    By product_loc=By.xpath("//a[@href='/products']");
    By search_loc=By.xpath("//input[@id='search_product']");
    By submit_btn_loc=By.xpath("//button[@id='submit_search']");

    By view_product_loc=By.xpath("//a[@href='/product_details/2']");

    By productname_loc=By.xpath("//h2[text()='Men Tshirt']");
    By price_loc=By.xpath("//span[normalize-space()='Rs. 400']");
    By quantity_loc=By.xpath("//input[@id='quantity']");
    By addtocart_btn_loc=By.xpath("//button[contains(@class,'btn btn-default cart')]");


    By continue_shopping_loc=By.xpath("");
    public void searchProductShirt(String product) throws InterruptedException {
        WebElement product_opt=wait.until(ExpectedConditions.elementToBeClickable(product_loc));
        product_opt.click();
        WebElement searchfield=wait.until(ExpectedConditions.elementToBeClickable(search_loc));
        searchfield.sendKeys(product);
        WebElement submit_btn=wait.until(ExpectedConditions.elementToBeClickable(submit_btn_loc));
        submit_btn.click();
        WebElement viewProduct=wait.until(ExpectedConditions.elementToBeClickable(view_product_loc));
//
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", viewProduct);
        Thread.sleep(500); // optional wait for stability
        viewProduct.click();
    }

}
