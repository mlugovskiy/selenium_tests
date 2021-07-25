import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartSummaryPage;

public class EmptyCartTest extends TestBase {

    @Test
    @Feature("Cart")
    @Description("Verify empty Cart message")
    public void openEmptyCart(){
        driver.get("http://automationpractice.com/index.php?controller=order");
        CartSummaryPage cartSummaryPage = PageFactory.initElements(driver, CartSummaryPage.class);
        String emptyCartMessage = cartSummaryPage.getEmptyCartMessage();
//        Check empty cart message
        Assert.assertEquals(emptyCartMessage, "Your shopping cart is empty.");
    }
}
