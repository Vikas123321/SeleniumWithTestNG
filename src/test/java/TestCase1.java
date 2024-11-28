import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.LocalDate;
import java.util.Set;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class TestCase1 {
    public static void main(String[] args) throws InterruptedException {
        TestCase1 t = new TestCase1();

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.cleartrip.com/");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@class=\" c-pointer c-neutral-900\"]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@placeholder=\"Where from?\"]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//p[@class=\"tt-ellipsis o-hidden ws-nowrap fs-14 fw-500\"])[1]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@placeholder=\"Where to?\"]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//p[@class=\"tt-ellipsis o-hidden ws-nowrap fs-14 fw-500\"])[6]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@class=\"flex flex-middle p-relative homeCalender\"]")).click();
        Thread.sleep(2000);
        //selecting from date
        driver.findElement(By.xpath("(//div[@class='c-inherit flex flex-1 flex-nowrap fs-16 fw-500 card-price'])[3]")).click();
        //clicking on date
        driver.findElement(By.xpath("//*[text()='" + t.getCurrentDatePlus1() + "']")).click();
        Thread.sleep(2000);
        //selecting to date
        driver.findElement(By.xpath("//*[text()='Return']")).click();
        Thread.sleep(2000);
        //driver.findElement(By.xpath("//span[@class=\" c-neutral-400 flex flex-nowrap fs-16 fw-500\"]")).click();
        driver.findElement(By.xpath("//*[text()='" + t.getCurrentDatePlus2() + "']")).click();
        Thread.sleep(2000);
        //driver.findElement(By.xpath("(//div[@class=\"p-1 day-gridContent fs-14 fw-500 flex flex-middle flex-column flex-center flex-top\"])[7]")).click();
        // Thread.sleep(2000);
        driver.findElement(By.xpath(" (//*[@class='sc-gEvEer cmEgze'])[2]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//*[text()='Departure'])[1]")).isDisplayed();
        boolean b = driver.findElement(By.xpath("(//*[text()='Departure'])[1]")).isDisplayed();
        if(b){
            System.out.println("flights are displayed");
        }else {
            System.out.println("try again");
        }
        Thread.sleep(2000);
        driver.findElement(By.xpath("//svg[@class=\"t-all c-secondary-500 ml-2\"]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[text( )='One way']"));
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@class=\" h-10  bg-black c-white bc-transparent c-pointer w-100p py-1 px-3 h-8 fs-3 fw-600 t-all button bs-solid tp-color td-500 bw-1 br-4 lh-solid box-border\"]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//button[@class=\"h-10 flex-1 br-8 bg-intlnew-orange bg-primary-500 hover:bg-primary-600 c-white bc-transparent c-pointer w-100p py-1 px-3 h-8 fs-3 fw-600 t-all button bs-solid tp-color td-500 bw-1 br-4 lh-solid box-border\"])[1]")).click();
        driver.findElement(By.xpath("//span[@class=\"fw-600 fs-3\"]")).click();
        Thread.sleep(2000);

        String ParentWindowHandle = driver.getWindowHandle();
        System.out.println("parent window handle" + ParentWindowHandle);

        Set<String> windowHandles = driver.getWindowHandles();
        System.out.println("WindowHandle" + windowHandles);

        for (String h : windowHandles){
            if (h.equals(ParentWindowHandle)){
                System.out.println("variable h has parent handle");
            }else {
                driver.switchTo().window(h);
                System.out.println("swithed to " + h);
            }

        }

        driver.quit();

    }

    public String getCurrentDatePlus1(){
        LocalDate currentDate = LocalDate.now().plusDays(1);
        return currentDate.toString().substring(8);
    }

    public String getCurrentDatePlus2(){
        LocalDate currentDate = LocalDate.now().plusDays(2);
        return currentDate.toString().substring(8);
    }

}
