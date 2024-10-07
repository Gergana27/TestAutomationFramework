package jiratests.core;

import com.jira.pages.AtlassianHome;
import com.jira.pages.AtlassianLoginPage;
import com.jira.pages.JiraNavigationMenu;
import jiratests.enums.JiraTestData;
import org.junit.jupiter.api.BeforeEach;
import testframework.PropertiesManager;
import testframework.core.BaseWebTest;


public class JiraBaseTest extends BaseWebTest {
    protected AtlassianLoginPage loginPage;
    protected AtlassianHome atlassianHome;
    protected JiraNavigationMenu jiraNavigationMenu;

    @BeforeEach
    public void setUp() {
        loginPage = new AtlassianLoginPage("/login");
        loginPage.navigate();
        atlassianHome = new AtlassianHome();
        jiraNavigationMenu = new JiraNavigationMenu();

        //Navigate to base page
        driver().get(PropertiesManager.getConfigProperties().getProperty("atlassianBaseUrl"));

        //Login to Atlassian
        loginPage.submitLogin(JiraTestData.USERNAME.getValue(), JiraTestData.PASSWORD.getValue());

        //Go to Jira
        atlassianHome.navigateToProjectApp();

        //Click on 'create' button
        jiraNavigationMenu.clickOnCreateButtonTCreateIssue();
    }
}
