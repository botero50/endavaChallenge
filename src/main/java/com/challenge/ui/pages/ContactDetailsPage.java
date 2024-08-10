package com.challenge.ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactDetailsPage {
	
    private WebDriver driver;
    public ContactDetailsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "edit-contact")
    private WebElement editContactButton;
    
    @FindBy(id = "delete")
    private WebElement deleteContactButton;

    @FindBy(id = "return")
    private WebElement returnToContactListButton;

    public void clickDeleteContactButton() {
        deleteContactButton.click();
    }

    public void clickEditContactButton() {
        editContactButton.click();
    }

    public void clickReturnToContactListButton() {
        returnToContactListButton.click();
    }

    public void acceptDeletePopup() {
        driver.switchTo().alert().accept();
    }	
}