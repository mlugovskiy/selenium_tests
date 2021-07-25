import utilities.UserActions;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.SignInPage;

public class SignInTests extends TestBase {

    @Test
    @Feature("Sign In Form")
    @Description("Sign In with valid username and password")
    @Parameters({"username","password"})
    public void signInWithValidData(String username, String password){
        UserActions.signIn(driver, username, password);
        Assert.assertEquals(driver.getTitle(), "My account - My Store");
    }

    @Test
    @Feature("Sign In Form")
    @Description("Sign In with empty username and password fields")
    public void SignInWithEmptyFields(){
        UserActions.signIn(driver, "","");
        SignInPage signInPage = PageFactory.initElements(driver, SignInPage.class);
//        Check error message
        Assert.assertEquals(signInPage.getErrorAlertLine1(), "There is 1 error");
        Assert.assertEquals(signInPage.getErrorAlertLine2(), "An email address required.");
//        Check current page is "Sign in" page
        Assert.assertEquals(driver.getTitle(), "Login - My Store");
//        Trying to access to My Account page without making Sign In
        driver.get("http://automationpractice.com/index.php?controller=my-account");
        Assert.assertEquals(driver.getTitle(), "Login - My Store");
    }
}
