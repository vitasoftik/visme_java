package visme.auth;

import org.junit.Test;
import org.openqa.selenium.support.PageFactory;
import visme.WebDriverSettings;
import visme.pages.LoginPage;


public class AuthWithoutLogin extends WebDriverSettings {

    @Test
    public void authWithoutLogin() {

        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.open();
        loginPage.fillFields("", "82as76!7Pud5");
        loginPage.clickLoginBtn();
        loginPage.checkEmptyFieldsError("Email required!");
    }
}
