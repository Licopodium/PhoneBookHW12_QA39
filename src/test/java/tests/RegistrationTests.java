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
//
//    @Test
//    public void registrationPositiveTest(){
//        // open login form
//        wd.findElement(By.xpath("//*[.='LOGIN']")).click();
//        // fill login form
//        int i = (int)(System.currentTimeMillis()/1000)%3600;
//
//        WebElement emailInput = wd.findElement(By.xpath("//input[1]"));
//        emailInput.click();
//        emailInput.clear();
//        emailInput.sendKeys("abc_" + i + "@def.com");
//
//        WebElement passInput = wd.findElement(By.xpath("//input[2]"));
//        passInput.click();
//        passInput.clear();
//        passInput.sendKeys("$Abcdef12345");
//
//        // click on button registration
//        wd.findElement(By.xpath("//button[2]")).click();
//        // assert
//        pause(3000);
//        Assert.assertTrue(wd.findElements(By.tagName("button")).size() > 0);
//    }
//    @Test
//    public void registrationNegativeTestWrongEmail(){
//        // open login form
//        wd.findElement(By.xpath("//*[.='LOGIN']")).click();
//        // fill login form
//        int i = (int)(System.currentTimeMillis()/1000)%3600;
//
//        WebElement emailInput = wd.findElement(By.xpath("//input[1]"));
//        emailInput.click();
//        emailInput.clear();
//        emailInput.sendKeys("coral_" + i + "@gmail.com");
//
//        WebElement passInput = wd.findElement(By.xpath("//input[2]"));
//        passInput.click();
//        passInput.clear();
//        passInput.sendKeys("565656Ca$");
//
//        // click on button registration
//        wd.findElement(By.xpath("//button[2]")).click();
//        // assert
//        pause(3000);
//        Assert.assertTrue(isAlertPresent());
//
//    }

