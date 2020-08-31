import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class MainPage {

    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    By nameField = By.xpath("//div[@class=\"label js-fiz\"]/div//input[@name=\"full_name\"]");
    By emailField = By.xpath("//div[@class=\"label\"]//input[@name=\"email\"]");
    By orderButton = By.xpath("//a[text()=\"Заказать\"]");
    By heading = By.xpath("//div[text()='Поздравляем!']");


    public MainPage ClickOnOrderButton() {
        driver.findElement(orderButton).click();
        return this;
    }

    public MainPage typeName(String username) {
        driver.findElement(nameField).sendKeys(username);
        return this;
    }

    public MainPage typeEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
        return this;
    }

    public String getHeadingText() {
        WebDriverWait wait = (new WebDriverWait(driver, 5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Поздравляем!']")));
        return driver.findElement(heading).getText();
    }

    public MainPage addNewUser(String username, String email) {

        this.typeName(username);
        this.typeEmail(email);
        this.ClickOnOrderButton();

        return new MainPage(driver);

    }

}
