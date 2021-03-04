import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogInAdme {

    private static final String LOGIN = "kiriakoskareklas2020@gmail.com";
    private static final String PASSWORD = "titonica";

    public static void main (String [] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://adme.ru");

        logIn(driver);
        driver.quit();
    }

    public static void logIn (WebDriver driver){

        driver.findElement(By.id("onetrust-accept-btn-handler")).click();

        driver.findElement(By.xpath("//*[@data-test-id='user-menu']")).click();

        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@data-test-id='email-field']/input")));
        driver
                .findElement(By.xpath("//*[@data-test-id='email-field']/input"))
                .sendKeys(LOGIN);

        driver
                .findElement(By.xpath("//*[@data-test-id='password-field']/input"))
                .sendKeys(PASSWORD);

        driver.findElement(By.xpath("//*[@data-test-id='login-dialog']//*[@data-test-id='submit-button']")).click();



    }
}
