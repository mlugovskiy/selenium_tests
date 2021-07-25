package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage {

    @FindBy(xpath = "//*[@id=\"email\"]")
    private WebElement emailField;

    @FindBy(xpath = "//*[@id=\"passwd\"]")
    private WebElement passwordField;

    @FindBy(xpath = "//button[@id=\"SubmitLogin\"]")
    private WebElement submitLoginButton;

    @FindBy(xpath = "//div[@class=\"alert alert-danger\"]/p")
    private WebElement errorAlertLine1;

    @FindBy(xpath = "//div[@class=\"alert alert-danger\"]/ol/li")
    private WebElement errorAlertLine2;

    @Step
    public void setEmailField(String email){
        this.emailField.sendKeys(email);
    }

    @Step
    public void setPasswordField(String password) {
        this.passwordField.sendKeys(password);
    }

    @Step
    public void clickSubmitLoginButton() {
        submitLoginButton.click();
    }

    @Step
    public String getErrorAlertLine1() {
        return errorAlertLine1.getText();
    }

    @Step
    public String getErrorAlertLine2() {
        return errorAlertLine2.getText();
    }
}
