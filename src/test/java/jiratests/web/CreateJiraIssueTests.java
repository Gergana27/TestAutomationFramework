package jiratests.web;

import com.jira.pages.CreateIssueWindow;
import jiratests.core.JiraBaseTest;
import jiratests.enums.IssueType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CreateJiraIssueTests extends JiraBaseTest {
    private CreateIssueWindow createIssueWindow;

    @BeforeEach
    public void CreateIssueWindow() {
        createIssueWindow = new CreateIssueWindow();
    }

    @Test
    public void createTaskTest() {
        //CHANGE issueType TO BE TASK OR BUG
        String issueType = IssueType.BUG.toString();

        String summary = "Implement User Login";
        String description = "As a user, I want to log in to the application using my username and password." +
                "Preconditions: The user should be logged in to JIRA with appropriate permissions to create issues.\n" +
                "The user should have access to a project in JIRA.\n" +
                "The user should be able to navigate to the \"Create Issue\" screen." +
                "Steps to Reproduce:Navigate to the project dashboard in JIRA.\n" +
                "Click on the \"Create\" button in the top menu.\n" +
                "Select the \"Issue Type\" as \"Task/Bug\" from the dropdown menu.\n" +
                "Expected Result:\n" +
                "\n" +
                "The story should be created successfully, and the user should see the story listed in the project's backlog.\n" +
                "\n" +
                "Actual Result:\n" +
                "(To be determined based on testing.)";
        String priority = "Medium";

        //create issue
        createIssueWindow.createIssue(issueType, summary, description, priority);

        //Assertions
        Assertions.assertTrue(createIssueWindow.isIssueCreate());

    }
}
