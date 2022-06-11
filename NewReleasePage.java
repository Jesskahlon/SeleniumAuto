package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class NewReleasePage extends Utils{
     private By _textBoxTitle = By.id("AddNewComment_CommentTitle");
     private By _textBoxComment = By.id("AddNewComment_CommentText");

    public void verifyUserIsOnNopCommerceNewReleasePage(){
        driverWaitUntilUrlTOBe(30,"https://demo.nopcommerce.com/nopcommerce-new-release");
    }

public void nopCommerceNewRelease() throws InterruptedException {
    String expectedMessage = "nopCommerce new release!";
    String actualMessage = driver.findElement(By.className("page-title")).getText();
    Assert.assertEquals(actualMessage, expectedMessage, "Message is Wrong");

    typeText(_textBoxTitle,"TitleBoxText");
    typeText(_textBoxComment,"CommentBoxText");
    clickButton(By.name("add-comment"));
    //

    String ActualMessage = driver.findElement(By.className("result")).getText();
    Assert.assertEquals(actualMessage, expectedMessage, "Failed to add New Comment");


    Thread.sleep(3000);

}
public void commentList() throws InterruptedException {
    ArrayList<String> comment = new ArrayList<String>();
    driver.findElement(By.className("comment-list"));
    String searchElement = "Jas";
        Thread.sleep(3000);

}
}
//    List<WebElement> comment = (List<WebElement>) driver.findElement(By.className("comment-list"));
//    if (comment.size()>0){
//            System.out.println("Comment,'Jas' is Present");
//
//            }else{
//            System.out.println("No Such comment found");
//            }
