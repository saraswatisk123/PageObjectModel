package com.invoiceplane.Pages.Clients;

import com.sun.deploy.util.SessionState;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Saraswati on 3/10/2018.
 */
public class AddClient
{
    WebDriver driver;

    @FindBy(xpath="//input[@id='client_active']")
    WebElement ClientActive;
    @FindBy(xpath="//input[@id='client_name']")
    WebElement ClientName;
    @FindBy(xpath="//input[@id='client_address_1']")
    WebElement ClientAddress1;
    @FindBy(xpath="//input[@id='client_address_2']")
    WebElement ClientAddress2;
    @FindBy(xpath="//input[@id='client_city']")
    WebElement ClientCity;
    @FindBy(xpath="//input[@id='client_state']")
    WebElement ClientState;
    @FindBy(xpath="//input[@id='client_zip']")
    WebElement ClientZip;
    @FindBy(xpath="//input[@id='client_phone']")
    WebElement clientPhone;
    @FindBy(xpath="//input[@id='client_fax']")
    WebElement ClienFax;
    @FindBy(xpath="//input[@id='client_mobile']")
    WebElement ClientMobile;
    @FindBy(xpath="//input[@id='client_email']")
    WebElement clientEmail;
    @FindBy(xpath="//input[@id='client_web']")
    WebElement ClientWeb;
    @FindBy(xpath="//input[@id='client_vat_id']")
    WebElement ClientVatId;
    @FindBy(xpath="//input[@id='client_tax_code']")
    WebElement ClientTaxCode;
    @FindBy(xpath="//input[@class='select2-search__field']")
    WebElement ClientCountry;
    @FindBy(xpath="//span[@id='select2-client_country-container']")
    WebElement CountrySearch;
    @FindBy(xpath="//*[@id='btn-submit']")
    WebElement Save;
    @FindBy(xpath="//*[@id='btn-cancel']")
    WebElement Cancel;

    public AddClient(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    public void setClientActive()
    {
        ClientActive.click();
    }

    public void setClientName(String Name)
    {
        ClientName.sendKeys(Name);
    }

    public void setClientAddress1(String address1)
    {
        ClientAddress1.sendKeys(address1);
    }
    public void setClientAddress2(String address2)
    {
        ClientAddress2.sendKeys(address2);
    }
    public void setClientCity(String city)
    {
        ClientCity.sendKeys(city);
    }
    public void setClientState(String State)
    {
        ClientState.sendKeys(State);
    }
    public void setClientZip(String zip)
    {
        ClientZip.sendKeys(zip);
    }
    public void setClientPhone(String phone)
    {
        clientPhone.sendKeys(phone);
    }
    public void setClienFax(String fax)
    {
        ClienFax.sendKeys(fax);
    }
    public void setClientMobile(String mobile)
    {
        ClientMobile.sendKeys(mobile);
    }
    public void setClientEmail(String email)
    {
        clientEmail.sendKeys(email);
    }
    public void setClientWeb(String web)
    {
        ClientWeb.sendKeys(web);
    }
    public void setClientVatId(String vatId)
    {
        ClientVatId.sendKeys(vatId);
    }
    public void setClientTaxCode(String taxcode)
    {
        ClientTaxCode.sendKeys(taxcode);
    }
    public void setClientCountry(String country)
    {
     CountrySearch.click();
     ClientCountry.sendKeys(country);
    }
    public void setSave()
    {
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", Save);
        //Save.click();
    }
    public void setCancel()
    {
        Cancel.click();
    }

}
