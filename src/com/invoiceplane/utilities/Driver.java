package com.invoiceplane.utilities;

import org.junit.rules.Timeout;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.concurrent.TimeUnit;

import static com.invoiceplane.utilities.Driver.Drivertypes.CHROME;
import static com.invoiceplane.utilities.Driver.Drivertypes.FIREFOX;
import static com.invoiceplane.utilities.Driver.Drivertypes.INTERNETEXPLORER;

/**
 * Created by Saraswati on 3/4/2018.
 */
public class Driver {
    private static WebDriver mydriver;
    private static long timeout = 10;

    public enum Drivertypes {
        INTERNETEXPLORER, FIREFOX, CHROME;
    }

    public static WebDriver getdriver(Drivertypes d) {
        if (mydriver == null) {
            switch (d) {
                case INTERNETEXPLORER:
                    System.setProperty("webdriver.ie.driver", "C:\\Program Files\\Internet Explorer");
                    mydriver = new InternetExplorerDriver();
                    break;
                case CHROME:
                    System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
                    mydriver = new ChromeDriver();
                    break;
                case FIREFOX:
                    System.setProperty("webdriver.gecko.driver", "");
                    mydriver = new FirefoxDriver();
                    break;
            }
            mydriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            mydriver.manage().window().maximize();

        }
        timeout = 10;
        return mydriver;
    }
}
