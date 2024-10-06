package jiratests.web;

import com.jira.pages.AtlassianHome;
import com.jira.pages.AtlassianLoginPage;
import jiratests.enums.JiraTestData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import testframework.core.BaseWebTest;

public class JiraLoginTests extends BaseWebTest {
    public static final String WELCOME_MESSAGE = "G'day, Gergana Georgieva";

    private AtlassianLoginPage loginPage;
    private AtlassianHome homePage;

    @BeforeEach
    public void setUp() {
        loginPage = new AtlassianLoginPage("/login");
        loginPage.navigate();
        homePage = new AtlassianHome();

    }

    @Test
    public void loginToJiraTest() {
        loginPage.submitLogin(JiraTestData.USERNAME.getValue(), JiraTestData.PASSWORD.getValue());
//        String welcomeText = homePage.getWelcomeMessage();
//        Assertions.assertTrue(welcomeText.contains(WELCOME_MESSAGE), "Welcome message is correct.");
    }

}
