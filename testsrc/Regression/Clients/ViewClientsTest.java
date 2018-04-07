package Regression.Clients;

import com.invoiceplane.Pages.Clients.ViewClients;
import com.invoiceplane.Pages.Login;
import com.invoiceplane.Pages.Menu;
import com.invoiceplane.utilities.Driver;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.util.ResourceBundle;

/**
 * Created by Saraswati on 3/1/2018.
 */
public class ViewClientsTest
{
    WebDriver driver= Driver.getdriver(Driver.Drivertypes.CHROME);

    @Before
    public void before() {
        ResourceBundle rb = ResourceBundle.getBundle("invoiceplane");
        String url = rb.getString("url");
        driver.get(url);
        Login login = new Login(driver);
        login.setTxtUserName("amolujagare@gmail.com");
        login.setTxtpassname("admin123");
        login.clickLogin();
    }
    @org.junit.Test
    public void ViewClient()
    {
        Menu menu = new Menu(driver);
        menu.ViewClients();
            ViewClients viewclients=new ViewClients(driver);
            viewclients.setView();
        }
    }

