package visme.auth;

import org.junit.Test;
import org.openqa.selenium.support.PageFactory;
import visme.WebDriverSettings;
import visme.pages.LoginPage;


public class AuthWithoutPassword extends WebDriverSettings {

    @Test
    public void authWithoutPassword() {

        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.open();
        loginPage.fillFields("vitasoftik@gmail.com", "");
        loginPage.clickLoginBtn();
        loginPage.checkEmptyFieldsError("Password required!");
    }
}
