package com.skillup.automation.slidepresenter;

import com.skillup.automation.slidepresenter.pages.CreatePresentationPage;
import com.skillup.automation.slidepresenter.pages.HomePage;
import com.skillup.automation.slidepresenter.pages.mailinator.MailinatorEmailPage;
import com.skillup.automation.slidepresenter.pages.mailinator.MailinatorPage;
import com.skillup.automation.slidepresenter.pages.SignUpPage;
import com.skillup.automation.slidepresenter.utils.StringRandomGenerator;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SignUpTest extends TestRunner {

    private String emailWithoutDomain = StringRandomGenerator.generateString();
    private String email = emailWithoutDomain + "@mailinator.com";

    private HomePage homePage;
    private SignUpPage signUpPage;
    private CreatePresentationPage createPresentationPage;
    private MailinatorPage mailinatorPage;
    private MailinatorEmailPage mailinatorEmailPage;

    @BeforeMethod
    public void before() {
        homePage = new HomePage(driver);
        signUpPage = new SignUpPage(driver);
        createPresentationPage = new CreatePresentationPage(driver);
        mailinatorPage = new MailinatorPage(driver);
        mailinatorEmailPage = new MailinatorEmailPage(driver);
    }

    @Test
    public void verifyRegistration() {
        homePage
                .open()
                .closeWidgetIfPresent()
                .navigateToSighUpPage();

        signUpPage
                .enterEmail(email)
                .selectCheckBox()
                .signUpForFree();

        mailinatorPage
                .open()
                .enterEmail(emailWithoutDomain)
                .goToMailBox();

        mailinatorEmailPage
                .openEmail(emailWithoutDomain)
                .activateAccount()
                .switchToLastTab();

        String password = "Password1234!";

        signUpPage
                .enterFirstName("firstName")
                .enterLastName("lastName")
                .selectCompanySize("Private / Student")
                .enterPassword(password)
                .enterPasswordConfirmation(password)
                .letGo();

        createPresentationPage.assertWelcomePostVisible();
    }
}
