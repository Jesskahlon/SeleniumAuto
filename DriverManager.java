package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.EdgeDriverManager;
import io.github.bonigarcia.wdm.managers.FirefoxDriverManager;
import io.github.bonigarcia.wdm.managers.SafariDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.ITest;
import org.testng.ITestResult;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class DriverManager extends Utils {
    String browserName = "firefox";
    public  void openBrowser() {
        WebDriverManager.chromedriver().setup();
        if (browserName.equalsIgnoreCase("chrome"))
        {
            driver = new ChromeDriver();
           // System.setProperty("webDriver.chrome.driver", "src/test/java/driver/chromedriver ");
        }else if ( browserName.equalsIgnoreCase("firefox")){
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }else if ( browserName.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }
        else if ( browserName.equalsIgnoreCase("safari")) {
            WebDriverManager.safaridriver().setup();
            driver = new SafariDriver();
        }
        else {
            System.out.println("Either ur browser name is wrong or not provided" + browserName);

        }
        //System.setProperty("WebDriver.chrome.driver", "src/test/java/driver/chromedrive        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));r ");
        driver.manage().window().maximize();
        driver.get("https://demo.nopcommerce.com/");
    }

    public void closeTheBrowser(ITestResult result)  {

        if(!result.isSuccess()){
            try {
                takeScreenShot(result.getName());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        driver.quit();
    }




}