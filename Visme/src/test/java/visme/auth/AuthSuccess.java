package visme.auth;

import org.junit.Test;
import org.openqa.selenium.support.PageFactory;
import visme.WebDriverSettings;
import visme.pages.LoginPage;


public class AuthSuccess extends WebDriverSettings {

    @Test
    public void authSuccess() {

        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.open();
        loginPage.fillFields("vitasoftik@gmail.com", "82as76!7Pud5");
        loginPage.clickLoginBtn();
        loginPage.successAuth();
    }
}
