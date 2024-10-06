package com.jira.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static testframework.core.BaseWebTest.driver;

public class AtlassianHome {
    //Locators
    private final By welcomeMessage = By.xpath("//div[@class='css-1ljhloz']//h1[@class='css-xtidjr']");
    private final By projectAppLocator = By.cssSelector("div.css-17oiokn");


    //Action
    public String getWelcomeMessage() {
//        driverWait().until(ExpectedConditions.visibilityOfElementLocated(welcomeMessage));
        WebElement welcomeElement = driver().findElement(welcomeMessage);
        return welcomeElement.getText();
    }

    public void navigateToProjectApp() {
        List<WebElement> projectAppElements = driver().findElements(projectAppLocator);

        if (!projectAppElements.isEmpty()) {
            WebElement appElement = projectAppElements.get(0);
//            driverWait().until(ExpectedConditions.visibilityOf(appElement));
            appElement.click();
        } else {
            System.out.println("No elements were found with the locator projectAppLocator.");
        }
    }
}

