package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartSummaryPage {

    @FindBy(xpath = "//p[@class='cart_navigation clearfix']/a[@title='Proceed to checkout']")
    private WebElement proceedToCheckoutButton;

    @FindBy(xpath = "(//small[@class='cart_ref' and contains(text(), 'SKU')])[1]")
    private WebElement skuNumber;

    @FindBy(xpath = "//p[@class='alert alert-warning']")
    private WebElement emptyCartMessage;

    @Step
    public void clickOnProceedToCheckoutButton(){
        proceedToCheckoutButton.click();
    }

    @Step
    public String getSkuNumber(){
        return skuNumber.getText().replaceAll("SKU : ","");
    }

    @Step
    public String getEmptyCartMessage(){
        return emptyCartMessage.getText();
    }

}
