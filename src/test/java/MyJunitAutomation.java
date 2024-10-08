import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import utils.Utils;

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

        Utils.scroll(driver, 500);
        driver.findElements(By.tagName("button")).get(1).click();


    }

    @DisplayName("Click on Buttons")
    @Test
    public void clickButton() {
        driver.get("https://demoqa.com/buttons");
        List<WebElement> buttons = driver.findElements(By.cssSelector("[type=button]"));

        Actions actions = new Actions(driver);
        actions.doubleClick(buttons.get(1)).perform();
        actions.contextClick(buttons.get(2)).perform();
        actions.click(buttons.get(3)).perform();
    }
    @Test
    public void AlertHandle() throws InterruptedException {
        driver.get("https://demoqa.com/alerts");

        driver.findElement(By.id("alertButton")).click();
        Thread.sleep(2000);
        driver.switchTo().alert().accept();

        driver.findElement(By.id("timerAlertButton")).click();
        Thread.sleep(5000);
        driver.switchTo().alert().accept();

        driver.findElement(By.id("confirmButton")).click();
        driver.switchTo().alert().accept();

    }

    //  @AfterAll
    public void Quit() {
        driver.quit();
    }
}
