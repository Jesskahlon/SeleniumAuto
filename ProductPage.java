package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Arrays;
import java.util.List;

public class ProductPage extends Utils {
    private By _ProductTitleList = By.xpath("//div[@class=\"product-grid\"]//h2");
    LoadProp loadProp = new LoadProp();

    public void verifyUserOnProductPage() {
        driverWaitUntilUrlTOBe(30, loadProp.getProperty("ProductURL"));
    }
    public void printingProductList(){
        //Nike Product List
        List<WebElement> productTitles = driver.findElements(_ProductTitleList);
        System.out.println(productTitles.size());
        List<String> expectedProductTitles = Arrays.asList();//
        //List<String> act
        for (WebElement e : productTitles) {
            System.out.println(e.getText());

        }
    }
}