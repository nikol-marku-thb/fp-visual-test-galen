package com.thb.galen.forumportal;

import com.thb.galen.core.GalenTestBase;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;


public class ProfilePageTest extends GalenTestBase {

    @Test(dataProvider = "devices")
    public void profile_shouldLookGood_onDevice(TestDevice device) throws IOException {
        load("profile");
        WebDriverWait wait = new WebDriverWait(getDriver(), 35);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("main-content")));
        checkLayout("/specs/thb/fp-common.spec", device.getTags());
    }

    /*@Test(dataProvider = "devices")
    public void loginPage_shouldLookGood_onDevice(TestDevice device) throws IOException {
        load("/");
        getDriver().findElement(By.xpath("//button[.='Login']")).click();
        checkLayout("/specs/loginPage.spec", device.getTags());
    }*/

}
