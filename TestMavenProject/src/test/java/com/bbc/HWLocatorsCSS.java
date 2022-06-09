package com.bbc;

import jdk.jfr.Description;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class HWLocatorsCSS extends WebDriverSettings {

    @Test
    @Description("https://prnt.sc/hniltk")
    public void testScreen1_CSS() {
        driver.get(site);
        By loc = By.cssSelector("div.orb-nav-section.orb-nav-search");
        wt.until(ExpectedConditions.elementToBeClickable(loc));
        driver.findElement(loc).click();
        wt.until(ExpectedConditions.not(ExpectedConditions.titleIs(title)));
    }

    @Test
    @Description("https://prnt.sc/26by42m")
    public void testScreen2_CSS() {
        driver.get(site);
        By loc = By.cssSelector("nav.orbit-header-links.international li.orb-nav-reeldotcom");
        wt.until(ExpectedConditions.elementToBeClickable(loc));
        driver.findElement(loc).click();
        wt.until(ExpectedConditions.not(ExpectedConditions.titleIs(title)));
    }

    @Test
    @Description("https://prnt.sc/hnigl5")
    public void testScreen3_CSS() {
        driver.get(site);
        By loc = By.cssSelector("section.module.module--promo li.media-list__item.media-list__item--1");
        wt.until(ExpectedConditions.elementToBeClickable(loc));
        driver.findElement(loc).click();
        wt.until(ExpectedConditions.not(ExpectedConditions.titleIs(title)));
    }

    @Test
    @Description("https://prnt.sc/jyziar")
    public void testScreen4_CSS() {
        driver.get(site);

        int i = 2;
        boolean isFound = false;

        while (true) {
            String loc = "nav.orbit-header-links.international>ul";
            wt.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(loc)));

            if (i <= driver.findElements(By.cssSelector(loc + ">li")).size()) {
                WebElement element = driver.findElement(By.cssSelector(loc + ">li:nth-child(" + i + ")"));

                if (element.isDisplayed()) {
                    wt.until(ExpectedConditions.elementToBeClickable(By.cssSelector(loc + ">li:nth-child(" + i + ")")));
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
    public void testScreen5_CSS() {
        driver.get(site);

        By loc = By.cssSelector("h2.module__title");
        wt.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(loc));
        List<WebElement> listOfElements = driver.findElements(loc);

        String currDate = "";
        String buff = "";
        String mark = "Welcome to BBC.com\n";

        for (int i = 0; i < listOfElements.size(); i++) {
            buff = listOfElements.get(i).getText();

            if (buff.contains(mark)) {
                currDate = buff.replace(mark, "");
                break;
            }
        }

        Assert.assertNotEquals(currDate, "");

        loc = By.cssSelector("div.orb-nav-section.orb-nav-search");
        wt.until(ExpectedConditions.elementToBeClickable(loc));
        driver.findElement(loc).click();
        wt.until(ExpectedConditions.not(ExpectedConditions.titleIs(title)));

        loc = By.cssSelector("#search-input");
        wt.until(ExpectedConditions.visibilityOfElementLocated(loc));
        driver.findElement(loc).sendKeys(currDate);

        loc = By.cssSelector("button[type=submit]");
        wt.until(ExpectedConditions.elementToBeClickable(loc));
        driver.findElement(loc).click();
        wt.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("ul.ssrcss-1020bd1-Stack.e1y4nx260>li")));
    }
}
