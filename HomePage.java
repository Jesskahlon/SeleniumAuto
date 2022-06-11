package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class
HomePage  extends Utils {
    LoadProp loadprop = new LoadProp();

    //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@--------LOCATORS----------@@@@@@@@@@@@@@@@@@@@@@@@@@@@
    private By _buttonRegister = By.className("ico-register");
    private By _buttonBuildYourOwnComputer = By.xpath("//h2/a[@href=\"/build-your-own-computer\"]");
    private By _dropDownButtonCurrency = By.name("customerCurrency");
    private By _actualMessageIs$1200 = By.xpath("//span[contains(text(),'$1,200.00')]");private By _currencyInEuro = By.xpath("//div/span[@class=\"price actual-price\"][2]");
    private By _featureProductList = By.xpath("//div[@class=\"product-grid home-page-product-grid\"]//h2");
    private By _textBoxSearch = By.name("q");
    private By _SearchButton = By.xpath("//button[@type=\"submit\"]");

    public void verifyUserIsOnHomePage() {
        driverWaitUntilUrlTOBe(30, loadprop.getProperty("url"));
    }

    // Register Button
    public void userClickOnRegisterButton() {
        clickButton(_buttonRegister);
    }

    public void userClickOnBuildYourOwnComputer() {
        //Build your own Comp button
        clickButton(_buttonBuildYourOwnComputer);
    }//

    public void userShouldBeAbleToSeeThePriceAccordingToSelectedCurrency() {
        // click on currency button
        Select Currency = new Select(driver.findElement(_dropDownButtonCurrency));
        //Select Currency in Dollars from dropdown
        Currency.selectByValue(loadprop.getProperty("DropDownValueSelectedInDollar"));
        // expected result
        String expectedMessage = loadprop.getProperty("ExpectedMessageIs$1200");
        //Verify that build your own computer price is visible in "Dollars"
        String actualMessage = driver.findElement(_actualMessageIs$1200).getText();
        //assert point to compare actual and expected
        Assert.assertEquals(actualMessage, expectedMessage, "Price in Dollar not found");

        //********************change currency from Dollar to Euro**************************

        // click on currency button
        clickButton(_dropDownButtonCurrency);
        //Select Currency in Euro from dropdown
        Select currency = new Select(driver.findElement(_dropDownButtonCurrency));
        //Verify that build your own computer price is visible in "Euro"
        currency.selectByValue("https://demo.nopcommerce.com/changecurrency/6?returnUrl=%2F");
        // expected result
        String ExpectedMessage = "€1032.00";
        //Verify that build your own computer price is visible in "Euros"
        String ActualMessage = driver.findElement(By.xpath("//span[contains(text(),'€1032.00')]")).getText();
        //assert point to compare actual and expected
        Assert.assertEquals(actualMessage, expectedMessage, "Price in Euro not found");

    }

    public void userShouldBeAllowedToVoteOnlyAfterRegistration() {
        //click on radio button good
        clickButton(By.id(loadprop.getProperty("radioButtonGood")));
        //click on vote
        clickButton(By.id(loadprop.getProperty("buttobVote")));
        //Total Votes Text
        // getText(By.className("poll-total-votes"));
        presenceOfElement(By.className(loadprop.getProperty("messageTotalVotes")), 10);
    }

    public void userShouldBeAbleToAddProductInWishList() {
        //Select Mobile = new Select(driver.findElement(By.xpath("//h2/a[@href=\"/htc-one-m8-android-l-50-lollipop\"]")));
        // Mobile.selectByValue("    onclick=\"return AjaxCart.addproducttocart_catalog(\"/addproducttocart/catalog/18/2/1\"),!1\"\n");
        clickButton(By.cssSelector("return AjaxCart.addproducttocart_catalog(\"/addproducttocart/catalog/18/2/1\"),!1\""));
        String expectedMessage = "The product has been added to your wishlist";
        String actualMessage = driver.findElement(By.className("bar-notification success")).getText();
        //assert point to compare actual and expected
        Assert.assertEquals(actualMessage, expectedMessage, "The product is failed tobe added in wishlist");

    }

    public void handleMultipleWindows() {
        //driver.get(loadprop.getProperty("url"));
        String parent = driver.getWindowHandle();
        System.out.println("Parent Window ID is :" + parent);
        clickButton(By.xpath("//a[contains(@href,'http://www.facebook.com/nopCommerce')]"));
        Set<String> allWindow = driver.getWindowHandles();
        int count = allWindow.size();
        System.out.println("Total Windows : " + count);
        for (String child : allWindow) {
            if (!parent.equalsIgnoreCase(child))
                driver.switchTo().window(child);
            System.out.println("Child Window id is : " + child);
            driver.close();

        }
    }

    public void getProductTitles() {
        driver.get(loadprop.getProperty("url"));
        List<WebElement> productTitles = driver.findElements(_featureProductList);
        System.out.println(productTitles.size());
        List<String> expectedProductTitles = Arrays.asList();//
        //List<String> act
        for (WebElement e : productTitles) {
            System.out.println(e.getText());
        }
    }

    public void userShouldBeAbleToSearchProductByName(){
        // type product name Nike in search button
        typeText(_textBoxSearch,loadprop.getProperty("Product"));
        //Search Button
        clickButton(_SearchButton);
        String currentURL = driver.getCurrentUrl();
        System.out.println(currentURL);


        }
        public void newRelease(){
        //click on nopCommerce new release!
        clickButton(By.xpath("//a[contains(@href,'nopcommerce-new-release')][1]"));
        }
    }
