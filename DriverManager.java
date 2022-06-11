package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.EdgeDriverManager;
import io.github.bonigarcia.wdm.managers.FirefoxDriverManager;
import io.github.bonigarcia.wdm.managers.SafariDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.ITest;
import org.testng.ITestResult;

import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class DriverManager extends Utils {
   // String browserName = "chrome";
    DesiredCapabilities caps = new DesiredCapabilities();
    LoadProp loadProp = new LoadProp();

    public  final String USERNAME = loadProp.getProperty("bsUsername");
    public  final String AUTOMATE_KEY = loadProp.getProperty("bsAccesskey");
    public  final String BrowserStackURL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
    boolean cloud = Boolean.parseBoolean((System.getProperty("cloud")));
    //String browserName = "chrome";
    //String browserName = System.getProperty("browser");
    String browserName = System.getProperty("browser");
    public  void openBrowser() {
        if(cloud) {
            System.out.println("running cloud");
            if (browserName.equalsIgnoreCase("chrome")) {
                System.out.println("Browser is chrome");

                caps.setCapability("os", "Windows");
                caps.setCapability("os_version", "10");
                caps.setCapability("browser", "Chrome");
                caps.setCapability("browser_version", "latest");
                caps.setCapability("browserstack.selenium_version", "4.1.0");

            } else if (browserName.equalsIgnoreCase("firefox")){
                System.out.println("Browser is Firefox");

                caps.setCapability("os", "Windows");
                caps.setCapability("os_version", "10");
                caps.setCapability("browser", "Firefox");
                caps.setCapability("browser_version", "latest");
                caps.setCapability("browserstack.local", "false");
                caps.setCapability("browserstack.selenium_version", "4.1.0");


            }else if ( browserName.equalsIgnoreCase("edge")) {
                System.out.println("Browser is Edge");
                caps.setCapability("os", "Windows");
                caps.setCapability("os_version", "10");
                caps.setCapability("browser", "Edge");
                caps.setCapability("browser_version", "latest");
                caps.setCapability("browserstack.local", "false");
                caps.setCapability("browserstack.selenium_version", "4.1.0");

            }
        else {
            System.out.println("Either ur browser name is wrong or not provided" + browserName);
        }
            try {
                driver = new RemoteWebDriver(new URL(BrowserStackURL),caps);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }else{
            System.out.println("Running Locally............");
            if(browserName.equalsIgnoreCase("chrome")){
            //System.setProperty("webDriver.chrome.driver", "src/test/java/driver/chromedriver ");
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
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
        }







        //WebDriverManager.chromedriver().setup();


//        if (browserName.equalsIgnoreCase("chrome"))
//        {
//            driver = new ChromeDriver();
//           // System.setProperty("webDriver.chrome.driver", "src/test/java/driver/chromedriver ");
//        }else if ( browserName.equalsIgnoreCase("firefox")){
//            WebDriverManager.firefoxdriver().setup();
//            driver = new FirefoxDriver();
//        }else if ( browserName.equalsIgnoreCase("edge")) {
//            WebDriverManager.edgedriver().setup();
//            driver = new EdgeDriver();
//        }
//        else if ( browserName.equalsIgnoreCase("safari")) {
//            WebDriverManager.safaridriver().setup();
//            driver = new SafariDriver();
//        }
//        else {
//            System.out.println("Either ur browser name is wrong or not provided" + browserName);
//
//        }
        //System.setProperty("WebDriver.chrome.driver", "src/test/java/driver/chromedriver.exe"0        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));r ");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://demo.nopcommerce.com/");
    }

    public void closeTheBrowser()  {




        driver.quit();
    }



}