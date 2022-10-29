package visme.auth;

import org.junit.Test;
import org.openqa.selenium.support.PageFactory;
import visme.WebDriverSettings;
import visme.pages.LoginPage;


public class AuthWithoutLoginAndPassword extends WebDriverSettings {

    @Test
    public void authWithoutLoginAndPassword() {

        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.open();
        loginPage.clickLoginBtn();
        loginPage.checkEmptyFieldsError("Email required!");
    }
}
