import Pages.AmazonHomePage;
import Pages.RegistrationInfoPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AmazonShoppingFlowTest {

    public static final String USER_NAME = "12345test";
    public static final String USER_EMAIL = "12345test@test.com";
    public static final String PASSWORD = "welcome123";

    public static final int TIME_OUT_IN_SECONDS = 5;
    private static WebDriverWait wait;
    private static WebDriver webDriver;

    private RegistrationInfoPage registrationInfoPage;
    private AmazonHomePage amazonHomePage;

    @Before
    public void setUp() throws Exception {
        webDriver = new ChromeDriver();
        amazonHomePage = PageFactory.initElements(webDriver, AmazonHomePage.class);
        registrationInfoPage = PageFactory.initElements(webDriver, RegistrationInfoPage.class);
        wait = new WebDriverWait(webDriver, TIME_OUT_IN_SECONDS);
    }

    @Test
    public void testShoppingFlow() throws Exception {
        webDriver.get(AmazonHomePage.URL);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id(AmazonHomePage.SIGN_IN_TITLE_ID)));
        amazonHomePage.navToSignIn();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText(AmazonHomePage.SIGN_IN_LINK_TEXT)));
        amazonHomePage.clickSignIn();
        wait.until(ExpectedConditions.titleIs(AmazonHomePage.SIGN_IN_PAGE_TITLE));
        fillRegistrationInfo();
    }

    private void fillRegistrationInfo() {
        registrationInfoPage = new RegistrationInfoPage();
        registrationInfoPage.fillUserName(USER_NAME);
        registrationInfoPage.fillEmail(USER_EMAIL);
        registrationInfoPage.confirmEmail(USER_EMAIL);
        registrationInfoPage.fillPassword(PASSWORD);
        registrationInfoPage.confirmPassword(PASSWORD);
    }

    @After
    public void tearDown() throws Exception {
        webDriver.close();
    }
}
