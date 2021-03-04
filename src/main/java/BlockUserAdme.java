import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BlockUserAdme extends LogInAdme {

    public static void main (String [] args)  throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        JavascriptExecutor jsDriver = (JavascriptExecutor) driver;

        driver.get("https://adme.ru");

        logIn(driver);


            WebDriverWait wait = new WebDriverWait(driver, 10);

            driver
                    .findElement(By.xpath("//*[@data-test-id='article-list-element-0']//*[@data-test-id='logo-link']"))
                    .click();

            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@data-test-id='comments-link']")));
            WebElement commentLink = driver.findElement(By.xpath("//*[@data-test-id='comments-link']"));
            jsDriver.executeScript("arguments[0].scrollIntoView(true);", commentLink);
            commentLink.click();

            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@data-test-id='comment-1']//*[@data-test-id='comment-menu-toggler']")));
            driver
                    .findElement(By.xpath("//*[@data-test-id='comment-1']//*[@data-test-id='comment-menu-toggler']"))
                    .click();
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@data-test-id='menu-item-block']")));
            driver
                    .findElement(By.xpath("//*[@data-test-id='menu-item-block']"))
                    .click();
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@data-test-id='submit-button']//div[.='Заблокировать']")));
            driver
                    .findElement(By.xpath("//*[@data-test-id='submit-button']//div[.='Заблокировать']"))
                    .click();

            driver.quit();


    }

}
