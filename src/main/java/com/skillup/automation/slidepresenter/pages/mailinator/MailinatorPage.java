package com.skillup.automation.slidepresenter.pages.mailinator;

import com.skillup.automation.slidepresenter.pages.CommonPage;
import org.openqa.selenium.WebDriver;

import static com.skillup.automation.slidepresenter.config.Urls.MAILINATOR_PAGE;

public class MailinatorPage extends CommonPage {
    private static final String EMAIL_INPUT = "#inboxfield";
    private static final String GO_BUTTON = "//button[contains(text(),'Go!')]";

    public MailinatorPage(WebDriver driver) {
        super(driver);
    }

    public MailinatorPage open() {
        driver.get(MAILINATOR_PAGE);
        return this;
    }

    public MailinatorPage enterEmail(String email) {
        enterText(EMAIL_INPUT, email);
        return this;
    }

    public void goToMailBox() {
        findFirstVisible(GO_BUTTON).click();
    }
}
