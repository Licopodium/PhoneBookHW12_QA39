package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{


    @Test
        public void loginPositiveTest() {
            app.getHelperUser().openLoginRegistrationForm();
            app.getHelperUser().fillLoginRegistrationForm("coral@gmail.com", "565656Ca$");
            app.getHelperUser().submitLogin();
            app.getHelperUser().pause(3000);
            Assert.assertTrue(app.getHelperUser().isElementPresent(By.tagName("button")));
        }

        @Test
        public void loginNegativeTestWrongEmail() {
            app.getHelperUser().openLoginRegistrationForm();
            app.getHelperUser().fillLoginRegistrationForm("cor@al@gmail.com", "565656Ca$");
            app.getHelperUser().submitLogin();
            app.getHelperUser().pause(3000);
            Assert.assertTrue(app.getHelperUser().isAlertPresent());
        }

        @Test
        public void loginNegativeTestWrongPassword() {
            app.getHelperUser().openLoginRegistrationForm();
            app.getHelperUser().fillLoginRegistrationForm("cor@al@gmail.com", "565656Ca456");
            app.getHelperUser().submitLogin();
            app.getHelperUser().pause(3000);
            Assert.assertTrue(app.getHelperUser().isAlertPresent());
        }
    }






