package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderConfirmationPage {
    @FindBy(xpath = "//h1[@class=\"page-heading\" and text()=\"Order confirmation\"]")
    private WebElement orderConfirmationTitle;

    @FindBy(xpath = "//p[@class=\"cheque-indent\"]/strong[text()=\"Your order on My Store is complete.\"]")
    private WebElement textOrderComplete;

    @Step
    public boolean isOrderComplete(){
        return orderConfirmationTitle.isDisplayed() && textOrderComplete.isDisplayed();
    }
}
