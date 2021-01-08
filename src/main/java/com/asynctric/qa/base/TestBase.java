package com.asynctric.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.asynctric.qa.util.TestUtil;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	
	
	public TestBase() throws IOException
	{
	 try{
		prop=new Properties();
		FileInputStream ip=new FileInputStream("D:\\Arun\\JAVA\\AsyncentricTest\\src\\main\\java\\com\\asynctric\\qa\\config\\config.properties");
		prop.load(ip);
	 	}	
	 		catch(FileNotFoundException e)
	 			{
	 				e.printStackTrace();
	 			}
	 		catch(IOException e)
	 			{
	 				e.printStackTrace();
	 			}
	}

	public static void Initialization()
	{
		String browsername = prop.getProperty("browser");
		if(browsername.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver","D:\\Selenium Setup\\Chrome2\\chromedriver.exe");
			System.setProperty("webdriver.chrome.silentOutput", "true");
			driver=new ChromeDriver();
		}
		
		else if(browsername.equals("FF"))
		{
			System.setProperty("webdriver.gecko.driver","D:\\Selenium Setup\\Mozila\\geckodriver.exe" );
			  driver=new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}


}
