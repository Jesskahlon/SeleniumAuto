package org.example;

import org.example.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.Arrays;
import java.util.List;


public class HomePage  extends Utils {
    LoadProp loadprop = new LoadProp();

    private By _buttonRegister = By.className("ico-register");
    private By _buttonBuildYourOwnComputer = By.xpath("//h2/a[@href=\"/build-your-own-computer\"]");
    private By _dropDownButtonCurrency = By.name("customerCurrency");
    ///private By _currencyInDollar = By.xpath("//div/span[@class=\"price actual-price\"][1]");
    //select[@name="customerCurrency"]
    ////div/span[@class="price actual-price"][1]
    private By _currencyInEuro = By.xpath("//div/span[@class=\"price actual-price\"][2]");
     public void verifyUserIsOnHomePage(){
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
        Currency.selectByValue("https://demo.nopcommerce.com/changecurrency/1?returnUrl=%2F");
        // expected result
        String expectedMessage = "$1,200.00";
        //Verify that build your own computer price is visible in "Dollars"
        String actualMessage = driver.findElement(By.xpath("//span[contains(text(),'$1,200.00')]")).getText();
        //assert point to compare actual and expected
        Assert.assertEquals(actualMessage,expectedMessage, "Price in Dollar not found");

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
        Assert.assertEquals(actualMessage,expectedMessage, "Price in Euro not found");

    }
    public void userShouldBeAllowedToVoteOnlyAfterRegistration(){
        //click on radio button good
        clickButton(By.id("pollanswers-2"));
        //click on vote
        clickButton(By.id("vote-poll-1"));
        //Total Votes Text
       // getText(By.className("poll-total-votes"));
        presenceOfElement(By.className("poll-total-votes"),10);
    }
    public void userShouldBeAbleToAddProductInWishList(){
        //Select Mobile = new Select(driver.findElement(By.xpath("//h2/a[@href=\"/htc-one-m8-android-l-50-lollipop\"]")));
       // Mobile.selectByValue("    onclick=\"return AjaxCart.addproducttocart_catalog(\"/addproducttocart/catalog/18/2/1\"),!1\"\n");
        clickButton(By.cssSelector("return AjaxCart.addproducttocart_catalog(\"/addproducttocart/catalog/18/2/1\"),!1\""));
        String expectedMessage = "The product has been added to your wishlist";
        String actualMessage = driver.findElement(By.className("bar-notification success")).getText();
        //assert point to compare actual and expected
        Assert.assertEquals(actualMessage,expectedMessage, "The product is failed tobe added in wishlist");

    }
     public void getProductTitles(){
         driver.get("https://demo.nopcommerce.com/");
         List<WebElement> productTitles = driver.findElements(By.xpath("//div[@class=\"product-grid home-page-product-grid\"]//h2"));
         System.out.println(productTitles.size());
         List<String> expectedProductTitles = Arrays.asList();//
         //List<String> act
         for(WebElement e: productTitles){
             System.out.println(e.getText());
         }



    }
//// public void verifyHomePageContents(){
//       // Assert.assertEquals(gettext(By.className("")));//Register
// public void
}