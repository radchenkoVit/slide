package com.skillup.automation.slidepresenter.pages;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CreatePresentationPage extends CommonPage {
    private static final String INTERCOM_POST = "div.intercom-post";

    public CreatePresentationPage(WebDriver driver) {
        super(driver);
    }

    public void assertWelcomePostVisible() {
        driver.switchTo().frame("intercom-modal-frame");
        Assert.assertTrue(waitTillElementPresent(INTERCOM_POST), "Welcome Post Not Present");
        driver.switchTo().defaultContent();
    }
}
