package com.skillup.automation.slidepresenter.pages.mailinator;

import com.skillup.automation.slidepresenter.config.Wait;
import com.skillup.automation.slidepresenter.pages.CommonPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static com.skillup.automation.slidepresenter.config.Wait.sleep;
import static java.lang.String.format;

public class MailinatorEmailPage extends CommonPage {
    private static final String ROW_PATTERN = "tr[id*='%s']";
    private static final String ACTIVATE_ACCOUNT_LINK = "//p[(.//a)][1]";

    public MailinatorEmailPage(WebDriver driver) {
        super(driver);
    }


    public MailinatorEmailPage openEmail(String email) {
        driver.navigate().refresh();
        sleep(Wait.ONE_SECOND);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(find(format(ROW_PATTERN, email))));
        List<WebElement> rows = driver.findElements(find(format(ROW_PATTERN, email)));
        rows.get(0).click();

        return this;
    }

    public MailinatorEmailPage activateAccount() {
        driver.switchTo().frame("msg_body");
        driver.findElement(find(ACTIVATE_ACCOUNT_LINK)).click();
        driver.switchTo().defaultContent();
        return this;
    }
}
