package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ChoosePaymentMethodPage {
    @FindBy(xpath = "//a[@title=\"Pay by bank wire\"]")
    private WebElement payByBankWireButton;

    @FindBy(xpath = "//a[@title=\"Pay by check.\"]")
    private WebElement payByCheckButton;

    @Step
    public void clickOnPayByBankWireButton(){
        payByBankWireButton.click();
    }


}
