package org.example;

import org.example.Utils;
import org.openqa.selenium.By;
import org.testng.Assert;

public class BuildYourOwnComputer extends Utils {
    public void verifyBuildYourOwnCompPage(){

       driverWaitUntilUrlTOBe(30,"https://demo.nopcommerce.com/build-your-own-computer");


        //driver.get("https://demo.nopcommerce.com/registerresult/1?returnUrl=/");

    }
    public void userShouldBeAbleToBuildYourOwnComputer() {
        //Processor 2.2 ghz
        clickButton(By.xpath("//option[@data-attr-value=\"1\"]"));
        //Ram 2 GB
        clickButton(By.xpath("//option[@value=\"3\"]"));
        //HDD 320GB
        clickButton(By.xpath("//label[@for=\"product_attribute_3_6\"]"));
        // OS Vista Premium
        clickButton(By.xpath("//label[@for=\"product_attribute_4_9\"]"));
        //Microsoft office (value was already there so commented out)
        //clickButton(By.id("product_attribute_5_10"));
        //Acrobat Reader
        clickButton(By.xpath("//input[@id=\"product_attribute_5_11\"]"));
        //Total Commander
        clickButton(By.xpath("//label[@for=\"product_attribute_5_12\"]"));
        //Add to Cart
        clickButton(By.xpath("//button[@id=\"add-to-cart-button-1\"]"));
        // confirmation Message that product been added to cart
        String expectedMessage = "The product has been added to your shopping cart";
        String actualMessage = driver.findElement(By.className("content")).getText();
        Assert.assertEquals(actualMessage, expectedMessage, "no item added in the cart");


    }
    public void clickOnEmailButton(){
    clickButton(By.className("email-a-friend"));
    }

}
