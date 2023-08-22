package tests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
        System.out.println("==== in before class ==");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\SatheeshGuduru\\Desktop\\Fint-Selenium-example\\fintseleniumexample\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        util=new Util();
    }
    @Test
    public void Seleniumtest1() {
        System.out.println("==== in test ==");
        System.out.println("In test 1");
        driver.get("https://phptravels.com/demo");
        driver.manage().window().maximize();
        util.sleepFor(5);
        String expectedPageTitle = "Book Your Free Demo Now - Phptravels";
        System.out.println("page title===>"+driver.getTitle());
        Assert.assertEquals(driver.getTitle(), expectedPageTitle,"selenium example test");
        String headerText = "Demonstration";
       WebElement pageHeader= driver.findElement(By.xpath("//h1[@class='mb-0']"));
        System.out.println("Actual headerText===>"+pageHeader.getText());
        Assert.assertEquals(pageHeader.getText(), headerText,"verifying the header text");
        WebElement submitElement= driver.findElement(By.id("demo"));

        System.out.println("submitElement text::  "+submitElement.getText());
        System.out.println("submitElement class name:: "+submitElement.getAttribute("class"));
    }
    @AfterClass
    public void tearDown() {
        System.out.println("==== in after  class ==");
        if (driver != null)
            driver.quit();
    }
}