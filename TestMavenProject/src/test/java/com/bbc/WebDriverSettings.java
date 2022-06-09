package com.bbc;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WebDriverSettings {

    public String site = "https://www.bbc.com";
    public String title = "BBC - Homepage";
    public ChromeDriver driver;
    public WebDriverWait wt;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\JetBrains\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1920, 1080));
        wt = new WebDriverWait(driver, Duration.ofSeconds(20));

        System.out.println("Test has been started...");
    }

    @After
    public void close() {
        driver.quit();

        System.out.println("Test finished.");
    }
}
