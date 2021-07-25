package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderShippingPage {

    @FindBy(xpath = "//p[@class=\"cart_navigation clearfix\"]/button[@type=\"submit\"]")
    private WebElement proceedToCheckoutButton;

    @FindBy(xpath = "//input[@id=\"cgv\"]")
    private WebElement agreeCheckbox;

    @Step
    public void clickOnProceedToCheckoutButton(){
        proceedToCheckoutButton.click();
    }

    @Step
    public void setAgreeCheckbox(){
        agreeCheckbox.click();
    }
}
