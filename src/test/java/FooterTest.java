import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class FooterTest {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeClass
    public void setUp() {
        System.setProperty("chromedriver.exe", "D://ChromeDriver/chromedriver");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void testFooterPresence() {
        driver.get("https://only.digital/");

        WebElement footer = driver.findElement(By.tagName("footer"));
        Assert.assertNotNull(footer, "Footer is not present on the page.");
    }

    @Test
    public void testFooterLinksCount() {
        driver.get("https://only.digital/");

        WebElement footer = driver.findElement(By.tagName("footer"));
        List<WebElement> footerLinks = footer.findElements(By.tagName("a"));

        Assert.assertTrue(footerLinks.size() > 0, "No links found in the footer.");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
