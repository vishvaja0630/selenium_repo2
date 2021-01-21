package com.testautomationguru.container.test;

import java.net.MalformedURLException;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.testautomationguru.container.pages.SearchPage;

public class SearchTest throws MalformedURLException {

    @BeforeSuite
    public void initialDelay(){
        //intentionally added this as chrome/firefox containers take few ms to register
        //to hub - test fails saying hub does not have node!!
        //very rare
        Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
    }
    
    @BeforeTest
    public void setUp()  {
        System.out.println("before test");  
    }

   @Test()
    public void googleTest() {
        
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");
        capabilities.setCapability(ChromeOptions.CAPABILITY,options);
        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
        driver.manage().window().maximize();
        
        
        driver.get("https://www.google.com");  
        // get the current URL of the page  
        String URL= driver.getCurrentUrl();  
        System.out.print(URL);  
        //get the title of the page  
        String title = driver.getTitle();                  
        System.out.println(title);  
        if(title.equals("Google"))
            Assert.assertTrue(true);
        else
            Assert.assertTrue(false);
   
    }
    @AfterTest
    public void tearDown() throws InterruptedException {
        driver.close();
        driver.quit();
    }  

}
