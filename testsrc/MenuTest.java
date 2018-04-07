import com.invoiceplane.Pages.Login;
import com.invoiceplane.Pages.Menu;
import com.invoiceplane.utilities.Driver;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import java.util.ResourceBundle;

/**
 * Created by Saraswati on 3/4/2018.
 */
public class MenuTest
{
    WebDriver driver= Driver.getdriver(Driver.Drivertypes.CHROME);

    @Test
    public void Menu()
    {
        ResourceBundle rb=ResourceBundle.getBundle("invoiceplane");
        String url=rb.getString("url");
        driver.get(url);
        Login login=new Login(driver);
        login.setTxtUserName("amolujagare@gmail.com");
        login.setTxtpassname("admin123");
        login.clickLogin();

        Menu menu =new Menu(driver);
        menu.AddClient();
    }



}
