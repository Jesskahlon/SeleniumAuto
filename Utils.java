package org.example;
//import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
//import org.openqa.selenium.support.ui.Select;
//import org.testng.Assert;
//import org.testng.annotations.Test;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.regex.Pattern;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.xml.xpath.XPath;

public class Utils extends BasePage {

    public static void takeScreenShot(String a){

        TakesScreenshot scrnShot = ((TakesScreenshot)driver);


        File srcFile = scrnShot.getScreenshotAs(OutputType.FILE);
        try{
            FileUtils.copyFile(srcFile, new File( "/Users/jasvinderkaur/IdeaProjects/seleniumAutomation01/screenShot"+a+randomDate()+".ping"));

        }catch(IOException e){
            e.printStackTrace();
        }
    }


    public static String randomDate() {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyyyHHmmss");
        String format = formatter.format(date);
        return formatter.format(date);
    }
    public static void clickButton(By by){
        driver.findElement(by).click();
    }
    public static void typeText(By by, String text){

        driver.findElement(by).sendKeys(text);
    }
    public static void driverWaitsUntil(By by, int time) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.elementToBeClickable(by)).click();
    }
    public static void driverWaitUntilUrlTOBe(int time, String url) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.urlToBe(url));
    }

    public static String getText(By by) {
        return driver.findElement(by).getText();

    }
    // public static void textToBe ( int time, By by, String value){
    //        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
    //        wait.until(ExpectedConditions.textToBe(by, value));
    //    }
////        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    public static void presenceOfElement(By by, int time) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
    }

    public static void driverUrlContains(int time, String URLContains) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.urlContains(URLContains));
    }

    public static void titleContains(int time, String title) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.titleContains(title));
    }

    public static void invisibilityOfElement(int time, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.invisibilityOf(element));
    }



    public static void alertPresent ( int time){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.alertIsPresent());
    }

    public static void atributeToBe ( int time, By by, String atribute, String value){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.attributeToBe(by, atribute, value));
    }

    public static void tillAttributeNotEmpty ( int time, WebElement element, String attribute){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.attributeToBeNotEmpty(element, attribute));
    }

    public static void elementToBeSelected ( int time, WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.elementToBeSelected(element));
    }

    public static void textToBe ( int time, By by, String value){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.textToBe(by, value));
    }

    public static void textToBeMatch ( int time, By by, Pattern pattern){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.textMatches(by, pattern));
    }

    public static void domAttributeToBe ( int time, String value, WebElement element, String attribute){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.domAttributeToBe(element, attribute, value));
    }
    //        public void tickCheckBox(){
//        driver.findElement(by).t
//        }

    // All reusable methoed
}
