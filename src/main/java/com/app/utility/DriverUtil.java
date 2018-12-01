package com.app.utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

/**
 * The Class DriverUtil.
 */
public class DriverUtil {

    /** The driver. */
    private static WebDriver driver;

    /**
     * Sets the driver.
     */
    public static void setDriver() {
    	
    	if(Constant.BROWSER.equalsIgnoreCase("Chrome")) {
    		ChromeOptions options = new ChromeOptions();
            options.addArguments( "--disable-notifications" );
            System.setProperty( "webdriver.chrome.driver", Constant.DRIVER_PATH +"chromedriver.exe" );
            driver = new ChromeDriver( options );
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait( Constant.MAX_WAIT_TIME, TimeUnit.SECONDS );
    	}
    	else if(Constant.BROWSER.equalsIgnoreCase("IE")) {
            System.setProperty( "webdriver.ie.driver", Constant.DRIVER_PATH +"IEDriverServer.exe");
            driver = new InternetExplorerDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait( Constant.MAX_WAIT_TIME, TimeUnit.SECONDS );
    	}
    	else if(Constant.BROWSER.equalsIgnoreCase("FF")) {
            System.setProperty( "webdriver.gecko.driver", Constant.DRIVER_PATH +"geckodriver.exe" );
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait( Constant.MAX_WAIT_TIME, TimeUnit.SECONDS );
    	}
    	else
    		System.out.println("---------------- INVALID BROWSER INPUT ----------------");
    }

    /**
     * Gets the driver.
     *
     * @return the driver
     */
    public static WebDriver getDriver() {
        return driver;
    }
}

