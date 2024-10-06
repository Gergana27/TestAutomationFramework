package com.jira.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static testframework.core.BaseWebTest.driver;

public class ProjectsPage {
    //Locators
    private final By projectLocator = By.
            xpath("//tr[td/div/a/span[text()='Test Automation Framework Homework']]");

    //Actions
    public void navigateToProject() {
        WebElement projectElement = driver().findElement(projectLocator);
        projectElement.click();
    }
}
