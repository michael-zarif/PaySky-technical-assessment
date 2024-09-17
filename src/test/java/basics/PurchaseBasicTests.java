package basics;

import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import pages.CheckoutPage;
import pages.LoginPage;
import pages.ProductPage;
import pages.RegisterPage;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PurchaseBasicTests extends HomePageBaseTest {
    protected LoginPage loginPage = new LoginPage();
    protected RegisterPage registerPage = new RegisterPage();
    protected ProductPage productPage = new ProductPage();
    protected CheckoutPage checkoutPage = new CheckoutPage();

    @Test
    @Order(1)
    public void testHomePageTitle() {
        var expectedTitle = "Practice Software Testing - Toolshop - v5.0";
        var actualTitle = homePage.getPageTitle();
        assertEquals(expectedTitle, actualTitle);
    }

    @Story("Successful Registration")
    @Description("Verify that a new user can register successfully")
    @ParameterizedTest(name = "Register user Test with data set")
    @MethodSource("testData")
    @Order(2)
    public void testRegisterUser(String firstName, String lastName, String email, String password, String address, String city, String state, String country, String postcode, String dateOfBirth, String phone) {
        homePage.openLoginPage();
        loginPage.openRegisterPage();
        Allure.step("Open the registration page");
        registerPage.fillRegistrationForm(firstName, lastName, dateOfBirth, address, postcode, city, state, country, phone, email, password);
        Allure.step("Fill in the registration form");
        registerPage.clickRegister();
        Allure.step("Click the Register button");

        assertTrue(loginPage.loginPageIsLoaded());
        byte[] screenshot = new byte[0];
        Allure.addAttachment("Screenshot", new ByteArrayInputStream(screenshot)); // Add a screenshot
    }

    @ParameterizedTest(name = "Product Payment Test with data set")
    @MethodSource("testData")
    @Order(3)
    public void testProductPayment(String firstName, String lastName, String email, String password, String address, String city, String state, String country, String postcode){
        homePage.selectProduct("Pliers");
        productPage.addToCart();
        productPage.navigateToCart();
        checkoutPage.proceedToCheckout();
        checkoutPage.addLoginCredentials(email, password);
        checkoutPage.clickLogin();
        checkoutPage.proceedToCheckout2();
        checkoutPage.addBillingData(address, city, state, country, postcode);
        checkoutPage.proceedToCheckout3();
        checkoutPage.selectPaymentMethod("Cash on Delivery");
        checkoutPage.clickConfirm();
        var actualMessage = checkoutPage.getConfirmMessage();
        checkoutPage.signOut();
        var expectedMessage = "Payment was successful";
        assertEquals(expectedMessage, actualMessage);
    }

    public static Object[][] testData() throws IOException {
        ReadExcelFile configuration = new ReadExcelFile("src\\test\\resources\\TestData.xlsx");
        int rows = configuration.getRowCount(0);
        Object[][] userTestData = new Object[rows][11];

        for(int i=0; i<rows; i++)
        {
            userTestData[i][0] = configuration.getData(0, i, 0);
            userTestData[i][1] = configuration.getData(0, i, 1);
            userTestData[i][2] = configuration.getData(0, i, 2);
            userTestData[i][3] = configuration.getData(0, i, 3);
            userTestData[i][4] = configuration.getData(0, i, 4);
            userTestData[i][5] = configuration.getData(0, i, 5);
            userTestData[i][6] = configuration.getData(0, i, 6);
            userTestData[i][7] = configuration.getData(0, i, 7);
            userTestData[i][8] = configuration.getData(0, i, 8);
            userTestData[i][9] = configuration.getData(0, i, 9);
            userTestData[i][10] = configuration.getData(0, i, 10);
        }
        return userTestData;
    }
}
