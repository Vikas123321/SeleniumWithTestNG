import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCase2 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.cleartrip.com");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@class=\" c-pointer c-neutral-900\"]")).click();
        Thread.sleep(2000);

/*
        for (int i = 0; i < 20; i++) {
            if (driver.findElement(By.xpath("//a[@title=\"About Us\"]")).isDisplayed()) {
                System.out.println("element displayed");
            } else {
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("window.scroll(0,200)");
            }
        }
*/

        WebElement element = driver.findElement(By.xpath("//a[@title=\"About Us\"]"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView()", element);
        Thread.sleep(5000);

//        driver.findElement(By.xpath("//a[@title=\"About Us\"]")).click();
        element.click();

        Thread.sleep(2000);
        driver.quit();

    }
}

