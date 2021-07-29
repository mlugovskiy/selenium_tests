package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class ContactUsPage {

    @FindBy(xpath = "//*[@id='email']")
    private WebElement emailField;

    @FindBy(xpath = "//*[@id='id_contact']/option[2]")
    private WebElement optionCustomerService;

    @FindBy(xpath = "//*[@id='message']")
    private WebElement messageField;

    @FindBy(xpath = "//*[@id='id_order']")
    private WebElement orderReferenceField;

    @FindBy(xpath = "//*[@id='fileUpload']")
    private WebElement attachFileFild;

    @FindBy(xpath = "//*[@id='submitMessage']")
    private WebElement sendButton;

    @FindBy(xpath = "//p[@class='alert alert-success']")
    private WebElement successAlert;

    @FindBy(xpath = "//div[@class='alert alert-danger']/p")
    private WebElement errorAlertLine1;

    @FindBy(xpath = "//div[@class='alert alert-danger']/ol/li")
    private WebElement errorAlertLine2;

    @Step
    public void setOrderReferenceField(String text) {
        this.orderReferenceField.sendKeys(text);
    }

    @Step
    public void setEmailField(String email){
        emailField.sendKeys(email);
    }

    @Step
    public void selectCustomerService(){
        optionCustomerService.click();
    }

    @Step
    public void setMessageField(String text){
        messageField.sendKeys(text);
    }

    @Step
    public void attachFile(String filepath){
        attachFileFild.sendKeys(filepath);
    }

    @Step
    public void sendButtonClick(){
        sendButton.click();
    }

    public String getAlertSuccessText(){
        return successAlert.getText();
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
