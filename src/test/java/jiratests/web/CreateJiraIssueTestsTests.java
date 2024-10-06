package jiratests.web;

import com.jira.pages.AtlassianLoginPage;
import com.jira.pages.CreateIssueWindow;
import jiratests.enums.IssueType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CreateJiraIssueTestsTests extends JiraLoginTests {
    private CreateIssueWindow createIssueWindow;
    private AtlassianLoginPage loginPage;


    @BeforeEach
    public void setUp() {
        createIssueWindow = new CreateIssueWindow();
    }

    @Test
    public void createStoryTest() {
        String issueType = IssueType.STORY.toString();
        String summary = "Test Story: Implement User Login";
        String description = "As a user, I want to log in to the application using my username and password." +
                "Preconditions: The user should be logged in to JIRA with appropriate permissions to create issues.\n" +
                "The user should have access to a project in JIRA.\n" +
                "The user should be able to navigate to the \"Create Issue\" screen." +
                "Steps to Reproduce:Navigate to the project dashboard in JIRA.\n" +
                "Click on the \"Create\" button in the top menu.\n" +
                "Select the \"Issue Type\" as \"Story\" from the dropdown menu." +
                "Expected Result:\n" +
                "The story should be created successfully, and the user should see the story listed in the project's backlog.\n" +
                "\n" +
                "Actual Result:\n" +
                "(To be determined based on testing.)";
        String priority = "Medium";
        String assignee = "Gergana Georgieva";

        createIssueWindow.createIssue(summary,description,assignee);
//        createIssueWindow.isIssueCreated(summary);
        createIssueWindow.isProjectNameVisible();
    }
}
