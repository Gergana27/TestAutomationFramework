package com.jira.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import static testframework.core.BaseWebTest.driver;

public class CreateIssueWindow {
    //Locators
//    private final By issueTypeLocator = By.cssSelector("[data-testid='issue-field-select-base.ui.format-option-label.c-label']");
//    private final By projectNameFieldLocator = By.id("issue-create.ui.modal.create-form.project-picker.project-select");
//    private final By linkedIssueDropdownLocator = By.cssSelector("div.issue-link-type__control");
//    private final By summaryFieldLocator = By.xpath("//input[@data-testid='issue-create-commons.common.ui.fields.base-fields.input-field.textfield']");
//    private final By descriptionFieldLocator = By.
//            xpath("//div[@aria-label='Description area, start typing to enter text.']");
//    private final By priorityFieldLocator = By.
//            cssSelector("[data-testid='issue-field-select-base.ui.format-option-label.c-label']");
//    private final By assigneeLocator = By.cssSelector(".fabric-user-picker__single-value .css-1dq1lfl .css-4fhoaq");
//    private final By createButtonLocator = By.
//            cssSelector("[data-testid='issue-create.common.ui.footer.create-button']");

    private final By issueTypeLocator = By.id("issue-create.ui.modal.create-form.type-picker.issue-type-select");
    private final By projectNameFieldLocator = By.cssSelector("[id*='project-picker']");
    private final By summaryFieldLocator = By.id("summary-field"); // Променено от предишното XPath
    private final By descriptionFieldLocator = By.xpath("//div[@aria-label='Description area, start typing to enter text.']");
    private final By priorityFieldLocator = By.cssSelector("[data-testid='issue-field-select-base.ui.format-option-label.c-label']");
    private final By assigneeLocator = By.cssSelector(".fabric-user-picker__single-value .css-1dq1lfl .css-4fhoaq");
    private final By createButtonLocator = By.cssSelector("[data-testid='issue-create.common.ui.footer.create-button']");


