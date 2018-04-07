package com.invoiceplane.Pages;

import com.sun.org.apache.xerces.internal.impl.xpath.XPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Saraswati on 3/4/2018.
 */

public class Menu {

    WebDriver driver;
    @FindBy(xpath =".//*[@id='ip-navbar-collapse']/ul[1]/li[2]/a/span")
    WebElement clients;

    @FindBy(linkText = "Add Client")
    WebElement addclient;

    @FindBy(xpath = ".//*[@id='ip-navbar-collapse']/ul[1]/li[2]/ul/li[2]/a")
    WebElement viewclients;

    @FindBy(xpath = "//*[@id=ip-navbar-collapse]/ul[1]/li[3]/a/span")
    WebElement quotes;

    @FindBy(linkText = "Create Quote")
    WebElement addquote;

    @FindBy(linkText = "View Quotes ")
    WebElement viewquotes;
    public Menu(WebDriver driver)
    {
        this.driver= driver;
        PageFactory.initElements(driver, this);
    }

    public void AddClient()
    {
        clients.click();
        addclient.click();
    }
    public void ViewClients()
    {
        clients.click();
        viewclients.click();
    }

}