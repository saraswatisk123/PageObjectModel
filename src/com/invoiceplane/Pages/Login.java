package com.invoiceplane.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Saraswati on 2/28/2018.
 */

public class Login
{

 WebDriver driver;
 @FindBy(xpath="//*[@id='email']")
 WebElement txtUserName;

//  WebElement txtUserName = driver.findElement(By.xpath(""));

    @FindBy(xpath="//*[@id='password']")
 WebElement txtpassname;

@FindBy(xpath = "//*[@id='login']/form/input")
 WebElement loginbtn;

@FindBy(xpath = "//*[@id='login']/img")
 WebElement image;


@FindBy(xpath = "//*[@id='login']/div[2]/small/a")
 WebElement linktext;

public Login (WebDriver driver)
{
  this.driver= driver;
  PageFactory.initElements(driver, this);
}

public void setTxtUserName(String username)
{
   txtUserName.sendKeys(username);
}



public void setTxtpassname(String password)
{
 txtpassname.sendKeys(password);
}

public void clickLogin()
{
  loginbtn.click();
}

}
