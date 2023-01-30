package qa.guru.allure;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LabelsTest {

    @Test
    @Feature("Issue in the repo")
    @Story("Create issue")
    @Owner("avolosovich")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "GitHub", url = "https://github.com")
    @DisplayName("Create Issue for authorized user")
    public void testStaticLabels() {
    }

    @Test
    public void testAnnotatedStep() {
        Allure.getLifecycle().updateTestCase(
            t -> t.setName("Create Issue for authorized user"));
        Allure.feature("Issue in the repo");
        Allure.story("Create issue");
        Allure.label("owner", "avolosovich");
        Allure.label("severity", SeverityLevel.BLOCKER.value());
        Allure.link("GitHub", "https://github.com");
    }
}
