package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationInfoPage {
    public static final String USER_NAME_TEXTBOX_ID = "ap_customer_name";
    public static final String USER_EMAIL_TEXTBOX_ID = "ap_email";
    public static final String EMAIL_CONFIRM_TEXTBOX_ID = "ap_email_check";
    public static final String PASSWORD_TEXTBOX_ID = "ap_password";
    public static final String PASSWORD_CONFIRM_TEXTBOX_ID = "ap_password_check";

    @FindBy(id= USER_EMAIL_TEXTBOX_ID)
    public static WebElement user_email_textbox;

    @FindBy(id = USER_NAME_TEXTBOX_ID)
    private static WebElement user_name_textbox;

    @FindBy(id= EMAIL_CONFIRM_TEXTBOX_ID)
    public static WebElement email_confirm_textbox;

    @FindBy(id= PASSWORD_TEXTBOX_ID)
    public static WebElement password_textbox;

    @FindBy(id= PASSWORD_CONFIRM_TEXTBOX_ID)
    public static WebElement confirm_password_textbox;

    public void fillUserName(String userName) {
        user_name_textbox.sendKeys(userName);
    }

    public void fillEmail(String userEmail) {
        user_email_textbox.sendKeys(userEmail);
    }

    public void confirmEmail(String userEmail) {
        email_confirm_textbox.sendKeys(userEmail);
    }

    public void fillPassword(String password) {
        password_textbox.sendKeys(password);
    }

    public static void confirmPassword(String password) {
        confirm_password_textbox.sendKeys(password);
    }
}
