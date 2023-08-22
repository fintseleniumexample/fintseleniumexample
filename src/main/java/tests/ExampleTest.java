package tests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import util.Util;
public class ExampleTest {
    private WebDriver driver;
    public Util util;
    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\SatheeshGuduru\\Desktop\\Training Slides\\SeleniumEx\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        util=new Util();
    }
    @Test
    public void Seleniumtest1() {
        System.out.println("In test 1");
        driver.get("https://phptravels.com/demo");
        driver.manage().window().maximize();
        util.sleepFor(4);
        String expectedPageTitle = "Book Your Free Demo Now - Phptravels";
        Assert.assertEquals(driver.getTitle(), expectedPageTitle,"selenium example test");
    }
    @AfterClass
    public void tearDown() {
        if (driver != null)
            driver.quit();
    }
}