package com.invoiceplane.Pages.Clients;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Saraswati on 2/28/2018.
 */
public class ViewClients
{
    WebDriver driver;
    @FindBy(xpath ="//tr[td//a[text()='Alex']]//*/i[@class='fa fa-eye fa-margin']")
    WebElement view;
    public void setView()
    {
        view.click();
    }
    public ViewClients(WebDriver driver)
    {
        this.driver= driver;
        PageFactory.initElements(driver, this);
    }

}
