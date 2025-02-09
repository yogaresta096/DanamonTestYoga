package stepsdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.danamon.pageobject.LoginPage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import utils.ConfigLoader;
import utils.ExcelUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;


public class LoginSteps {
    private static final Logger logger = LoggerFactory.getLogger(LoginSteps.class);
    private AppiumDriver<MobileElement> driver;
    private LoginPage loginPage;
    private ConfigLoader configLoader;
    private ExcelUtils excelUtils;

    public LoginSteps(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
        this.loginPage = new LoginPage(driver);
        this.configLoader = new ConfigLoader("android", "development");
        this.excelUtils = new ExcelUtils("resources/testdata/TestDataLogin.xlsx");
    }

    @Given("the user is on the login screen")
    public void userOnLoginScreen() {
        driver.get(configLoader.getProperty("serverURL") + "login");
        logger.info("User navigated to the login screen.");
    }

    @When("the user enters valid credentials")
    public void userEntersValidCredentials() {
        String username = excelUtils.getValue(0, 1); // Column 0, Row 1 for valid username
        String password = excelUtils.getValue(1, 1); // Column 1, Row 1 for valid password
        loginPage.login(username, password); // Use the new login method
        logger.info("User entered valid credentials.");
        assertTrue("Login should be successful", loginPage.isLoginSuccessful());
        assertEquals("Expected result should be success", "Success login", "Success login");
    }


    @When("the user enters an invalid username")
    public void userEntersInvalidUsername() {
        String username = excelUtils.getValue(0, 2); // Column 0, Row 2 for invalid username
        String password = excelUtils.getValue(1, 1); // Column 1, Row 1 for valid password
        loginPage.login(username, password); // Use the new login method
        logger.info("User entered an invalid username.");
        assertTrue("Error message should be displayed", loginPage.isLoginFailed());
        assertEquals("Expected result should be failed login", "Failed Login", "Failed Login");
    }


    @When("the user enters an invalid password")
    public void userEntersInvalidPassword() {
        String username = excelUtils.getValue(0, 1); // Column 0, Row 1 for valid username
        String password = excelUtils.getValue(1, 2); // Column 1, Row 2 for invalid password
        loginPage.login(username, password); // Use the new login method
        logger.info("User entered an invalid password.");
        assertTrue("Error message should be displayed", loginPage.isLoginFailed());
        assertEquals("Expected result should be failed login", "Failed Login", "Failed Login");
    }


    @Then("the user should be logged in successfully")
    public void userLoggedInSuccessfully() {
        assertTrue("Login should be successful", loginPage.isLoginSuccessful());
        logger.info("User logged in successfully.");
    }

    @Then("an error message should be displayed")
    public void errorMessageDisplayed() {
        assertTrue("Error message should be displayed", loginPage.isLoginFailed());
        String errorMessage = loginPage.getErrorMessage();
        logger.info("Error message displayed: " + errorMessage);
    }
}
