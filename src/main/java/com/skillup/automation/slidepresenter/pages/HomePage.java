package com.skillup.automation.slidepresenter.pages;

import org.openqa.selenium.WebDriver;

import static com.skillup.automation.slidepresenter.config.Urls.HOME_PAGE;

public class HomePage extends CommonPage {
    private static final String SIGN_UP_BUTTON = "a.btn-signup";
    private static final String CLOSE_WIDGET_BUTTON = "#collect-chat-widget-close";

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage open() {
        return open(HOME_PAGE);
    }

    public HomePage open(String url) {
        driver.get(url);
        return this;
    }

    public HomePage closeWidgetIfPresent() {
        if (isElementPresent(CLOSE_WIDGET_BUTTON)) {
            driver.findElement(find(CLOSE_WIDGET_BUTTON)).click();
        }
        return this;
    }

    public void navigateToSighUpPage() {
        click(SIGN_UP_BUTTON);
    }
}
