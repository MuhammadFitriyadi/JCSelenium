package com.jcSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class ShopDemoQA {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\juaracoding\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        JavascriptExecutor js = (JavascriptExecutor) driver;

        String url = "https://shop.demoqa.com";
        driver.get(url);
        System.out.println("Get URL : " + url);
        driver.manage().window().maximize();
        System.out.println("Maximize Browser");

        driver.findElement(By.xpath("/html/body/p/a")).click();
        System.out.println("Click - Dismiss");

        driver.findElement(By.cssSelector("a[href='https://shop.demoqa.com/my-account/']")).click();
        System.out.println("Click - My Account");

        js.executeScript("window.scrollBy(0, 700)");
        System.out.println("=== Scroll ===");

        //login
        driver.findElement(By.id("username")).sendKeys("riyadi_revolver");
        System.out.println("Fill - Username");
        driver.findElement(By.id("password")).sendKeys("v2c47jtr()");
        System.out.println("Fill - Password");
        driver.findElement(By.id("rememberme")).click();
        System.out.println("Click - Remember Me");
        driver.findElement(By.cssSelector("button[value='Login']")).click();
        System.out.println("Click - Log in");

        driver.findElement(By.cssSelector("a[href='https://shop.demoqa.com/']")).click();
        System.out.println("Click - Home");

        js.executeScript("window.scrollBy(0, 800)");
        System.out.println("=== Scroll ===");

        //Shopping
        driver.findElement(By.cssSelector("a[href='https://shop.demoqa.com/product/black-color-block-high-neck-sweater/']")).click();
        System.out.println("Click - Item");

        js.executeScript("window.scrollBy(0, 700)");
        System.out.println("=== Scroll ===");

        Select color = new Select(driver.findElement(By.id("pa_color")));
        color.selectByIndex(1);
        System.out.println("Color - Black");

        Select size = new Select(driver.findElement(By.id("pa_size")));
        size.selectByIndex(2);
        System.out.println("Size - 34");

        driver.findElement(By.cssSelector("button[name='add-to-cart']")).click();
        System.out.println("Click - Add To Cart");

        System.out.println("=== Delay 3 seconds ===");
        Thread.sleep(3000);

        driver.quit();
        System.out.println("Quit Browser");
    }

}
