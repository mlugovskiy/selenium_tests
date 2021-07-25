import utilities.UserActions;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.*;

public class PurchaseTests extends TestBase {

    @Test
    @Feature("Product Order")
    @Description("E-3 Proceed To Checkout")
    @Parameters({"username", "password"})
    public void PurchaseFirstProduct(String username, String password){
//        Sign in to site as user
        UserActions.signIn(driver, username, password);

        //        Home page
        driver.get("http://automationpractice.com/index.php");
        HomePage homePage = new HomePage(driver);

//        Get product name to check it matches with product name on "Order History" page after order completing
        String firstProductName = homePage.getFirstProductName();
//        Add product to Cart
        homePage.addToCartFirstProduct();
        homePage.clickOnProceedToCheckoutButton();

//        Cart Summary page
        CartSummaryPage cartSummaryPage = PageFactory.initElements(driver, CartSummaryPage.class);
        String skuNumber = cartSummaryPage.getSkuNumber();
        cartSummaryPage.clickOnProceedToCheckoutButton();

//        Order Address page
        OrderAddressPage orderAddressPage= PageFactory.initElements(driver, OrderAddressPage.class);
        orderAddressPage.clickOnProceedToCheckoutButton();

//        Order Shipping page
        OrderShippingPage orderShippingPage = PageFactory.initElements(driver, OrderShippingPage.class);
        orderShippingPage.setAgreeCheckbox();
        orderShippingPage.clickOnProceedToCheckoutButton();

//        "Choose Payment Method" page
        ChoosePaymentMethodPage choosePaymentMethodPage;
        choosePaymentMethodPage  = PageFactory.initElements(driver, ChoosePaymentMethodPage.class);
        choosePaymentMethodPage.clickOnPayByBankWireButton();

//        Order Summary page
        OrderSummaryPage orderSummaryPage = PageFactory.initElements(driver, OrderSummaryPage.class);
        orderSummaryPage.clickConfirmOrderButton();

//        Check Order is complete
        OrderConfirmationPage orderConfirmationPage = PageFactory.initElements(driver, OrderConfirmationPage.class);
        Assert.assertTrue(orderConfirmationPage.isOrderComplete());

//        Check product displayed on "Order History" page
        driver.get("http://automationpractice.com/index.php?controller=history");
        OrderHistoryPage orderHistoryPage = PageFactory.initElements(driver, OrderHistoryPage.class);
        orderHistoryPage.clickOnFirstLineDetailsButton();
        Assert.assertEquals(orderHistoryPage.getProductName(), firstProductName);
        Assert.assertEquals(orderHistoryPage.getSkuNumber(), skuNumber);

    }

}
