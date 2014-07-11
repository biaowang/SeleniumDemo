package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class AmazonHomePage {
    public static final String SIGN_IN_TITLE_ID = "nav-signin-title";
    public static final String URL = "http://www.amazon.cn";
    public static final String YOUR_ACCOUNT_SECTION_ID = "nav-your-account";
    public static final String SIGN_IN_LINK_TEXT = "免费注册";
    public static final String SIGN_IN_PAGE_TITLE = "Amazon.cn 注册";

    @FindBy(linkText = SIGN_IN_LINK_TEXT)
    public WebElement sign_in_link;

    private WebDriver webDriver;

    public AmazonHomePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void navToSignIn() {
        new Actions(webDriver).moveToElement(webDriver.findElement(By.id(YOUR_ACCOUNT_SECTION_ID))).perform();
    }

    public void clickSignIn() {
        sign_in_link.click();
    }
}
