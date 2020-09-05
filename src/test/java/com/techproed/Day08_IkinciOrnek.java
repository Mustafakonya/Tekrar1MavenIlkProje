package com.techproed;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Day08_IkinciOrnek {

    static WebDriver driver;

    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }

    @Before
    public void testtenOnce(){
        driver.get("http:/google.com");
    }

    @Test
    public void test1(){
        WebElement arama = driver.findElement(By.name("q"));
        arama.sendKeys("Baby kangru");
        arama.submit();
    }

    @Test
    public void test2(){
        WebElement arama = driver.findElement(By.name("q"));
        arama.sendKeys("Nike");
        arama.submit();
    }

    @Test
    public void test3(){
        WebElement arama = driver.findElement(By.name("q"));
        arama.sendKeys("Sennheiser kabellos");
        arama.submit();
    }

    @After
    public void testtenSonra(){
        WebElement sonuc = driver.findElement(By.id("result-stats"));
        System.out.println(sonuc.getText());
    }

    @AfterClass
    public static void tearDown(){
        driver.quit();
    }


}
