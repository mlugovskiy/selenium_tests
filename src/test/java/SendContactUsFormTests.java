import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.ContactUsPage;

public class SendContactUsFormTests extends TestBase {

    @Test
    @Feature("Contact Us Form")
    @Description("E-1 Verify that contact us form sends successfully")
    public void sendContactUsForm(){
        driver.get("http://automationpractice.com/index.php?controller=contact");
        ContactUsPage contactUsPage = PageFactory.initElements(driver, ContactUsPage.class);
        //Select "Customer Service" value in "Subject Heading" field
        contactUsPage.selectCustomerService();
        contactUsPage.setEmailField("mikhail.testuser@yandex.ru");
        contactUsPage.setMessageField("test123");
        contactUsPage.setOrderReferenceField("test123");
        contactUsPage.attachFile(System.getProperty("user.dir")+"\\src\\test\\resources\\txt_file_for_attach.txt");
        contactUsPage.sendButtonClick();
        Assert.assertEquals(contactUsPage.getAlertSuccessText(),"Your message has been successfully sent to our team.");

    }

    @Test
    @Feature("Contact Us Form")
    @Description("E-2 Verify that error message appears if Message area is empty")
    public void sendContactUsFormWithEmptyMessage(){
        driver.get("http://automationpractice.com/index.php?controller=contact");
        ContactUsPage contactUsPage = PageFactory.initElements(driver, ContactUsPage.class);
        contactUsPage.setEmailField("mikhail.testuser@yandex.ru");
        contactUsPage.sendButtonClick();
        Assert.assertEquals(contactUsPage.getErrorAlertLine1(),"There is 1 error");
        Assert.assertEquals(contactUsPage.getErrorAlertLine2(),"The message cannot be blank.");
    }

    @Test()
    @Feature("Contact Us Form")
    @Description("Verify that error message appears if Email field is empty")
    public void sendContactUsFormWithEmptyEmail(){
        driver.get("http://automationpractice.com/index.php?controller=contact");
        ContactUsPage contactUsPage = PageFactory.initElements(driver, ContactUsPage.class);
        contactUsPage.setMessageField("test123");
        contactUsPage.sendButtonClick();
        Assert.assertEquals(contactUsPage.getErrorAlertLine1(),"There is 1 error");
        Assert.assertEquals(contactUsPage.getErrorAlertLine2(),"Invalid email address.");

    }

}
