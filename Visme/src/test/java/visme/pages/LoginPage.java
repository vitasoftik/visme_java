package visme.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class LoginPage {

    private By errorMessage = By.cssSelector(".error-message");
    private By loginField = By.cssSelector(".login");
    private By passwordField = By.cssSelector(".password");
    private By loginBtn = By.cssSelector(".login-btn");
    private By workSpaceInfo = By.cssSelector(".workspace-info");
    private By closeOtherSessionsAndLogin = By.cssSelector(".el-dialog__body .login");

    private WebDriver driver;
    private WebDriverWait wait;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void open() {
        driver.get("https://dashboard.visme.co/v2/login");
    }

    public void clickLoginBtn() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginField));
        driver.findElement(loginBtn).click();
    }

    public void checkEmptyFieldsError(String message) {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(errorMessage));
        String error = driver.findElement(errorMessage).getText();

        Assert.assertEquals(error, message);
    }

    public void fillFields(String login, String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginField));
        driver.findElement(loginField).sendKeys(login);
        driver.findElement(passwordField).sendKeys(password);
    }

    public void successAuth() {
        Boolean multipleLoginsExist = driver.findElements(closeOtherSessionsAndLogin).isEmpty();

        if(!multipleLoginsExist) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(closeOtherSessionsAndLogin));
            driver.findElement(closeOtherSessionsAndLogin).click();
        }

        wait.until(ExpectedConditions.visibilityOfElementLocated(workSpaceInfo));
    }

}
