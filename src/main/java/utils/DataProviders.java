package utils;
import org.testng.annotations.DataProvider;
public class DataProviders {
    @DataProvider(name = "registrationData")
    public Object[][] getRegistrationData() {
        return ExcelRead.readExcel("RegistrationData");
    }

    @DataProvider(name = "loginData")
    public Object[][] getLoginData() {
        return ExcelRead.readExcel("LoginData");
    }
}
