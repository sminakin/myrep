package com.bbc;

import jdk.jfr.Description;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HWLocatorsXPATH extends WebDriverSettings {

    @Test
    @Description("https://prnt.sc/hniltk")
    public void testScreen1_XPATH() {
        driver.get(site);
        By loc = By.xpath("//div[@class='orb-nav-section orb-nav-search']");
        wt.until(ExpectedConditions.elementToBeClickable(loc));
        driver.findElement(loc).click();
        wt.until(ExpectedConditions.not(ExpectedConditions.titleIs(title)));
    }

    @Test
    @Description("https://prnt.sc/26by42m")
    public void testScreen2_XPATH() {
        driver.get(site);
        By loc = By.xpath("//nav[@class='orbit-header-links international']//li[@class='orb-nav-reeldotcom']");
        wt.until(ExpectedConditions.elementToBeClickable(loc));
        driver.findElement(loc).click();
        wt.until(ExpectedConditions.not(ExpectedConditions.titleIs(title)));
    }

    @Test
    @Description("https://prnt.sc/hnigl5")
    public void testScreen3_XPATH() {
        driver.get(site);
        By loc = By.xpath("//section[@class='module module--promo']//li[@class='media-list__item media-list__item--1']");
        wt.until(ExpectedConditions.elementToBeClickable(loc));
        driver.findElement(loc).click();
        wt.until(ExpectedConditions.not(ExpectedConditions.titleIs(title)));
    }

    @Test
    @Description("https://prnt.sc/jyziar")
    public void testScreen4_XPATH() {
        driver.get(site);

        int i = 2;
        boolean isFound = false;

        while (true) {
            String loc = "//nav[@class='orbit-header-links international']/ul";
            wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc)));

            if (i <= driver.findElements(By.xpath(loc + "/li")).size()) {
                WebElement element = driver.findElement(By.xpath(loc + "/li[position() = " + i + "]"));

                if (element.isDisplayed()) {
                    wt.until(ExpectedConditions.elementToBeClickable(By.xpath(loc + "/li[position() = " + i + "]")));
                    element.click();
                    wt.until(ExpectedConditions.not(ExpectedConditions.titleIs(title)));
                    driver.navigate().back();
                    wt.until(ExpectedConditions.titleIs(title));

                    if (!isFound) {
                        isFound = true;
                    }

                    i += 2;
                }
                else {
                    break;
                }
            }
            else {
                break;
            }
        }

        Assert.assertTrue(isFound);
    }

    @Test
    @Description("https://prnt.sc/hnij47")
    public void testScreen5_XPATH() {
        driver.get("https://www.bbc.com/");

        String mark = "Welcome to BBC.com";
        By loc = By.xpath("//h2[@class='module__title' and ./span[contains(text(), '" + mark + "')]]");
        wt.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(loc));
        String currDate = driver.findElement(loc).getText().replace(mark + "\n", "");

        loc = By.xpath("//div[@class='orb-nav-section orb-nav-search']");
        wt.until(ExpectedConditions.elementToBeClickable(loc));
        driver.findElement(loc).click();
        wt.until(ExpectedConditions.not(ExpectedConditions.titleIs(title)));

        loc = By.xpath("//input[@id='search-input']");
        wt.until(ExpectedConditions.visibilityOfElementLocated(loc));
        driver.findElement(loc).sendKeys(currDate);

        loc = By.xpath("//button[@type='submit']");
        wt.until(ExpectedConditions.elementToBeClickable(loc));
        driver.findElement(loc).click();
        wt.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//ul[@class='ssrcss-1020bd1-Stack e1y4nx260']/li")));
    }
}
