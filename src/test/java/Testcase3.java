import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Testcase3 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.worldometers.info/gdp/gdp-by-country/");
        Thread.sleep(2000);
/*
        List<WebElement> b = driver.findElements(By.xpath("//th/tr"));
        String[] array={"#","Country","GDP (nominal, 2022)","GDP (abbrev.)","GDP  growth","Population (2022)","GDP  per capita","Share of World GDP"};
        String s1 = Arrays.toString(array);
        List<String> list = new ArrayList<String>();
        System.out.println(list);
        if(b.equals(s1)){
            System.out.println("value is validate");
        }else {
            System.out.println("not validated try again");
        }
*/
        Thread.sleep(2000);
        List<WebElement> elementsList = driver.findElements(By.xpath("//tr/th"));
        List<String> expectedValues = new ArrayList<>();
        expectedValues.add("#");
        expectedValues.add("Country");
        expectedValues.add("GDP\n(nominal, 2022)");
        expectedValues.add("GDP\n(abbrev.)");
        expectedValues.add("GDP\ngrowth");
        expectedValues.add("Population\n(2022)");
        expectedValues.add("GDP\nper capita");
        expectedValues.add("Share of\nWorld GDP");
        System.out.println("expectedValues" + expectedValues);

        //{"#","Country","GDP (nominal, 2022)","GDP (abbrev.)","GDP  growth","Population (2022)","GDP  per capita","Share of World GDP"};
        List<String> actualValues = new ArrayList<>();
        for (WebElement s : elementsList) {
            actualValues.add(s.getText().trim());
        }
        System.out.println("actualValues" + actualValues);

        if (expectedValues.equals(actualValues)) {
            System.out.println("pass");
        } else {
            System.out.println("fail");
        }
        driver.quit();
    }
}