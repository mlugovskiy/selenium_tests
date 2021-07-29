package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderAddressPage {

    @FindBy(xpath = "//button[@type='submit' and @name='processAddress']")
    private WebElement proceedToCheckoutButton;

    @Step
    public void clickOnProceedToCheckoutButton(){
        proceedToCheckoutButton.click();
    }
}
