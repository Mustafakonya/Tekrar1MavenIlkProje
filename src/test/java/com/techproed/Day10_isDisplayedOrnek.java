package com.techproed;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Day10_isDisplayedOrnek {

    static WebDriver driver;

    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();

    }

    @Before
    public void methoddanOnce(){

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.get("http:/bestbuy.com");
    }

    @Test
    public void titleTest(){
        String title = driver.getTitle();
        boolean varMi = title.contains("Best");
        Assert.assertTrue(varMi);
    }

    @Test
    public void logoTest(){
        WebElement logo = driver.findElement(By.className("logo"));
        boolean gorunuyorMu = logo.isDisplayed();
        Assert.assertTrue(gorunuyorMu);
    }

    @Test
    public void mexicoLinkTest(){
        WebElement link = driver.findElement(By.partialLinkText("Mexico"));
        boolean tiklaniyorMu = link.isEnabled();
        Assert.assertTrue(tiklaniyorMu);
    }

    @After
    public void methoddanSonra(){
        driver.quit();
    }

    @AfterClass
    public static void tearDown(){

    }


}
