package com.skillup.automation.slidepresenter.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static com.skillup.automation.slidepresenter.config.Wait.TWO_SECONDS;
import static com.skillup.automation.slidepresenter.config.Wait.sleep;
import static java.lang.String.format;

public class SignUpPage extends CommonPage {
    private static final String EMAIL_INPUT = "input[type='email']";
    private static final String AGREE_CHECKBOX = "form i";
    private static final String SIGNUP_FOR_FREE_BUTTON = "form button[type='submit']";

    private static final String FIRST_NAME_INPUT = "[name='firstName']";
    private static final String LAST_NAME_INPUT = "[name='lastName']";
    private static final String DROP_DOWN_BUTTON = "//form/div/div[3]";
    private static final String PASSWORD_INPUT = "[name='password']";
    private static final String PASSWORD_CONF_INPUT = "[name='passwordConfirmation']";
    private static final String LI_DROPDOWN_PATTERN = "//li[.//*[contains(text(), '%s')]]";
    private static final String LET_GO_BUTTON = "form button";

    public SignUpPage(WebDriver driver) {
        super(driver);
    }

    public SignUpPage enterEmail(String email) {
        enterText(EMAIL_INPUT, email);
        return this;
    }

    public SignUpPage selectCheckBox() {
        selectCheckBox(AGREE_CHECKBOX);
        return this;
    }

    public SignUpPage signUpForFree() {
        click(SIGNUP_FOR_FREE_BUTTON);
        return this;
    }


    public SignUpPage enterFirstName(String firstName) {
        enterText(FIRST_NAME_INPUT, firstName);
        return this;
    }

    public SignUpPage enterLastName(String lastName) {
        enterText(LAST_NAME_INPUT, lastName);
        return this;
    }

    public SignUpPage selectCompanySize(String name) {
        click(DROP_DOWN_BUTTON);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(find(format(LI_DROPDOWN_PATTERN, name))));
        click(format(LI_DROPDOWN_PATTERN, name));

        sleep(TWO_SECONDS);
        return this;
    }

    public SignUpPage enterPassword(String pass) {
        enterText(PASSWORD_INPUT, pass);
        return this;
    }

    public SignUpPage enterPasswordConfirmation(String pass) {
        enterText(PASSWORD_CONF_INPUT, pass);
        return this;
    }

    public SignUpPage letGo() {
        click(LET_GO_BUTTON);
        return this;
    }
}
