
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;


public class FirstTest {

    private WebDriver driver;
    private MainPage mainPage;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "lib\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://timeweb.com/ru/services/hosting/?_ga=2.259598732.788492269.1598350967-137949186.1598350967#hosting-optimo");
        mainPage = new MainPage(driver);
    }

    @Test
    public void signInTest() {
        String a = String.valueOf((int) (Math.random() * (9999999999l - 1000000000) + 1000000000));
        MainPage head = mainPage.addNewUser("Test", "test" + a + "@mail.com");
        String heading = head.getHeadingText();
        assertEquals("Поздравляем!", heading);

    }

    @After
    public void tearDown() {
        driver.quit();
    }

}
