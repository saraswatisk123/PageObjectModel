package Regression;

import com.invoiceplane.Pages.Login;
import com.invoiceplane.Pages.Menu;
import com.invoiceplane.utilities.Driver;
import org.apache.tools.ant.types.Resource;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import java.util.ResourceBundle;

/**
 * Created by Saraswati on 3/1/2018.
 */
public class LoginTest
{
    WebDriver driver= Driver.getdriver(Driver.Drivertypes.CHROME);


    @Test
    public void logintest()
    {
        ResourceBundle rb=ResourceBundle.getBundle("invoiceplane");
        String url=rb.getString("url");
        driver.get(url);
        Login login=new Login(driver);
        login.setTxtUserName("amol@gmail.com");
        login.setTxtpassname("admin123");
        login.clickLogin();



    }
}
