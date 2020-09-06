package com.techproed;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class Dday10_DropDownOrnek {

    static WebDriver driver;
    @Before
    public void methoddanOnce(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

    }

    @Test
    public void test1(){
        driver.get("http:/amazon.com");
       WebElement dropDown = driver.findElement(By.id("searchDropdownBox"));
       Select select = new Select(dropDown);
       select.selectByVisibleText("Software");
        WebElement arama = driver.findElement(By.id("twotabsearchtextbox"));
        arama.sendKeys("JAVA" + Keys.ENTER);
        WebElement sonuc = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        System.out.println(sonuc.getText());

        Assert.assertTrue(sonuc.getText().contains("JAVA"));

    }
}
