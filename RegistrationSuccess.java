package org.example;

import org.example.Utils;
import org.openqa.selenium.By;
import org.testng.Assert;

//import org.testng.annotations.Test;


public class RegistrationSuccess extends Utils {
    public void verifyRegistrationSuccessPage() {
        driverWaitUntilUrlTOBe(10, "https://demo.nopcommerce.com/registerresult/1?returnUrl=/");

    }

    public void confirmationMessage() {

  String expectedMessage = "Your registration completed";
  String actualMessage = driver.findElement(By.className("result")).getText();
  Assert.assertEquals(actualMessage, expectedMessage, "registration failed");

    }
    public void afterRegistrationContinueButton(){
        clickButton(By.className("buttons"));
    }
}