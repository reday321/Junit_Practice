import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class MyJunitAutomation {
    WebDriver driver;

    @BeforeAll
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

    }


    @Test
    @DisplayName("Visit Url and Check if title is Showing properly")
    public void visitUrl() {
        driver.get("https://demoqa.com/elements");
        String currenUrl = driver.getCurrentUrl();
        String actualResult = driver.getTitle();
        String expectedResult = "DEMOQA";
        Assertions.assertEquals(expectedResult, actualResult);
        Assertions.assertTrue(currenUrl.contains("elements"));
        //System.out.println(driver.getPageSource());

    }
@Test
    public void formFillup() {
        driver.get("https://demoqa.com/text-box");
        List<WebElement> fulform = driver.findElements(By.className("form-control"));
        fulform.get(0).sendKeys("Reday");
        fulform.get(1).sendKeys("reday@gmail.com");
        fulform.get(2).sendKeys("Dhaka");
        fulform.get(3).sendKeys("Pabna");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");
        driver.findElements(By.tagName("button")).get(1).click();


    }

    //  @AfterAll
    public void Quit() {
        driver.quit();
    }
}
