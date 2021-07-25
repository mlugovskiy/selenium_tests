package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderSummaryPage {
    @FindBy(xpath = "//*[@id=\"cart_navigation\"]/button[@type=\"submit\"]")
    private WebElement confirmOrderButton;

    @Step
    public void clickConfirmOrderButton(){
        confirmOrderButton.click();
    }
}
