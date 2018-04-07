package Regression.Clients;

import com.invoiceplane.Pages.Clients.AddClient;
import com.invoiceplane.Pages.Login;
import com.invoiceplane.Pages.Menu;
import com.invoiceplane.utilities.Driver;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.relevantcodes.extentreports.NetworkMode;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.Assertion;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ResourceBundle;

import static org.apache.poi.hemf.hemfplus.record.HemfPlusRecordType.fillPath;
import static org.apache.poi.hemf.hemfplus.record.HemfPlusRecordType.object;

/**
 * Created by Saraswati on 3/1/2018.
 */
public class AddClientTest {
    WebDriver driver = Driver.getdriver(Driver.Drivertypes.CHROME);
    ExtentReports extent;
    @BeforeClass
    public void before()
    {
        ResourceBundle rb = ResourceBundle.getBundle("invoiceplane");
        String url = rb.getString("url");
        extent = new ExtentReports("Report/report.html",true, NetworkMode.OFFLINE);

        driver.get(url);
        Login login = new Login(driver);
        login.setTxtUserName("amolujagare@gmail.com");
        login.setTxtpassname("admin123");
        login.clickLogin();
    }

    /*@Test
    public void AddClient() {

        AddClient addclient = new AddClient(driver);
        addclient.setClientName("saraswati");
        addclient.setClientAddress1("house number 89/3 Rcc");
        addclient.setClientAddress2("opposite to primary school");
        addclient.setClientCity("BELGAUM");
        JavascriptExecutor jse=(JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,100)","");
        addclient.setClientState("KARNATAKA");
        addclient.setClientZip("591308");
        addclient.setCountry("India");
        addclient.setClientPhone("0833223456");
        addclient.setClientMobile("7411545371");
        addclient.setClientEmail("saru@gmail.com");
        addclient.setClientWeb("www.cool.com");
        addclient.setSave();
        //addclient.setCancel();
    }*/
    static int tid=0;
        @Test(dataProvider = "getData")
        public void client(String ClientName, String ClientAddress1, String ClientAddress2, String ClientCity,
                           String ClientState, String  ClientZip, String ClientCountry, String ClientPhone,
                           String ClientFax, String ClientMobile, String ClinetEmail, String ClientWeb,
                           String ClientVatId, String ClientTaxCode, String ExpectedResult, String xpathofActualResult)
        {

            ExtentTest test=extent.startTest("addclient test -"+(tid++),"testing add clientpage inputs");
            Menu menu = new Menu(driver);
            menu.AddClient();
            AddClient addClient=new AddClient(driver);
            addClient.setClientName(ClientName);
            test.log(LogStatus.INFO,"Client name is added as:"+ClientName);
            addClient.setClientAddress1(ClientAddress1);
            test.log(LogStatus.INFO,"address1 is entered as:"+ClientAddress1);
            addClient.setClientAddress2(ClientAddress2);
            test.log(LogStatus.INFO,"address2 is entered as:"+ClientAddress2);
            addClient.setClientCity(ClientCity);
            test.log(LogStatus.INFO,"client city added as:"+ClientCity);
            addClient.setClientState(ClientState);
            test.log(LogStatus.INFO,"client state added as:"+ClientState);

            addClient.setClientZip(ClientZip);
            test.log(LogStatus.INFO,"client pincode is:"+ClientZip);

            addClient.setClientCountry(ClientCountry);
            test.log(LogStatus.INFO,"client country selected as:"+ClientCountry);

            addClient.setClientPhone(ClientPhone);
            test.log(LogStatus.INFO,"client phone number is:"+ClientPhone);

            addClient.setClienFax(ClientFax);
            test.log(LogStatus.INFO,"Client faxid is:"+ClientFax);
            addClient.setClientMobile(ClientMobile);
            test.log(LogStatus.INFO,"client mobile number is:"+ClientMobile);
            addClient.setClientEmail(ClinetEmail);
            test.log(LogStatus.INFO,"client emailid is:"+ClinetEmail);
            addClient.setClientWeb(ClientWeb);
            test.log(LogStatus.INFO,"client webaddress is:"+ClientWeb);
            addClient.setClientVatId(ClientVatId);
            test.log(LogStatus.INFO,"client vataid is:"+ClientVatId);
            addClient.setClientTaxCode(ClientTaxCode);
            test.log(LogStatus.INFO,"client taxcode is:"+ClientTaxCode);
            addClient.setSave();
            test.log(LogStatus.INFO,"all the entered details are saved");
            String actual;
        try {
                actual= driver.findElement(By.xpath(xpathofActualResult)).getText();

            }
        catch(Exception e)
            {
                actual="";
                test.log(LogStatus.ERROR,e);

            }

        try{
                Assert.assertEquals(actual,ExpectedResult);
                test.log(LogStatus.PASS,"Test is passed");
            }
        catch (AssertionError e)
            {
                test.log(LogStatus.FAIL,e);
            }


        extent.endTest(test);
}
        @AfterClass
        public void flushtest()
        {
            extent.flush();
        }

