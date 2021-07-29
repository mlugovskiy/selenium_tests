package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class OrderHistoryPage {

    @FindBy(xpath = "//a[contains(span/text(),\"Details\")]")
    private List<WebElement> detailsButtons;

    @FindBy(xpath = "//*[@id=\"order-detail-content\"]/table/tbody/tr/td[1]/label")
    private WebElement skuNumber;

    @FindBy(xpath = "//*[@id=\"order-detail-content\"]/table/tbody/tr/td[2]/label")
    private WebElement productFullName;

    @Step
    public void clickOnFirstLineDetailsButton(){
        detailsButtons.get(0).click();
    }

    @Step
    public String getSkuNumber() {
        return skuNumber.getText();
    }

    @Step
    public String getProductName() {
        return productFullName.getText().replaceAll(" - Color.*", "");
    }
}
