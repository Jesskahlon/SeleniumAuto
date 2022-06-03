package org.example;

import org.example.Utils;
import org.openqa.selenium.By;
import org.testng.Assert;

public class ReferTheProductToFreind extends Utils {
    private By _textBoxEmailFriendID = By.className("friend-email");
    private By _textBoxPersonalMessage = By.id("PersonalMessage");
    private By _ButtonSendEmail = By.xpath("//div/button[@type=\"submit\"]");
    private By _messageSentToFriend = By.className("result");
    private By _ButtonRegister = By.className("ico-register");

    public void verifyProductEmailFriendPage() {
        driverWaitUntilUrlTOBe(30, "https://demo.nopcommerce.com/productemailafriend/1");
    }
    public void userShouldBeAbleToReferTheProductToFriend() {

        // Friend Email Address Text Box
        typeText(_textBoxEmailFriendID, "dilruba@gmail.com");
         //Personal Message Text Box
        typeText(_textBoxPersonalMessage, "Buy your new PC from nopCommerce only");
        // Send Email Button
        clickButton(_ButtonSendEmail);
        String expectedMessage = "Your message has been sent.";
        //Confirmation Message of Email Sent
        String actualMessage = driver.findElement(_messageSentToFriend).getText();
        Assert.assertEquals(actualMessage, expectedMessage, "email is failed");

    }
    public void registerButton(){
        //Register Button
        clickButton(_ButtonRegister);

    }
}