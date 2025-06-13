import org.testng.annotations.Test;
import utils.DataProviders;

public class SearchProductTest extends BaseTest {



    @Test(priority = 1, dataProvider = "loginData", dataProviderClass = DataProviders.class)
    public void userLoginTest(String email,String password) {
        userLoginPage.userLogin(email, password);
    }

    @Test(priority = 2, dataProvider = "productData", dataProviderClass = DataProviders.class)
    public void searchProductTest(String product) throws InterruptedException {

        searchProduct.searchProductShirt(product);

    }

}
