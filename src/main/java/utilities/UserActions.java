package utilities;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.SignInPage;

public class UserActions {
    @Step
    public static void signIn(WebDriver driver, String username, String password){
        driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
        SignInPage signInPage = PageFactory.initElements(driver, SignInPage.class);
        signInPage.setEmailField(username);
        signInPage.setPasswordField(password);
        signInPage.clickSubmitLoginButton();
    }
}