    //Actions
    //isProjectNameVisible
    public boolean isProjectNameVisible() {
        try {
            WebElement projectNameField = driver().findElement(projectNameFieldLocator);
            return projectNameField.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void navigateToPriorityField() {
        List<WebElement> priorityField = driver().findElements(priorityFieldLocator);
        if (priorityField.size() >= 3) {
            WebElement priorityThirdElement = priorityField.get(2);
            priorityThirdElement.click();
        } else {
            System.out.println("Not enough elements.");
        }
    }

    public void selectIssueTyped() {
        List<WebElement> issueElements = driver().findElements(issueTypeLocator);
        if (issueElements.size() >= 3) {
            WebElement selectedIssue = issueElements.get(1);
            selectedIssue.click();
        } else {
            System.out.println("Not enough elements.");
        }
    }

    //CreateIssue
    public void createIssue(String summary, String description, String assigneeName) {
//        WebElement summaryField = driver().findElement(summaryFieldLocator);
//        summaryField.sendKeys(summary);
//
//
//        WebElement descriptionField = driver().findElement(descriptionFieldLocator);
//        descriptionField.sendKeys(description);
//
//        selectIssueTyped();
//        navigateToPriorityField();
//
//        WebElement assigneeField = driver().findElement(assigneeLocator);
//        assigneeField.click();
//
//        List<WebElement> assigneeOptions = driver().findElements(By.xpath("//div[@class='css-4fhoaq']"));
//
//        for (WebElement option : assigneeOptions) {
//            if (option.getText().equalsIgnoreCase(assigneeName)) {
//                option.click();
//                break;
//            }
//        }
//        WebElement createButton = driver().findElement(createButtonLocator);
//        createButton.click();
//    }
//
//    public boolean isIssueCreated(String issueSummary) {
//        try {
//            WebElement issue = driver().findElement(By.xpath("//span[contains(text(),'" + issueSummary + "')]"));
//            return issue.isDisplayed();
//        } catch (NoSuchElementException e) {
//            return false;
//        }
//    }

//    public WebElement waitForElementToBeVisible(By locator) {
//        WebDriverWait wait = new WebDriverWait(driver(), Duration.ofSeconds(10));
//        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
//    }
//
//    public void printAllElements() {
//        System.out.println("Waiting for issue type to be visible...");
//        WebElement issueTypeElement = waitForElementToBeVisible(By.cssSelector("cssSelectorForIssueType"));
//        System.out.println("Issue Type HTML: " + issueTypeElement.getAttribute("outerHTML"));
//
//        System.out.println("Waiting for summary field to be visible...");
//        WebElement summaryFieldElement = waitForElementToBeVisible(By.cssSelector("cssSelectorForSummaryField"));
//        System.out.println("Summary Field HTML: " + summaryFieldElement.getAttribute("outerHTML"));
//
//        System.out.println("Waiting for description field to be visible...");
//        WebElement descriptionFieldElement = waitForElementToBeVisible(By.xpath("xpathForDescriptionField"));
//        System.out.println("Description Field HTML: " + descriptionFieldElement.getAttribute("outerHTML"));
//
//        System.out.println("Waiting for priority field to be visible...");
//        WebElement priorityFieldElement = waitForElementToBeVisible(By.cssSelector("cssSelectorForPriorityField"));
//        System.out.println("Priority Field HTML: " + priorityFieldElement.getAttribute("outerHTML"));
//
//        System.out.println("Waiting for create button to be visible...");
//        WebElement createButtonElement = waitForElementToBeVisible(By.cssSelector("cssSelectorForCreateButton"));
//        System.out.println("Create Button HTML: " + createButtonElement.getAttribute("outerHTML"));
//    }
         // Изчакване на елемента за „Project Name“
            WebElement projectNameField = new WebDriverWait(driver(), Duration.ofSeconds(20))
                    .until(ExpectedConditions.presenceOfElementLocated(projectNameFieldLocator));
            projectNameField.click(); // Ако е необходимо

            // Пауза за дебъгване
            try {
                Thread.sleep(5000); // Пауза за 5 секунди
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // Изчакване на „Issue Type“ и избор на тип на задачата
            WebElement issueTypeField = new WebDriverWait(driver(), Duration.ofSeconds(10))
                    .until(ExpectedConditions.elementToBeClickable(issueTypeLocator));
            issueTypeField.click();
            // TODO: Добави код за избор на стойност от падащото меню

            // Изчакване на полето „Summary“ и попълване
            WebElement summaryField = new WebDriverWait(driver(), Duration.ofSeconds(10))
                    .until(ExpectedConditions.visibilityOfElementLocated(summaryFieldLocator));
            summaryField.sendKeys(summary);

            // Попълване на „Description“
            WebElement descriptionField = new WebDriverWait(driver(), Duration.ofSeconds(10))
                    .until(ExpectedConditions.visibilityOfElementLocated(descriptionFieldLocator));
            descriptionField.sendKeys(description);

            // Навигиране към „Priority“ поле
            navigateToPriorityField();

            // Избор на „Assignee“
            WebElement assigneeField = new WebDriverWait(driver(), Duration.ofSeconds(10))
                    .until(ExpectedConditions.elementToBeClickable(assigneeLocator));
            assigneeField.click();

            // Избор от списъка с „Assignee“
            List<WebElement> assigneeOptions = driver().findElements(By.xpath("//div[@class='css-4fhoaq']"));
            for (WebElement option : assigneeOptions) {
                if (option.getText().equalsIgnoreCase(assigneeName)) {
                    option.click();
                    break;
                }
            }

            // Натискане на бутона „Create“
            WebElement createButton = new WebDriverWait(driver(), Duration.ofSeconds(10))
                    .until(ExpectedConditions.elementToBeClickable(createButtonLocator));
            createButton.click();
        }
    }