    @DataProvider
    public Object[][] getData() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("data/DataInput.xls");
        HSSFWorkbook workbook = new HSSFWorkbook(fileInputStream);
        HSSFSheet worksheet = workbook.getSheet("Sheet1");

        int rowCount = worksheet.getPhysicalNumberOfRows();

        Object[][] data = new Object[rowCount-1][17]; //rowcount-1;bcz headercase

        for (int i = 1; i < rowCount; i++)
        {
            HSSFRow row = worksheet.getRow(i);

            HSSFCell ClientName = row.getCell(0);
            if(ClientName==null)
            {
                data[i-1][0]="";
            }else {
                ClientName.setCellType(CellType.STRING);
                data[i - 1][0] = ClientName.getStringCellValue();
            }
            HSSFCell ClientAddress1 = row.getCell(1);
            if(ClientAddress1==null)
            {
                data[i-1][1]="";
            }
            else {
                ClientAddress1.setCellType(CellType.STRING);
                data[i - 1][1] = ClientAddress1.getStringCellValue();
            }
            HSSFCell ClientAddress2 = row.getCell(2);
            if(ClientAddress2==null)
            {
                data[i-1][2]="";
            }else {
                ClientAddress2.setCellType(CellType.STRING);
                data[i-1][2] = ClientAddress2.getStringCellValue();
            }

            HSSFCell ClientCity = row.getCell(3);
            if(ClientCity==null)
            {
                data[i-1][3]="";
            }else {
                ClientCity.setCellType(CellType.STRING);
                data[i - 1][3] = ClientCity.getStringCellValue();
            }
            HSSFCell ClientState = row.getCell(4);
            if(ClientState==null)
            {
                data[i-1][4]="";
            }else {
                ClientState.setCellType(CellType.STRING);
                data[i - 1][4] = ClientState.getStringCellValue();
            }
            HSSFCell ClientZip = row.getCell(5);

            if(ClientZip==null)
            {
                data[i-1][5]="";
            }else {
                ClientZip.setCellType(CellType.STRING);
                data[i - 1][5] = ClientZip.getStringCellValue();
            }
            HSSFCell ClientCountry = row.getCell(6);
            if(ClientCountry==null)
            {
                data[i-1][6]="";
            }else {
                ClientCountry.setCellType(CellType.STRING);
                data[i - 1][6] = ClientCountry.getStringCellValue();
            }
            HSSFCell ClientPhone = row.getCell(7);
            if(ClientPhone==null)
            {
                data[i-1][7]="";
            }else {
                ClientPhone.setCellType(CellType.STRING);
                data[i-1][7] = ClientPhone.getStringCellValue();
            }
            HSSFCell ClientFax = row.getCell(8);
            if(ClientFax==null)
            {
                data[i-1][8]="";
            }else {
                ClientFax.setCellType(CellType.STRING);
                data[i-1][8] = ClientFax.getStringCellValue();
            }
            HSSFCell ClientMobile = row.getCell(9);
            if(ClientMobile==null)
            {
                data[i-1][9]="";
            }else {
                ClientMobile.setCellType(CellType.STRING);
                data[i - 1][9] = ClientMobile.getStringCellValue();
            }
            HSSFCell ClientEmail = row.getCell(10);
            if(ClientEmail==null)
            {
                data[i-1][10]="";
            }else {
                ClientEmail.setCellType(CellType.STRING);
                data[i - 1][10] = ClientEmail.getStringCellValue();
            }
            HSSFCell ClientWeb = row.getCell(11);
            if(ClientWeb==null)
            {
                data[i-1][11]="";
            }else {
                ClientWeb.setCellType(CellType.STRING);
                data[i - 1][11] = ClientWeb.getStringCellValue();
            }
            HSSFCell ClientVatId = row.getCell(12);
            if(ClientVatId==null)
            {
                data[i-1][12]="";
            }else {
                ClientVatId.setCellType(CellType.STRING);
                data[i - 1][12] = ClientVatId.getStringCellValue();
            }
            HSSFCell ClientTaxCode = row.getCell(13);
            if(ClientTaxCode==null)
            {
                data[i-1][13]="";
            }else {
                ClientTaxCode.setCellType(CellType.STRING);
                data[i - 1][13] = ClientTaxCode.getStringCellValue();
            }
            HSSFCell ExpectedResult = row.getCell(14);
            if(ClientTaxCode==null)
            {
                data[i-1][14]="";
            }else {
                ExpectedResult.setCellType(CellType.STRING);
                data[i - 1][14] = ExpectedResult.getStringCellValue();
            }
            HSSFCell xpathofActualResult = row.getCell(15);
            if(ClientTaxCode==null)
            {
                data[i-1][15]="";
            }else {
                xpathofActualResult.setCellType(CellType.STRING);
                data[i - 1][15] = xpathofActualResult.getStringCellValue();
            }


        }return data;


    }
}
