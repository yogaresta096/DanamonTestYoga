package org.danamon.pageobject;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    @AndroidFindBy(id = "username_field_id")
    private MobileElement usernameField;

    @AndroidFindBy(id = "password_field_id")
    private MobileElement passwordField;

    @AndroidFindBy(id = "login_button_id")
    private MobileElement loginButton;

    @AndroidFindBy(id = "error_message_id")
    private MobileElement errorMessage;

    @AndroidFindBy(id = "welcome_message_id")
    private MobileElement welcomeMessage;

    public LoginPage(AppiumDriver<MobileElement> driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void login(String username, String password) {
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();
    }

    public boolean isLoginSuccessful() {
        return welcomeMessage.isDisplayed(); 
    }

    public boolean isLoginFailed() {
        return errorMessage.isDisplayed(); 
    }

    public String getErrorMessage() {
        return errorMessage.getText();
    }
}
