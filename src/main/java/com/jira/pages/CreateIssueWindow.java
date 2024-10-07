package com.jira.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class CreateIssueWindow extends BaseJiraPage {
    //Locators
    private final By issueTypeLocator = By.cssSelector("input[id*='type-picker-uid']");
    private final By summaryFieldLocator = By.id("summary-field"); // Променено от предишното XPath
    private final By descriptionFieldLocator = By.xpath("//div[@id='ak-editor-textarea']");
    private final By priorityFieldLocator = By.id("priority-field");
    private final By assignToMeButton = By.cssSelector("button[data-testid*='assignee']");
    private final By createButtonLocator = By.cssSelector("button[data-testid*='create-button']");
    private final By creationConfirmation = By.className("css-14lcwon");

    public CreateIssueWindow() {
        super("/");
    }

    //CreateIssue
    public void createIssue(String issueType, String summary,String description, String priority) {
        driverWait().until(ExpectedConditions.visibilityOfElementLocated(createButtonLocator));
        driver().findElement(createButtonLocator).click();

        driverWait().until(ExpectedConditions.visibilityOfElementLocated(issueTypeLocator));
        driver().findElement(issueTypeLocator).sendKeys(issueType);

        driverWait().until(ExpectedConditions.visibilityOfElementLocated(summaryFieldLocator));
        driver().findElement(summaryFieldLocator).sendKeys(summary);

        driverWait().until(ExpectedConditions.visibilityOfElementLocated(descriptionFieldLocator));
        driver().findElement(descriptionFieldLocator).sendKeys(description);
        driverWait().until(ExpectedConditions.visibilityOfElementLocated(priorityFieldLocator));
        driver().findElement(priorityFieldLocator).sendKeys(priority, Keys.ENTER);

        driverWait().until(ExpectedConditions.visibilityOfElementLocated(priorityFieldLocator));
        driver().findElement(assignToMeButton).click();
        driver().findElement(createButtonLocator).click();
    }

    public boolean isIssueCreate() {
        driverWait().until(ExpectedConditions.visibilityOfElementLocated(creationConfirmation));
        return driver().findElement(creationConfirmation).getText().contains("created");
    }
}

