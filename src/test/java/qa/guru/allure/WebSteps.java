package qa.guru.allure;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import qa.guru.allure.helpers.Attach;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class WebSteps {
    @Step("Open main page")
    public void openMainPage() {
        open("https://github.com");
        Attach.pageSource();
        Attach.screenshotAs("openPage");
    }

    @Step("Search for repository {repo}")
    public void searchForRepository(String repo) {
        $(".header-search-input").click();
        $(".header-search-input").sendKeys(repo);
        $(".header-search-input").submit();
        Attach.pageSource();
        Attach.screenshotAs("searchForRepo");
    }

    @Step("Click on repository {repo} link")
    public void clickOnRepositoryLink (String repo) {
        $(linkText(repo)).click();
        Attach.pageSource();
        Attach.screenshotAs("clickOnRepo");
    }

    @Step("Open the issues tab")
    public void openIssuesTab() {
        $("#issues-tab").click();
        Attach.pageSource();
        Attach.screenshotAs("openIssues");
    }

    @Step("The issue with #{issue} should exists")
    public void issueWithNumberShouldExist(int issue) {
        $(withText("#" + issue)).should(Condition.exist);
        Attach.pageSource();
        Attach.screenshotAs("issueShouldBePresent");
    }
}
