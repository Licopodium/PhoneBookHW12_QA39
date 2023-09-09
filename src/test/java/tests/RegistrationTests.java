package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationTests extends TestBase {

    @Test
    public void registrationPositiveTest() {
        app.getHelperUser().openLoginRegistrationForm();
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        app.getHelperUser().fillLoginRegistrationForm("coral_" + i + "@gmail.com", "565656Ka$");
        app.getHelperUser().submitRegistration();
        app.getHelperUser().pause(3000);
        Assert.assertTrue(app.getHelperUser().isElementPresent(By.tagName("button")));
    }

    @Test
    public void registrationNegativeTestWrongEmail() {
        app.getHelperUser().openLoginRegistrationForm();
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        app.getHelperUser().fillLoginRegistrationForm("@coral@gmail.com", "565656Ka$");
        app.getHelperUser().submitRegistration();
        app.getHelperUser().pause(3000);
        Assert.assertTrue(app.getHelperUser().isAlertPresent());
    }

    @Test
    public void registrationNegativeTestWrongPassword() {
        app.getHelperUser().openLoginRegistrationForm();
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        app.getHelperUser().fillLoginRegistrationForm("coral@gmail.com", "565656Kam");
        app.getHelperUser().submitRegistration();
        app.getHelperUser().pause(3000);
        Assert.assertTrue(app.getHelperUser().isAlertPresent());
    }
}
