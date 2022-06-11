package org.example;

import org.example.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPage extends Utils {
    private By _radioButtonFemale = By.className("female");
    private By _textBoxFirstName =  By.id("FirstName");
    private By _textBoxLastName = By.xpath("//input[@name='LastName']");
    private By _selectDropDownButtonBirthDay = By.name("DateOfBirthDay");
    private By _selectDropDownButtonBirthMonth = By.name("DateOfBirthMonth");
    private By _selectDropDownButtonBirthYear = By.name("DateOfBirthYear");
    private By _textBoxEmail = By.id("Email");
    private By _textBoxPassword = By.name("Password");
    private By _textConfirmPassword = By.id("ConfirmPassword");
    private By _registerButton = By.name("register-button");
    LoadProp loadprop = new LoadProp();
    public void verifyUserIsOnRegisterPage() {
        driverWaitUntilUrlTOBe(30, "https://demo.nopcommerce.com/register?returnUrl=%2F");
    }
        public void userShouldBeAbleToRegisterSuccessfully(){
            clickButton(_radioButtonFemale);
            typeText(_textBoxFirstName, loadprop.getProperty("FirstName"));
            typeText(_textBoxLastName, loadprop.getProperty("LastName"));
            Select birthday = new Select(driver.findElement(_selectDropDownButtonBirthDay));
            birthday.selectByVisibleText(loadprop.getProperty("BirthDate"));
            Select birthMonth = new Select(driver.findElement(_selectDropDownButtonBirthMonth));
            birthMonth.selectByVisibleText(loadprop.getProperty("BirthMonth"));
            Select birthYear = new Select(driver.findElement(_selectDropDownButtonBirthYear));
            birthYear.selectByValue(loadprop.getProperty("BirthYear"));
            typeText(_textBoxEmail, loadprop.getProperty("EmailPart1") + randomDate() + loadprop.getProperty("EmailPart"));
            typeText(_textBoxPassword, loadprop.getProperty("EmailPassword"));
            typeText(_textConfirmPassword, loadprop.getProperty("EmailPassword"));
            clickButton(_registerButton);


        }

    }
