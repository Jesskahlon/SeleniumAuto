package org.example;

import org.example.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPage extends Utils {
    private By _radioButtonFemale = By.className("female");
    private By _textBoxFirstName = By.xpath("//input[@name='FirstName']");
    private By _textBoxLastName = By.xpath("//input[@name='LastName']");
    private By _selectDropDownButtonBirthDay = By.name("DateOfBirthDay");
    private By _selectDropDownButtonBirthMonth = By.name("DateOfBirthMonth");
    private By _selectDropDownButtonBirthYear = By.name("DateOfBirthYear");
    private By _textBoxEmail = By.id("Email");
    private By _textBoxPassword = By.name("Password");
    private By _textConfirmPassword = By.id("ConfirmPassword");
    private By _registerButton = By.name("register-button");

    public void verifyUserIsOnRegisterPage() {
        driverWaitUntilUrlTOBe(30, "https://demo.nopcommerce.com/register?returnUrl=%2F");
    }
        public void userShouldBeAbleToRegisterSuccessfully(){

            clickButton(_radioButtonFemale);
            typeText(_textBoxFirstName, "Hello");
            typeText(_textBoxLastName, "Hi");
            Select birthday = new Select(driver.findElement(_selectDropDownButtonBirthDay));
            birthday.selectByVisibleText("5");
            Select birthMonth = new Select(driver.findElement(_selectDropDownButtonBirthMonth));
            birthMonth.selectByVisibleText("June");
            Select birthYear = new Select(driver.findElement(_selectDropDownButtonBirthYear));
            birthYear.selectByValue("1983");
            typeText(_textBoxEmail, "jk5983" + randomDate() + "@gmail.com");
            typeText(_textBoxPassword, "hi44@44");
            typeText(_textConfirmPassword, "hi44@44");
            clickButton(_registerButton);


        }

    }
