package com.crm.qa.base;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.crm.qa.util.TestUtil;
import com.crm.qa.util.WebEventListener;

public class TestBase {
	public static Properties prop;
	public static WebDriver driver;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	public TestBase() {
		try {
			prop = new Properties();
			FileInputStream fis = new FileInputStream("C:/Users/ASUS/eclipse-workspace/FreeCRM/src/main/java/com/crm/qa/config/config.properties");
			prop.load(fis);
			Logger log = Logger.getLogger("devpinoyLogger");
			 log.debug("Property file loaded");
			String log4jPath = System.getProperty("user.dir")+"/src/main/resources/log4j.properties";
			PropertyConfigurator.configure(log4jPath);
			}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public static void initialization() {
		if(prop.getProperty("browser").equals("chrome")){
			System.setProperty("webdriver.chrome.driver", prop.getProperty("driverPath"));
			driver = new ChromeDriver();
		}
		else if(prop.getProperty("browser").equals("firefox")){
			System.setProperty("webdriver.gecko.driver", prop.getProperty("driverPath"));
			driver = new FirefoxDriver();			
		}
		
/*		e_driver = new EventFiringWebDriver(driver);
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver= e_driver;
		*/
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		//WebDriverWait wait = new WebDriverWait(driver, 10);
		//driver.manage().timeouts().pageLoadTimeout(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		 
	}
}
