package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver,this);
    }

    @FindBy(xpath = "(//div[@class=\"product-image-container\"])[1]")
    private WebElement firstProductImage;

    @FindBy(xpath = "(//a[@title=\"Add to cart\"])[1]")
    private WebElement addToCartFirstProductButton;

    @FindBy(xpath = "//a[@title=\"Proceed to checkout\"]")
    private WebElement proceedToCheckoutButton;

    @FindBy(xpath = "//a[@class=\"product-name\"]")
    private WebElement firstProductTitle;

    @FindBy(xpath = "//a[@title=\"View my shopping cart\"]")
    private WebElement cartButton;

    private void mouseOverFirstProductImage(){
//        Scroll page to avoid Firefox driver scroll bug
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,window.innerHeight)");

        Actions builder = new Actions(driver);
        builder.moveToElement(firstProductImage).perform();
    }

    @Step
    public void addToCartFirstProduct(){
        mouseOverFirstProductImage();
        addToCartFirstProductButton.click();
    }

    @Step
    public void clickOnProceedToCheckoutButton(){

        //wait until opens modal window with "Proceed to Checkout" button
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(proceedToCheckoutButton));

        proceedToCheckoutButton.click();
    }

    @Step
    public String getFirstProductName(){
        return firstProductTitle.getText();
    }

}
